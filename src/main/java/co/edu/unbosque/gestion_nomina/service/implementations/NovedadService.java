package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.NovedadDTO;
import co.edu.unbosque.gestion_nomina.repository.NovedadRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.INovedadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

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
    @Transactional(readOnly = true)
    public List<NovedadDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return novedadRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre)
                .stream()
                .map(n -> modelMapper.map(n, NovedadDTO.class))
                .toList();
    }

}
