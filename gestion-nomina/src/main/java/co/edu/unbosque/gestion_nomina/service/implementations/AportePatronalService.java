package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.AportePatronalDTO;
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

    private final AportePatronalRepository aporteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AportePatronalService(AportePatronalRepository aporteRepository, ModelMapper modelMapper) {
        this.aporteRepository = aporteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AportePatronalDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return aporteRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre).stream()
                .map(aporte -> modelMapper.map(aporte, AportePatronalDTO.class))
                .collect(Collectors.toList());
    }
}
