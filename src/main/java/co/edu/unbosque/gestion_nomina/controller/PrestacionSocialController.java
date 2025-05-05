package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.PrestacionSocialDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IPrestacionSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/prestaciones")
public class PrestacionSocialController {

    private final IPrestacionSocialService prestacionService;

    @Autowired
    public PrestacionSocialController(IPrestacionSocialService prestacionService) {
        this.prestacionService = prestacionService;
    }

    @GetMapping
    public String mostrarVistaPrestaciones(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        List<PrestacionSocialDTO> prestaciones;
        if (fechaInicio != null && fechaFin != null) {
            prestaciones = prestacionService.findByFechas(fechaInicio, fechaFin);
        } else {
            prestaciones = prestacionService.findAll();
        }

        model.addAttribute("prestaciones", prestaciones);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        return "prestacion_social";
    }

    @PostMapping("/generar")
    public String generarPrestaciones(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {
        try {
            prestacionService.generarPrestacionesMensual(fechaInicio, fechaFin);
            model.addAttribute("mensajePrestacion", "Prestaciones generadas exitosamente.");
        } catch (Exception e) {
            model.addAttribute("errorPrestacion", "Error al generar prestaciones: " + e.getMessage());
        }

        return "redirect:/prestaciones?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
