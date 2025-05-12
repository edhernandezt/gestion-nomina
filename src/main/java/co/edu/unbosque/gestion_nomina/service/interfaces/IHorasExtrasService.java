package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.HorasExtrasDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IHorasExtrasService {

    void registrarHorasExtrasEmpleado(Integer idEmpleado, Integer idTipoHoraExtra,
                                      BigDecimal cantidadHoras, LocalDate fechaInicio, LocalDate fechaFin);

    List<HorasExtrasDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre);
}
