package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.exceptions.CargoException;
import co.edu.unbosque.gestion_nomina.model.dto.CargoDTO;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    private ICrud<CargoDTO, Integer> cargoService;

    public CargoController(ICrud<CargoDTO, Integer> cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public String mostrarVistaPrincipal(Model model) {
        model.addAttribute("cargoDTO", new CargoDTO()); // para el formulario
        model.addAttribute("cargoBuscado", null); // para la búsqueda por ID
        model.addAttribute("cargos", cargoService.findAll()); // para la tabla
        return "cargos";
    }

    @PostMapping("/crear")
    public String crearCargo(@ModelAttribute("cargoDTO") CargoDTO dto) {
        cargoService.create(dto);
        return "redirect:/cargos";
    }

    @PostMapping("/buscar")
    public String buscarPorId(@RequestParam Integer idCargoBuscar, Model model) {
        model.addAttribute("cargoDTO", new CargoDTO());
        model.addAttribute("cargoBuscado", cargoService.find(idCargoBuscar).orElse(null));
        model.addAttribute("cargos", cargoService.findAll());
        return "cargos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCargo(@PathVariable Integer id) {
        cargoService.delete(id);
        return "redirect:/cargos";
    }

    @GetMapping("/editar/{id}")
    public String cargarParaEditar(@PathVariable Integer id, Model model) {
        CargoDTO dto = cargoService.find(id).orElseThrow(() -> new CargoException("Cargo no encontrado"));
        model.addAttribute("cargoDTO", dto);
        model.addAttribute("cargoBuscado", null);
        model.addAttribute("cargos", cargoService.findAll());
        return "cargos";
    }

    @PostMapping("/actualizar")
    public String actualizarCargo(@ModelAttribute("cargoDTO") CargoDTO dto) {
        cargoService.update(dto.getIdCargo(), dto);
        return "redirect:/cargos";
    }

    @GetMapping("/buscar")
    public String buscarCargoPorNombre(@RequestParam("keyword") String keyword, Model model) {
        List<CargoDTO> resultados = cargoService.buscarPorNombreOCargo(keyword);
        model.addAttribute("cargos", resultados);
        model.addAttribute("cargoDTO", new CargoDTO());
        return "cargos";
    }



}

