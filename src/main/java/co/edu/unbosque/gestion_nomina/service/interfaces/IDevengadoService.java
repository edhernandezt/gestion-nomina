package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IDevengadoService {

    void generarDevengadosMensual(LocalDate fechaInicio, LocalDate fechaFin);

    List<DevengadoDTO> findAll();

    List<DevengadoDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
