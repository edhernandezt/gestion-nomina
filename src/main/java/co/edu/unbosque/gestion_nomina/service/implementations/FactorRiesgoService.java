package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.FactorRiesgoDTO;
import co.edu.unbosque.gestion_nomina.model.entity.FactorRiesgo;
import co.edu.unbosque.gestion_nomina.repository.FactorRiesgoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FactorRiesgoService implements ICrud<FactorRiesgoDTO, Integer> {

    private final FactorRiesgoRepository factorRiesgoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FactorRiesgoService(FactorRiesgoRepository factorRiesgoRepository, ModelMapper modelMapper) {
        this.factorRiesgoRepository = factorRiesgoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(FactorRiesgoDTO objetoDTO) {

    }

    @Override
    public Optional<FactorRiesgoDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, FactorRiesgoDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<FactorRiesgoDTO> findAll() {
        return factorRiesgoRepository.findAll()
                .stream()
                .map(factor -> modelMapper.map(factor, FactorRiesgoDTO.class))
                .collect(Collectors.toList());
    }
}
