package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.PrestacionSocialDTO;
import co.edu.unbosque.gestion_nomina.repository.PrestacionSocialRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IPrestacionSocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestacionSocialService implements IPrestacionSocialService {

    private final PrestacionSocialRepository prestacionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PrestacionSocialService(PrestacionSocialRepository prestacionRepository, ModelMapper modelMapper) {
        this.prestacionRepository = prestacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestacionSocialDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return prestacionRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre).stream()
                .map(prestacion -> modelMapper.map(prestacion, PrestacionSocialDTO.class))
                .collect(Collectors.toList());
    }
}
