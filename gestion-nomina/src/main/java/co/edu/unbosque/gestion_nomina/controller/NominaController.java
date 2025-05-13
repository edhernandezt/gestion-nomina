package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.NominaDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.INominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/nomina-mensual")
public class NominaController {

    private final INominaService nominaService;

    @Autowired
    public NominaController(INominaService nominaService) {
        this.nominaService = nominaService;
    }

    @GetMapping
    public String mostrarVistaNomina(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        // Si no se pasan fechas, se usa el mes actual
        if (fechaInicio == null || fechaFin == null) {
            LocalDate hoy = LocalDate.now();
            fechaInicio = hoy.withDayOfMonth(1);
            fechaFin = hoy.withDayOfMonth(hoy.lengthOfMonth());
        }

        if (keyword == null) {
            keyword = "";
        }

        List<NominaDTO> nominas = nominaService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("nominas", nominas);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);
        return "generar_nomina";
    }

    @PostMapping("/generar")
    public String generarNomina(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            RedirectAttributes redirectAttributes) {

        try {
            nominaService.generarNominaMensual(fechaInicio, fechaFin);
            redirectAttributes.addFlashAttribute("mensajeNomina", "Nómina generada exitosamente.");
        } catch (Exception e) {
            if (e.getMessage().contains("50001")) {
                redirectAttributes.addFlashAttribute("errorNomina", "Ya existe una nómina para ese rango de fechas.");
            } else {
                redirectAttributes.addFlashAttribute("errorNomina",
                        e.getCause() != null && e.getCause().getMessage().contains("Ya existe una nómina")
                                ? "Ya existe una nómina para ese rango de fechas."
                                : "Error al generar la nómina.");
            }
            return "redirect:/nomina-mensual";
        }

        return "redirect:/nomina-mensual?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
