package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.AuditoriaNominaDTO;
import co.edu.unbosque.gestion_nomina.repository.AuditoriaNominaRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IAuditoriaNominaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuditoriaNominaService implements IAuditoriaNominaService {

    private final AuditoriaNominaRepository auditoriaNominaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuditoriaNominaService(AuditoriaNominaRepository auditoriaNominaRepository, ModelMapper modelMapper) {
        this.auditoriaNominaRepository = auditoriaNominaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuditoriaNominaDTO> buscarPorUsuarioYFechas(LocalDate fechaInicio, LocalDate fechaFin, String usuario) {
        return auditoriaNominaRepository.buscarPorUsuarioYFechas(fechaInicio, fechaFin, usuario)
                .stream()
                .map(a -> modelMapper.map(a, AuditoriaNominaDTO.class))
                .toList();
    }
}
