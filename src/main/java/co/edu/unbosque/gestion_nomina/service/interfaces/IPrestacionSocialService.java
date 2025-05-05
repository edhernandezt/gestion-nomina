package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.PrestacionSocialDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPrestacionSocialService {

    void generarPrestacionesMensual(LocalDate fechaInicio, LocalDate fechaFin);

    List<PrestacionSocialDTO> findAll();

    List<PrestacionSocialDTO> findByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
