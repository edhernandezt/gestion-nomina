package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.TipoNovedadDTO;
import co.edu.unbosque.gestion_nomina.repository.TipoNovedadRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoNovedadService implements ICrud<TipoNovedadDTO, Integer> {

    private final TipoNovedadRepository tipoNovedadRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TipoNovedadService(TipoNovedadRepository tipoNovedadRepository, ModelMapper modelMapper) {
        this.tipoNovedadRepository = tipoNovedadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(TipoNovedadDTO objetoDTO) {

    }

    @Override
    public Optional<TipoNovedadDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, TipoNovedadDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<TipoNovedadDTO> findAll() {
        return tipoNovedadRepository.findAll()
                .stream()
                .map(tipoNovedad -> modelMapper.map(tipoNovedad, TipoNovedadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoNovedadDTO> buscarPorNombreOCargo(String keyword) {
        return List.of();
    }
}
