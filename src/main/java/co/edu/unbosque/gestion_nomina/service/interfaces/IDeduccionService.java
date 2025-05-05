package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.DeduccionDTO;

import java.time.LocalDate;
import java.util.List;

public interface IDeduccionService {

    void generarDeduccionesMensual(LocalDate fechaInicio, LocalDate fechaFin);

    List<DeduccionDTO> findAll();

    List<DeduccionDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
