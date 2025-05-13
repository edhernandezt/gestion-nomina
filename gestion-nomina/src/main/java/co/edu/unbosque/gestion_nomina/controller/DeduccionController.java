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
        List<DeduccionDTO> deducciones = deduccionService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("deducciones", deducciones);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "deduccion";
    }

}
