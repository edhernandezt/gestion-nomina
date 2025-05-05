package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.AportePatronalDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAportePatronalService {

    void generarAportesMensuales(LocalDate fechaInicio, LocalDate fechaFin);

    List<AportePatronalDTO> findAll();

    List<AportePatronalDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
