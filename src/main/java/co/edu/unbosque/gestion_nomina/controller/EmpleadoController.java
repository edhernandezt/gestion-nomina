package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.exceptions.EmpleadoException;
import co.edu.unbosque.gestion_nomina.model.dto.*;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private ICrud<EmpleadoDTO, Integer> empleadoService;

    @Autowired private ICrud<CargoDTO, Integer> cargoService;
    @Autowired private ICrud<DepartamentoDTO, Integer> departamentoService;
    @Autowired private ICrud<EstadoCivilDTO, Integer> estadoCivilService;
    @Autowired private ICrud<ArlDTO, Integer> arlService;
    @Autowired private ICrud<EpsDTO, Integer> epsService;
    @Autowired private ICrud<FondoPensionDTO, Integer> fondoPensionService;
    @Autowired private ICrud<TipoContratoDTO, Integer> tipoContratoService;
    @Autowired private ICrud<FactorRiesgoDTO, Integer> riesgoService;
    @Autowired private ICrud<EntidadBancariaDTO, Integer> bancoService;
    @Autowired private ICrud<EstadoDTO, Integer> estadoService;

    @GetMapping
    public String mostrarVistaPrincipal(Model model) {
        model.addAttribute("empleadoDTO", new EmpleadoDTO());
        model.addAttribute("empleadoBuscado", null); // Para la búsqueda
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("cargos", cargoService.findAll());
        model.addAttribute("departamentos", departamentoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());
        model.addAttribute("arls", arlService.findAll());
        model.addAttribute("epss", epsService.findAll());
        model.addAttribute("fondosPension", fondoPensionService.findAll());
        model.addAttribute("tiposContrato", tipoContratoService.findAll());
        model.addAttribute("riesgos", riesgoService.findAll());
        model.addAttribute("bancos", bancoService.findAll());
        model.addAttribute("estados", estadoService.findAll());
        return "empleado";
    }

    @PostMapping("/crear")
    public String crearEmpleado(@ModelAttribute("empleadoDTO") EmpleadoDTO dto) {
        empleadoService.create(dto);
        return "redirect:/empleado";
    }

    @PostMapping("/buscar")
    public String buscarEmpleadoPorId(@RequestParam Integer idEmpleadoBuscar, Model model) {
        model.addAttribute("empleadoDTO", new EmpleadoDTO());
        model.addAttribute("empleadoBuscado", empleadoService.find(idEmpleadoBuscar).orElse(null));
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("cargos", cargoService.findAll());
        model.addAttribute("departamentos", departamentoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());
        model.addAttribute("arls", arlService.findAll());
        model.addAttribute("epss", epsService.findAll());
        model.addAttribute("fondosPension", fondoPensionService.findAll());
        model.addAttribute("tiposContrato", tipoContratoService.findAll());
        model.addAttribute("riesgos", riesgoService.findAll());
        model.addAttribute("bancos", bancoService.findAll());
        model.addAttribute("estados", estadoService.findAll());
        return "empleado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.delete(id);
        return "redirect:/empleado";
    }

    @GetMapping("/editar/{id}")
    public String cargarParaEditar(@PathVariable Integer id, Model model) {
        EmpleadoDTO dto = empleadoService.find(id).orElseThrow(() -> new EmpleadoException("Empleado no encontrado"));
        model.addAttribute("empleadoDTO", dto);
        model.addAttribute("empleadoBuscado", null);
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("cargos", cargoService.findAll());
        model.addAttribute("departamentos", departamentoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());
        model.addAttribute("arls", arlService.findAll());
        model.addAttribute("epss", epsService.findAll());
        model.addAttribute("fondosPension", fondoPensionService.findAll());
        model.addAttribute("tiposContrato", tipoContratoService.findAll());
        model.addAttribute("riesgos", riesgoService.findAll());
        model.addAttribute("bancos", bancoService.findAll());
        model.addAttribute("estados", estadoService.findAll());
        return "empleado";
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@ModelAttribute("empleadoDTO") EmpleadoDTO dto) {
        empleadoService.update(dto.getIdEmpleado(), dto);
        return "redirect:/empleado";
    }
}
