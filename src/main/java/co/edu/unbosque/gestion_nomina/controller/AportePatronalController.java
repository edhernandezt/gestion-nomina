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

    private final IAportePatronalService aporteService;

    @Autowired
    public AportePatronalController(IAportePatronalService aporteService) {
        this.aporteService = aporteService;
    }

    @GetMapping
    public String mostrarVistaAportes(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        if (fechaInicio == null || fechaFin == null) {
            LocalDate now = LocalDate.now();
            fechaInicio = now.withDayOfMonth(1);
            fechaFin = now.withDayOfMonth(now.lengthOfMonth());
        }

        if (keyword == null) {
            keyword = "";
        }

        List<AportePatronalDTO> aportes = aporteService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("aportes", aportes);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "aporte_patronal";
    }
}
