package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.DeduccionDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDeduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/deduccion")
public class DeduccionController {

    private final IDeduccionService deduccionService;

    @Autowired
    public DeduccionController(IDeduccionService deduccionService) {
        this.deduccionService = deduccionService;
    }

    @GetMapping
    public String mostrarVistaDeducciones(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        List<DeduccionDTO> deducciones;
        if (fechaInicio != null && fechaFin != null) {
            // Puedes implementar un método en el servicio si deseas filtrar por fechas
            deducciones = deduccionService.findByFechas(fechaInicio, fechaFin);
        } else {
            deducciones = deduccionService.findAll();
        }

        model.addAttribute("deducciones", deducciones);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "deduccion";
    }

    @PostMapping("/generar")
    public String generarDeducciones(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {
        try {
            deduccionService.generarDeduccionesMensual(fechaInicio, fechaFin);
            model.addAttribute("mensajeDeduccion", "Deducciones generadas exitosamente.");
        } catch (Exception e) {
            model.addAttribute("errorDeduccion", "Error al generar deducciones: " + e.getMessage());
        }

        return "redirect:/deduccion";
    }
}
