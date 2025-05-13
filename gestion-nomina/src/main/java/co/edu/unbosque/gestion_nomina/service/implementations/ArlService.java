package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.ArlDTO;
import co.edu.unbosque.gestion_nomina.model.dto.EntidadBancariaDTO;
import co.edu.unbosque.gestion_nomina.repository.ArlRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArlService implements ICrud<ArlDTO, Integer> {

    private final ArlRepository arlRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ArlService(ArlRepository arlRepository, ModelMapper modelMapper) {
        this.arlRepository = arlRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(ArlDTO objetoDTO) {

    }

    @Override
    public Optional<ArlDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, ArlDTO objetoDTO) {

    }


    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ArlDTO> findAll() {
        return arlRepository.findAll()
                .stream()
                .map(arl -> modelMapper.map(arl, ArlDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArlDTO> buscarPorNombreOCargo(String keyword) {
        return List.of();
    }
}
