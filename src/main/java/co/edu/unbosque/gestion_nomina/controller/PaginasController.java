package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PaginasController {

    @Autowired
    private ICrud<EmpleadoDTO, Integer> empleadoService;

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        List<EmpleadoDTO> empleados = empleadoService.findAll();

        int empleadosActivos = empleados.size();
        BigDecimal totalNomina = empleados.stream()
                .map(e -> e.getSalarioBasico() != null ? e.getSalarioBasico() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("empleadosActivos", empleadosActivos);
        model.addAttribute("totalNomina", totalNomina);
        return "index";
    }

    @GetMapping("/opciones-nomina")
    public String mostrarVistaOpcionesNomina() {
        return "opciones_nomina";
    }

    @GetMapping("/administracion")
    public String configuracion() {
        return "administracion";
    }

}
