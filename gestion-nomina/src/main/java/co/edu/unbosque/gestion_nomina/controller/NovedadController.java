package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.NovedadDTO;
import co.edu.unbosque.gestion_nomina.model.dto.TipoNovedadDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import co.edu.unbosque.gestion_nomina.service.interfaces.INovedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/novedad")
public class NovedadController {

    private final INovedadService novedadService;
    private final ICrud<EmpleadoDTO, Integer> empleadoService;
    private final ICrud<TipoNovedadDTO, Integer> tipoNovedadService;

    @Autowired
    public NovedadController(
            INovedadService novedadService,
            ICrud<EmpleadoDTO, Integer> empleadoService,
            ICrud<TipoNovedadDTO, Integer> tipoNovedadService) {
        this.novedadService = novedadService;
        this.empleadoService = empleadoService;
        this.tipoNovedadService = tipoNovedadService;
    }

    @GetMapping
    public String mostrarVistaNovedad(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model
    ) {
        if (fechaInicio == null || fechaFin == null) {
            LocalDate now = LocalDate.now();
            fechaInicio = now.withDayOfMonth(1);
            fechaFin = now.withDayOfMonth(now.lengthOfMonth());
        }

        if (keyword == null) {
            keyword = "";
        }

        List<EmpleadoDTO> empleados = empleadoService.findAll();
        empleados.sort(Comparator.comparing(EmpleadoDTO::getPrimerApellido));

        List<TipoNovedadDTO> tipos = tipoNovedadService.findAll();
        List<NovedadDTO> novedades = novedadService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("empleados", empleados);
        model.addAttribute("tiposNovedad", tipos);
        model.addAttribute("novedades", novedades);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "novedad";
    }

    @PostMapping("/registrar")
    public String registrarNovedad(
            @RequestParam("idEmpleado") Integer idEmpleado,
            @RequestParam("idTipoNovedad") Integer idTipoNovedad,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "observaciones", required = false) String observaciones,
            RedirectAttributes redirectAttributes) {

        if (fechaFin.isBefore(fechaInicio)) {
            redirectAttributes.addFlashAttribute("errorNovedad", "La fecha fin no puede ser anterior a la fecha inicio.");
            return "redirect:/novedad";
        }

        try {
            novedadService.registrarNovedad(idEmpleado, idTipoNovedad, fechaInicio, fechaFin, observaciones);
            redirectAttributes.addFlashAttribute("mensajeNovedad", "Novedad registrada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorNovedad", "Error al registrar novedad: " + e.getMessage());
        }

        return "redirect:/novedad?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
