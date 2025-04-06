package co.edu.unbosque.gestion_nomina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PaginasController {

    private final List<Map<String, String>> listaEmpleados = new ArrayList<>();

    public PaginasController() {
        listaEmpleados.add(Map.of(
                "id", "1",
                "nombre", "Laura Gómez",
                "cargo", "Contadora",
                "salario", "$3.000.000",
                "fechaIngreso", "2023-06-15"
        ));
        listaEmpleados.add(Map.of(
                "id", "2",
                "nombre", "Carlos Pérez",
                "cargo", "Analista",
                "salario", "$2.500.000",
                "fechaIngreso", "2022-09-10"
        ));
        listaEmpleados.add(Map.of(
                "id", "3",
                "nombre", "Diana Martínez",
                "cargo", "Auxiliar",
                "salario", "$2.000.000",
                "fechaIngreso", "2024-01-20"
        ));
    }

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        model.addAttribute("empleadosActivos", listaEmpleados.size());
        model.addAttribute("totalNomina", "7.500.000");
        return "index";
    }

    @GetMapping("/empleados")
    public String empleados(Model model) {
        model.addAttribute("empleados", listaEmpleados);
        return "empleados";
    }

    @PostMapping("/empleados/crear")
    public String guardarEmpleado(@RequestParam String nombre,
                                  @RequestParam String cargo,
                                  @RequestParam String salario,
                                  @RequestParam String fechaIngreso) {

        // Asigna ID incremental simulada
        String nuevoId = String.valueOf(listaEmpleados.size() + 1);

        listaEmpleados.add(Map.of(
                "id", nuevoId,
                "nombre", nombre,
                "cargo", cargo,
                "salario", salario,
                "fechaIngreso", fechaIngreso
        ));

        return "redirect:/empleados";
    }

    // Otros métodos
    @GetMapping("/nomina")
    public String mostrarNomina(Model model) {
        model.addAttribute("totalNomina", "7.500.000");
        model.addAttribute("ultimoPago", "03/04/2025");
        return "nomina";
    }

    @GetMapping("/configuracion")
    public String configuracion() {
        return "configuracion";
    }

    @GetMapping("/inicio")
    public String redirigirInicio() {
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
