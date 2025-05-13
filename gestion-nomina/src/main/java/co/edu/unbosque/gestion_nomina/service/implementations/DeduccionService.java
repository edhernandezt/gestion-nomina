package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.DeduccionDTO;
import co.edu.unbosque.gestion_nomina.repository.DeduccionRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDeduccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeduccionService implements IDeduccionService {

    private final DeduccionRepository deduccionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DeduccionService(DeduccionRepository deduccionRepository, ModelMapper modelMapper) {
        this.deduccionRepository = deduccionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeduccionDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return deduccionRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre)
                .stream()
                .map(d -> modelMapper.map(d, DeduccionDTO.class))
                .toList();
    }

}
