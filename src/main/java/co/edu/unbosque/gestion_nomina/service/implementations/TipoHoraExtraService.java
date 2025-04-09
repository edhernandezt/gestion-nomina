package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.TipoHoraExtraDTO;
import co.edu.unbosque.gestion_nomina.model.entity.TipoHoraExtra;
import co.edu.unbosque.gestion_nomina.repository.TipoHoraExtraRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoHoraExtraService implements ICrud<TipoHoraExtraDTO, Integer> {

    private final TipoHoraExtraRepository repository;
    private final ModelMapper modelMapper;

    public TipoHoraExtraService(TipoHoraExtraRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(TipoHoraExtraDTO dto) {

    }

    @Override
    public Optional<TipoHoraExtraDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, TipoHoraExtraDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<TipoHoraExtraDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, TipoHoraExtraDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoHoraExtraDTO> buscarPorNombreOCargo(String keyword) {
        return List.of();
    }
}
