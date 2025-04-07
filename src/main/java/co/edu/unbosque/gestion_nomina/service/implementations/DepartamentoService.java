package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.exceptions.DepartamentoException;
import co.edu.unbosque.gestion_nomina.model.dto.DepartamentoDTO;
import co.edu.unbosque.gestion_nomina.model.entity.Departamento;
import co.edu.unbosque.gestion_nomina.repository.DepartamentoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService implements ICrud<DepartamentoDTO, Integer> {

    private final DepartamentoRepository departamentoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository, ModelMapper modelMapper) {
        this.departamentoRepository = departamentoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(DepartamentoDTO objetoDTO) {
        Departamento departamento = modelMapper.map(objetoDTO, Departamento.class);
        departamentoRepository.save(departamento);
    }

    @Override
    public Optional<DepartamentoDTO> find(Integer id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoException("Departamento con ID " + id + " no encontrado"));
        return Optional.of(modelMapper.map(departamento, DepartamentoDTO.class));
    }

    @Override
    public void update(Integer id, DepartamentoDTO objetoDTO) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoException("No se puede actualizar. Departamento con ID " + id + " no existe"));

        modelMapper.map(objetoDTO, departamento); // copia los datos al objeto existente
        departamentoRepository.save(departamento);
    }

    @Override
    public void delete(Integer id) {
        if (!departamentoRepository.existsById(id)) {
            throw new DepartamentoException("No se puede eliminar. Departamento con ID " + id + " no existe");
        }
        departamentoRepository.deleteById(id);
    }

    @Override
    public List<DepartamentoDTO> findAll() {
        return departamentoRepository.findAll()
                .stream()
                .map(dep -> modelMapper.map(dep, DepartamentoDTO.class))
                .collect(Collectors.toList());
    }
}
