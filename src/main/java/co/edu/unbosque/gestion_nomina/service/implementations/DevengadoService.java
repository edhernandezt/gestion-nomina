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
    @Transactional
    public void generarDevengadosMensual(LocalDate fechaInicio, LocalDate fechaFin) {
        devengadoRepository.generarDevengadosMensual(fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DevengadoDTO> findAll() {
        return devengadoRepository.listarDevengados().stream()
                .map(devengado -> modelMapper.map(devengado, DevengadoDTO.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DevengadoDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return devengadoRepository.findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(fechaInicio, fechaFin).stream()
                .map(devengado -> modelMapper.map(devengado, DevengadoDTO.class))
                .toList();
    }


}
