package co.edu.unbosque.gestion_nomina.controller.implementations;

import co.edu.unbosque.gestion_nomina.exceptions.DepartamentoException;
import co.edu.unbosque.gestion_nomina.model.dto.DepartamentoDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final ICrud<DepartamentoDTO, Integer> departamentoService;

    public DepartamentoController(ICrud<DepartamentoDTO, Integer> departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public String mostrarVista(Model model) {
        model.addAttribute("departamentoDTO", new DepartamentoDTO());
        model.addAttribute("departamentoBuscado", null);
        model.addAttribute("departamentos", departamentoService.findAll());
        return "departamentos";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute("departamentoDTO") DepartamentoDTO dto) {
        departamentoService.create(dto);
        return "redirect:/departamentos";
    }

    @PostMapping("/buscar")
    public String buscarPorId(@RequestParam Integer idDepartamentoBuscar, Model model) {
        model.addAttribute("departamentoDTO", new DepartamentoDTO());

        DepartamentoDTO departamento = departamentoService.find(idDepartamentoBuscar).orElse(null); // lanza excepción si no existe
        model.addAttribute("departamentoBuscado", departamento);
        model.addAttribute("departamentos", departamentoService.findAll());
        return "departamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        DepartamentoDTO dto = departamentoService.find(id).orElseThrow(() -> new DepartamentoException("Departamento no encontrado"));
        model.addAttribute("departamentoDTO", dto);
        model.addAttribute("departamentoBuscado", null);
        model.addAttribute("departamentos", departamentoService.findAll());
        return "departamentos";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("departamentoDTO") DepartamentoDTO dto) {
        departamentoService.update(dto.getIdDepartamento(), dto);
        return "redirect:/departamentos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        departamentoService.delete(id);
        return "redirect:/departamentos";
    }
}
