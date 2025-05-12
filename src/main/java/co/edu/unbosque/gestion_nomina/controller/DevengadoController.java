package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDevengadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/devengado")
public class DevengadoController {

    private final IDevengadoService devengadoService;

    @Autowired
    public DevengadoController(IDevengadoService devengadoService) {
        this.devengadoService = devengadoService;
    }

    @GetMapping
    public String mostrarVistaDevengados(
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

        List<DevengadoDTO> devengados = devengadoService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("devengados", devengados);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "devengado";
    }
}
