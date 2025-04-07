package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.EstadoDTO;
import co.edu.unbosque.gestion_nomina.model.entity.Estado;
import co.edu.unbosque.gestion_nomina.repository.EstadoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService implements ICrud<EstadoDTO, Integer> {

    private final EstadoRepository repository;
    private final ModelMapper modelMapper;

    public EstadoService(EstadoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EstadoDTO dto) {

    }

    @Override
    public Optional<EstadoDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, EstadoDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<EstadoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EstadoDTO.class))
                .collect(Collectors.toList());
    }
}
