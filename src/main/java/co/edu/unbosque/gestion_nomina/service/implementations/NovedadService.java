package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.NovedadDTO;
import co.edu.unbosque.gestion_nomina.model.entity.Novedad;
import co.edu.unbosque.gestion_nomina.repository.NovedadRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.INovedadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NovedadService implements INovedadService {

    private final NovedadRepository novedadRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NovedadService(NovedadRepository novedadRepository, ModelMapper modelMapper) {
        this.novedadRepository = novedadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registrarNovedad(Integer idEmpleado, Integer idTipoNovedad, LocalDate fechaInicio, LocalDate fechaFin, String observaciones) {
        novedadRepository.registrarNovedad(idEmpleado, idTipoNovedad, fechaInicio, fechaFin, observaciones);
    }

    @Override
    public List<NovedadDTO> listarNovedades() {
        List<Novedad> novedades = novedadRepository.findAll();
        return novedades.stream()
                .map(novedad -> modelMapper.map(novedad, NovedadDTO.class))
                .collect(Collectors.toList());
    }
}
