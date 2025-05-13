package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.exceptions.EmpleadoException;
import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.model.entity.*;
import co.edu.unbosque.gestion_nomina.repository.*;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements ICrud<EmpleadoDTO, Integer> {

    @Autowired private EmpleadoRepository empleadoRepository;
    @Autowired private CargoRepository cargoRepository;
    @Autowired private DepartamentoRepository departamentoRepository;
    @Autowired private EstadoCivilRepository estadoCivilRepository;
    @Autowired private ArlRepository arlRepository;
    @Autowired private EpsRepository epsRepository;
    @Autowired private FondoPensionRepository fondoPensionRepository;
    @Autowired private TipoContratoRepository tipoContratoRepository;
    @Autowired private FactorRiesgoRepository factorRiesgoRepository;
    @Autowired private EntidadBancariaRepository entidadBancariaRepository;
    @Autowired private EstadoRepository estadoRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public void create(EmpleadoDTO dto) {
        Empleado empleado = new Empleado();
        modelMapper.map(dto, empleado);

        empleado.setCargo(cargoRepository.findById(dto.getCargoId()).orElseThrow(() -> new EmpleadoException("Cargo no encontrado")));
        empleado.setDepartamento(departamentoRepository.findById(dto.getDepartamentoId()).orElseThrow(() -> new EmpleadoException("Departamento no encontrado")));
        empleado.setEstadoCivil(estadoCivilRepository.findById(dto.getEstadoCivilId()).orElseThrow(() -> new EmpleadoException("Estado civil no encontrado")));
        empleado.setArl(arlRepository.findById(dto.getArlId()).orElseThrow(() -> new EmpleadoException("ARL no encontrada")));
        empleado.setEps(epsRepository.findById(dto.getEpsId()).orElseThrow(() -> new EmpleadoException("EPS no encontrada")));
        empleado.setFondoPension(fondoPensionRepository.findById(dto.getFondoPensionId()).orElseThrow(() -> new EmpleadoException("Fondo de pensión no encontrado")));
        empleado.setTipoContrato(tipoContratoRepository.findById(dto.getTipoContratoId()).orElseThrow(() -> new EmpleadoException("Tipo de contrato no encontrado")));
        empleado.setRiesgo(factorRiesgoRepository.findById(dto.getRiesgoId()).orElseThrow(() -> new EmpleadoException("Factor de riesgo no encontrado")));
        empleado.setBanco(entidadBancariaRepository.findById(dto.getBancoId()).orElseThrow(() -> new EmpleadoException("Banco no encontrado")));
        empleado.setEstado(estadoRepository.findById(dto.getEstadoId()).orElseThrow(() -> new EmpleadoException("Estado no encontrado")));

        empleadoRepository.save(empleado);
    }

    @Override
    public Optional<EmpleadoDTO> find(Integer id) {
        return empleadoRepository.findById(id)
                .map(e -> modelMapper.map(e, EmpleadoDTO.class));
    }

    @Override
    public void update(Integer id, EmpleadoDTO dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoException("Empleado no encontrado"));

        // Campos simples directamente
        empleado.setCorreoElectronico(dto.getCorreoElectronico());
        empleado.setCuentaBancaria(dto.getCuentaBancaria());
        empleado.setDireccion(dto.getDireccion());
        empleado.setTelefono(dto.getTelefono());
        empleado.setSalarioBasico(dto.getSalarioBasico());

        // Relaciones buscadas por ID
        empleado.setCargo(cargoRepository.findById(dto.getCargoId()).orElse(null));
        empleado.setDepartamento(departamentoRepository.findById(dto.getDepartamentoId()).orElse(null));
        empleado.setEstadoCivil(estadoCivilRepository.findById(dto.getEstadoCivilId()).orElse(null));
        empleado.setEps(epsRepository.findById(dto.getEpsId()).orElse(null));
        empleado.setFondoPension(fondoPensionRepository.findById(dto.getFondoPensionId()).orElse(null));
        empleado.setTipoContrato(tipoContratoRepository.findById(dto.getTipoContratoId()).orElse(null));
        empleado.setRiesgo(factorRiesgoRepository.findById(dto.getRiesgoId()).orElse(null));
        empleado.setBanco(entidadBancariaRepository.findById(dto.getBancoId()).orElse(null));
        empleado.setEstado(estadoRepository.findById(dto.getEstadoId()).orElse(null));

        // Guardar cambios
        empleadoRepository.save(empleado);
    }


    @Override
    public void delete(Integer id) {
        if (!empleadoRepository.existsById(id)) {
            throw new EmpleadoException("Empleado no encontrado para eliminar");
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public List<EmpleadoDTO> findAll() {
        return empleadoRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EmpleadoDTO> buscarPorNombreOCargo(String keyword) {
        return empleadoRepository.findAll().stream()
                .filter(e -> {
                    String nombreCompleto = (e.getPrimerNombre() + " " + e.getSegundoNombre() + " " + e.getPrimerApellido() + " " + e.getSegundoApellido()).toLowerCase();
                    String nombreCargo = e.getCargo() != null ? e.getCargo().getNombre().toLowerCase() : "";
                    return nombreCompleto.contains(keyword.toLowerCase()) || nombreCargo.contains(keyword.toLowerCase());
                })
                .map(e -> modelMapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

}
