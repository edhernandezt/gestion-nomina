package co.edu.unbosque.gestion_nomina.exceptions;

import co.edu.unbosque.gestion_nomina.model.dto.CargoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.DepartamentoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.service.implementations.EmpleadoService;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ICrud<CargoDTO, Integer> cargoService;
    @Autowired
    private ICrud<DepartamentoDTO, Integer> departamentoService;
    @Autowired
    private ICrud<EmpleadoDTO, Integer> empleadoService;

    @ExceptionHandler(CargoException.class)
    public String manejarCargoException(CargoException ex, Model model) {
        model.addAttribute("mensajeError", ex.getMessage());
        model.addAttribute("cargoDTO", new CargoDTO());
        model.addAttribute("cargoBuscado", null);
        model.addAttribute("cargos", cargoService.findAll());

        return "cargos";
    }

    @ExceptionHandler(DepartamentoException.class)
    public String manejarDepartamentoException(DepartamentoException ex, Model model) {
        model.addAttribute("mensajeError", ex.getMessage());
        model.addAttribute("departamentoDTO", new DepartamentoDTO());
        model.addAttribute("departamentoBuscado", null);
        model.addAttribute("departamentos", departamentoService.findAll());

        return "departamentos";
    }

    @ExceptionHandler(EmpleadoException.class)
    public String manejarEmpleadoException(EmpleadoException ex, Model model) {
        model.addAttribute("mensajeError", ex.getMessage());
        model.addAttribute("empleadoDTO", new EmpleadoDTO());
        model.addAttribute("empleados", empleadoService.findAll());
        return "empleados";
    }
}
