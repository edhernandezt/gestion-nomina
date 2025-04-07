package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.TipoContratoDTO;
import co.edu.unbosque.gestion_nomina.repository.TipoContratoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoContratoService implements ICrud<TipoContratoDTO, Integer> {

    private final TipoContratoRepository tipoContratoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TipoContratoService(TipoContratoRepository tipoContratoRepository, ModelMapper modelMapper) {
        this.tipoContratoRepository = tipoContratoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(TipoContratoDTO objetoDTO) {

    }

    @Override
    public Optional<TipoContratoDTO> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer id, TipoContratoDTO objetoDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<TipoContratoDTO> findAll() {
        return tipoContratoRepository.findAll()
                .stream()
                .map(tipoContrato -> modelMapper.map(tipoContrato, TipoContratoDTO.class))
                .collect(Collectors.toList());
    }
}
