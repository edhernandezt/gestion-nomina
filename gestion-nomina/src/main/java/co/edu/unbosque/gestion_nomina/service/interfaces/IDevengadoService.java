package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IDevengadoService {

    List<DevengadoDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String keyword);
}
