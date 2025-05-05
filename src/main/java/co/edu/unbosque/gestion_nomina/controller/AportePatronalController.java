package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.AportePatronalDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IAportePatronalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/aporte-patronal")
public class AportePatronalController {

    private final IAportePatronalService aportePatronalService;

    @Autowired
    public AportePatronalController(IAportePatronalService aportePatronalService) {
        this.aportePatronalService = aportePatronalService;
    }

    @GetMapping
    public String mostrarVistaAportes(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        List<AportePatronalDTO> aportes;
        if (fechaInicio != null && fechaFin != null) {
            aportes = aportePatronalService.findByFechas(fechaInicio, fechaFin);
        } else {
            aportes = aportePatronalService.findAll();
        }

        model.addAttribute("aportes", aportes);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "aporte_patronal";
    }

    @PostMapping("/generar")
    public String generarAportes(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        try {
            aportePatronalService.generarAportesMensuales(fechaInicio, fechaFin);
            model.addAttribute("mensajeAporte", "Aportes patronales generados exitosamente.");
        } catch (Exception e) {
            model.addAttribute("errorAporte", "Error al generar aportes: " + e.getMessage());
        }

        return "redirect:/aporte-patronal?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
