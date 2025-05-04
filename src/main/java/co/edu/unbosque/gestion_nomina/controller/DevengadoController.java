package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.TipoHoraExtraDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDevengadoService;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHorasExtrasService;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/devengado")
public class DevengadoController {

    private final IDevengadoService devengadoService;
    private final IHorasExtrasService horasExtrasService;
    private final ICrud<TipoHoraExtraDTO, Integer> tipoHoraExtraService;
    private final ICrud<EmpleadoDTO, Integer> empleadoService;

    @Autowired
    public DevengadoController(
            IDevengadoService devengadoService,
            IHorasExtrasService horasExtrasService,
            ICrud<TipoHoraExtraDTO, Integer> tipoHoraExtraService,
            ICrud<EmpleadoDTO, Integer> empleadoService) {
        this.devengadoService = devengadoService;
        this.horasExtrasService = horasExtrasService;
        this.tipoHoraExtraService = tipoHoraExtraService;
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public String mostrarVistaDevengado(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {

        List<EmpleadoDTO> empleados = empleadoService.findAll();
        empleados.sort(Comparator.comparing(EmpleadoDTO::getPrimerApellido));

        List<DevengadoDTO> devengados;
        if (fechaInicio != null && fechaFin != null) {
            devengados = devengadoService.findByFechas(fechaInicio, fechaFin);
        } else {
            devengados = devengadoService.findAll();
        }

        List<TipoHoraExtraDTO> tiposHoraExtra = tipoHoraExtraService.findAll();

        model.addAttribute("empleados", empleados);
        model.addAttribute("devengados", devengados);
        model.addAttribute("tiposHoraExtra", tiposHoraExtra);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);

        return "devengado";
    }

    @PostMapping("/generar")
    public String generarDevengados(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Model model) {
        try {
            devengadoService.generarDevengadosMensual(fechaInicio, fechaFin);
            model.addAttribute("mensajeDevengado", "Devengados generados exitosamente.");
        } catch (Exception e) {
            model.addAttribute("errorDevengado", "Error al generar devengados: " + e.getMessage());
        }
        return "redirect:/devengado?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }

    @PostMapping("/filtrar")
    public String filtrarDevengados(
            @RequestParam("fechaInicioFiltro") LocalDate fechaInicio,
            @RequestParam("fechaFinFiltro") LocalDate fechaFin,
            Model model) {

        List<EmpleadoDTO> empleados = empleadoService.findAll();
        empleados.sort(Comparator.comparing(EmpleadoDTO::getPrimerApellido));

        List<DevengadoDTO> devengadosFiltrados = devengadoService.findByFechas(fechaInicio, fechaFin);
        List<TipoHoraExtraDTO> tiposHoraExtra = tipoHoraExtraService.findAll();

        model.addAttribute("empleados", empleados);
        model.addAttribute("devengados", devengadosFiltrados);
        model.addAttribute("tiposHoraExtra", tiposHoraExtra);
        model.addAttribute("fechaInicioFiltro", fechaInicio);
        model.addAttribute("fechaFinFiltro", fechaFin);

        return "devengado";
    }

    @PostMapping("/horas-extras")
    public String registrarHorasExtras(
            @RequestParam("idDevengado") Integer idDevengado,
            @RequestParam("idTipoHoraExtra") Integer idTipoHoraExtra,
            @RequestParam("cantidadHoras") BigDecimal cantidadHoras,
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaFin") LocalDate fechaFin,
            Model model) {
        try {
            horasExtrasService.registrarHorasExtras(idDevengado, idTipoHoraExtra, cantidadHoras, fechaInicio, fechaFin);
            model.addAttribute("mensajeHorasExtras", "Horas extras registradas correctamente.");
        } catch (Exception e) {
            model.addAttribute("errorHorasExtras", "Error al registrar horas extras: " + e.getMessage());
        }

        return "redirect:/devengado?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
