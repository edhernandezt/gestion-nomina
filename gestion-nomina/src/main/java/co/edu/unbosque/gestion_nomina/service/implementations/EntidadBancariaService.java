package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.EntidadBancariaDTO;
import co.edu.unbosque.gestion_nomina.model.entity.EntidadBancaria;
import co.edu.unbosque.gestion_nomina.repository.EntidadBancariaRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntidadBancariaService implements ICrud<EntidadBancariaDTO, Integer> {

    private final EntidadBancariaRepository repository;
    private final ModelMapper modelMapper;

    public EntidadBancariaService(EntidadBancariaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EntidadBancariaDTO dto) {
        EntidadBancaria entidad = modelMapper.map(dto, EntidadBancaria.class);
        repository.save(entidad);
    }

    @Override
    public Optional<EntidadBancariaDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, EntidadBancariaDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<EntidadBancariaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EntidadBancariaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EntidadBancariaDTO> buscarPorNombreOCargo(String keyword) {
        return List.of();
    }
}
