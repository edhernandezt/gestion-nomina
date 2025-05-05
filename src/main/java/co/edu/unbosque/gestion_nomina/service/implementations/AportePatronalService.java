package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.AportePatronalDTO;
import co.edu.unbosque.gestion_nomina.model.entity.AportePatronal;
import co.edu.unbosque.gestion_nomina.repository.AportePatronalRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IAportePatronalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AportePatronalService implements IAportePatronalService {

    private final AportePatronalRepository aportePatronalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AportePatronalService(AportePatronalRepository aportePatronalRepository, ModelMapper modelMapper) {
        this.aportePatronalRepository = aportePatronalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void generarAportesMensuales(LocalDate fechaInicio, LocalDate fechaFin) {
        aportePatronalRepository.generarAportesMensuales(fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AportePatronalDTO> findAll() {
        return ((List<AportePatronal>) aportePatronalRepository.findAll())
                .stream()
                .map(aporte -> modelMapper.map(aporte, AportePatronalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AportePatronalDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return aportePatronalRepository.findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(fechaInicio, fechaFin)
                .stream()
                .map(aporte -> modelMapper.map(aporte, AportePatronalDTO.class))
                .collect(Collectors.toList());
    }
}
