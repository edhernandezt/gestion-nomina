package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.HorasExtrasDTO;
import co.edu.unbosque.gestion_nomina.model.dto.TipoHoraExtraDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHorasExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/horas-extras")
public class HorasExtrasController {

    private final IHorasExtrasService horasExtrasService;
    private final ICrud<EmpleadoDTO, Integer> empleadoService;
    private final ICrud<TipoHoraExtraDTO, Integer> tipoHoraExtraService;

    @Autowired
    public HorasExtrasController(
            IHorasExtrasService horasExtrasService,
            ICrud<EmpleadoDTO, Integer> empleadoService,
            ICrud<TipoHoraExtraDTO, Integer> tipoHoraExtraService) {
        this.horasExtrasService = horasExtrasService;
        this.empleadoService = empleadoService;
        this.tipoHoraExtraService = tipoHoraExtraService;
    }

    @GetMapping
    public String mostrarVistaRegistroHoras(
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model
    ) {
        List<EmpleadoDTO> empleados = empleadoService.findAll();
        empleados.sort(Comparator.comparing(EmpleadoDTO::getPrimerApellido));

        List<TipoHoraExtraDTO> tipos = tipoHoraExtraService.findAll();

        // Rango por defecto: mes actual
        if (fechaInicio == null || fechaFin == null) {
            LocalDate ahora = LocalDate.now();
            fechaInicio = ahora.withDayOfMonth(1);
            fechaFin = ahora.withDayOfMonth(ahora.lengthOfMonth());
        }

        if (keyword == null) keyword = "";

        List<HorasExtrasDTO> horasExtras = horasExtrasService.findByFechasAndNombre(fechaInicio, fechaFin, keyword);

        model.addAttribute("empleados", empleados);
        model.addAttribute("tiposHoraExtra", tipos);
        model.addAttribute("horasExtras", horasExtras);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("keyword", keyword);

        return "horas_extras";
    }

    @PostMapping("/registrar")
    public String registrarHorasExtras(
            @RequestParam("idEmpleado") Integer idEmpleado,
            @RequestParam("idTipoHoraExtra") Integer idTipoHoraExtra,
            @RequestParam("cantidadHoras") BigDecimal cantidadHoras,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            RedirectAttributes redirectAttributes
    ) {

        if (fechaFin.isBefore(fechaInicio)) {
            redirectAttributes.addFlashAttribute("errorHoras", "La fecha fin no puede ser anterior a la fecha inicio.");
            return "redirect:/horas-extras";
        }

        try {
            horasExtrasService.registrarHorasExtrasEmpleado(idEmpleado, idTipoHoraExtra, cantidadHoras, fechaInicio, fechaFin);
            redirectAttributes.addFlashAttribute("mensajeHoras", "Horas extras registradas correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorHoras", "Error al registrar horas extras: " + e.getMessage());
        }

        return "redirect:/horas-extras?fechaInicio=" + fechaInicio + "&fechaFin=" + fechaFin;
    }
}
