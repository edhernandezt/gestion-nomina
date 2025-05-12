package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.AportePatronalDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAportePatronalService {

    List<AportePatronalDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre);
}
