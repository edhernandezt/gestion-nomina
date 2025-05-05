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
    public String mostrarVistaNovedad(Model model) {
        List<EmpleadoDTO> empleados = empleadoService.findAll();
        empleados.sort(Comparator.comparing(EmpleadoDTO::getPrimerApellido));

        List<TipoNovedadDTO> tipos = tipoNovedadService.findAll();
        List<NovedadDTO> novedades = novedadService.listarNovedades();

        model.addAttribute("empleados", empleados);
        model.addAttribute("tiposNovedad", tipos);
        model.addAttribute("novedades", novedades);

        return "novedad";
    }

    @PostMapping("/registrar")
    public String registrarNovedad(
            @RequestParam("idEmpleado") Integer idEmpleado,
            @RequestParam("idTipoNovedad") Integer idTipoNovedad,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(value = "observaciones", required = false) String observaciones,
            Model model) {
        try {
            novedadService.registrarNovedad(idEmpleado, idTipoNovedad, fechaInicio, fechaFin, observaciones);
            model.addAttribute("mensajeNovedad", "Novedad registrada correctamente.");
        } catch (Exception e) {
            model.addAttribute("errorNovedad", "Error al registrar novedad: " + e.getMessage());
        }

        return "redirect:/novedad";
    }
}
