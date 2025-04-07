package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.EpsDTO;
import co.edu.unbosque.gestion_nomina.repository.EpsRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EpsService implements ICrud<EpsDTO, Integer> {

    private final EpsRepository epsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EpsService(EpsRepository epsRepository, ModelMapper modelMapper) {
        this.epsRepository = epsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EpsDTO objetoDTO) {

    }

    @Override
    public Optional<EpsDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, EpsDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<EpsDTO> findAll() {
        return epsRepository.findAll()
                .stream()
                .map(eps -> modelMapper.map(eps, EpsDTO.class))
                .collect(Collectors.toList());
    }
}
