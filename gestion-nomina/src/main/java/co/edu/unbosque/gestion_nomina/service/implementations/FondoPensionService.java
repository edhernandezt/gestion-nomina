package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.FondoPensionDTO;
import co.edu.unbosque.gestion_nomina.repository.FondoPensionRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FondoPensionService implements ICrud<FondoPensionDTO, Integer> {

    private final FondoPensionRepository fondoPensionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FondoPensionService(FondoPensionRepository fondoPensionRepository, ModelMapper modelMapper) {
        this.fondoPensionRepository = fondoPensionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(FondoPensionDTO objetoDTO) {

    }

    @Override
    public Optional<FondoPensionDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, FondoPensionDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<FondoPensionDTO> findAll() {
        return fondoPensionRepository.findAll()
                .stream()
                .map(fondoPension -> modelMapper.map(fondoPension, FondoPensionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FondoPensionDTO> buscarPorNombreOCargo(String keyword) {
        return List.of();
    }
}
