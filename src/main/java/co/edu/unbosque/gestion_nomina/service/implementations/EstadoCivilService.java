package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.EstadoCivilDTO;
import co.edu.unbosque.gestion_nomina.repository.EstadoCivilRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoCivilService implements ICrud<EstadoCivilDTO, Integer> {

    private final EstadoCivilRepository estadoCivilRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EstadoCivilService(EstadoCivilRepository estadoCivilRepository, ModelMapper modelMapper) {
        this.estadoCivilRepository = estadoCivilRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EstadoCivilDTO objetoDTO) {

    }

    @Override
    public Optional<EstadoCivilDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, EstadoCivilDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<EstadoCivilDTO> findAll() {
        return estadoCivilRepository.findAll()
                .stream()
                .map(estadoCivil -> modelMapper.map(estadoCivil, EstadoCivilDTO.class))
                .collect(Collectors.toList());
    }
}
