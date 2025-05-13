package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.AuditoriaNominaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAuditoriaNominaService {

    List<AuditoriaNominaDTO> buscarPorUsuarioYFechas(LocalDate fechaInicio, LocalDate fechaFin, String usuario);
}
