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
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        // Si no se pasan fechas, usar mes actual
        if (fechaInicio == null || fechaFin == null) {
            LocalDate now = LocalDate.now();
            fechaInicio = now.withDayOfMonth(1);
            fechaFin = now.withDayOfMonth(now.lengthOfMonth());
        }

        if (keyword == null) {
            keyword = "";
        }

        List<PrestacionSocialDTO> prestaciones = prestacionService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("prestaciones", prestaciones);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "prestacion_social";
    }
}
