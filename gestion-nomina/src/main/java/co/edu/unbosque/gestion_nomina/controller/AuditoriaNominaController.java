package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.AuditoriaNominaDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IAuditoriaNominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/auditoria-nomina")
public class AuditoriaNominaController {

    private final IAuditoriaNominaService auditoriaNominaService;

    @Autowired
    public AuditoriaNominaController(IAuditoriaNominaService auditoriaNominaService) {
        this.auditoriaNominaService = auditoriaNominaService;
    }

    @GetMapping
    public String mostrarAuditoriaNomina(
            @RequestParam(name = "fechaInicio", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,

            @RequestParam(name = "fechaFin", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,

            @RequestParam(name = "usuario", required = false) String usuario,
            Model model
    ) {
        if (fechaInicio == null || fechaFin == null) {
            LocalDate hoy = LocalDate.now();
            fechaInicio = hoy.withDayOfMonth(1);
            fechaFin = hoy.withDayOfMonth(hoy.lengthOfMonth());
        }

        if (usuario == null) {
            usuario = "";
        }

        List<AuditoriaNominaDTO> auditoria = auditoriaNominaService
                .buscarPorUsuarioYFechas(fechaInicio, fechaFin, usuario);

        model.addAttribute("auditorias", auditoria);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("usuario", usuario);

        return "auditoria_nomina";
    }
}
