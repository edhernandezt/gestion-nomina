package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;
import co.edu.unbosque.gestion_nomina.repository.DevengadoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDevengadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DevengadoService implements IDevengadoService {

    private final DevengadoRepository devengadoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DevengadoService(DevengadoRepository devengadoRepository, ModelMapper modelMapper) {
        this.devengadoRepository = devengadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DevengadoDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return devengadoRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre)
                .stream()
                .map(devengado -> modelMapper.map(devengado, DevengadoDTO.class))
                .toList();
    }
}
