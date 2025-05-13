package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.PrestacionSocialDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPrestacionSocialService {

    List<PrestacionSocialDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre);
}
