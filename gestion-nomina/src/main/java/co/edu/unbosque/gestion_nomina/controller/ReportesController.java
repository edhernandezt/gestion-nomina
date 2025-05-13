package co.edu.unbosque.gestion_nomina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReportesController {

    @GetMapping
    public String verMenuReportes() {
        return "reportes";
    }

    @GetMapping("/general")
    public String reporteGeneral() {
        return "reporte_general";
    }

    @GetMapping("/incapacidades")
    public String reporteIncapacidades() {
        return "reporte_incapacidades";
    }

    @GetMapping("/exoneraciones")
    public String reporteExoneraciones() {
        return "reporte_exoneraciones";
    }

    @GetMapping("/activos")
    public String reporteActivos() {
        return "reporte_activos";
    }

    @GetMapping("/historial")
    public String reporteHistorial() {
        return "reporte_historial";
    }

    @GetMapping("/aportes")
    public String reporteAportes() {
        return "reporte_aportes";
    }

    @GetMapping("/deducciones")
    public String reporteDeducciones() {
        return "reporte_deducciones";
    }
}
