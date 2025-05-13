package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.NominaDTO;

import java.time.LocalDate;
import java.util.List;

public interface INominaService {

    void generarNominaMensual(LocalDate fechaInicio, LocalDate fechaFin);
    List<NominaDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre);
}
