package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.service.interfaces.IDesprendibleMasivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping("/desprendibles")
public class DesprendibleController {

    private final IDesprendibleMasivoService desprendibleMasivoService;

    @Autowired
    public DesprendibleController(IDesprendibleMasivoService desprendibleMasivoService) {
        this.desprendibleMasivoService = desprendibleMasivoService;
    }

    @GetMapping
    public String mostrarFormularioDesprendibles() {
        return "generar_desprendibles";
    }

    @GetMapping("/generar")
    public ResponseEntity<byte[]> generarZipDesprendibles(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) throws IOException {

        byte[] zipBytes = desprendibleMasivoService.generarDesprendiblesComoZip(fechaInicio, fechaFin);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=desprendibles_nomina.zip")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(zipBytes);
    }
}


