package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.LiquidacionPrestacionDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ILiquidacionPrestacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Year;
import java.util.List;

@Controller
@RequestMapping("/liquidacion-prestaciones")
public class LiquidacionPrestacionesController {

    private final ILiquidacionPrestacionService liquidacionService;

    @Autowired
    public LiquidacionPrestacionesController(ILiquidacionPrestacionService liquidacionService) {
        this.liquidacionService = liquidacionService;
    }

    @GetMapping
    public String mostrarVistaLiquidaciones(
            @RequestParam(name = "anio", required = false) Integer anio,
            @RequestParam(name = "semestre", required = false) Integer semestre,
            @RequestParam(name = "nombre", required = false) String nombre,
            Model model) {

        if (anio == null) {
            anio = Year.now().getValue();
        }
        if (semestre == null) {
            semestre = 1;
        }
        if (nombre == null) {
            nombre = "";
        }

        List<LiquidacionPrestacionDTO> liquidaciones = liquidacionService.buscarPorNombreYPeriodo(anio, semestre, nombre);

        model.addAttribute("liquidaciones", liquidaciones);
        model.addAttribute("anio", anio);
        model.addAttribute("semestre", semestre);
        model.addAttribute("nombre", nombre);

        return "liquidacion_prestaciones";
    }

    @PostMapping("/generar")
    public String generarLiquidaciones(
            @RequestParam("anio") Integer anio,
            @RequestParam("semestre") Integer semestre,
            RedirectAttributes redirectAttributes) {

        try {
            liquidacionService.generarLiquidacionPorSemestre(anio, semestre);
            redirectAttributes.addFlashAttribute("mensajeLiquidacion", "Liquidaciones generadas exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorLiquidacion", "Error al generar liquidaciones: " + e.getMessage());
        }

        return "redirect:/liquidacion-prestaciones?anio=" + anio + "&semestre=" + semestre;
    }
}
