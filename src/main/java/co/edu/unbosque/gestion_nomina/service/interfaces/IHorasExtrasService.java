package co.edu.unbosque.gestion_nomina.service.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IHorasExtrasService {

    void registrarHorasExtras(Integer idDevengado, Integer idTipoHoraExtra, BigDecimal cantidadHoras,
                              LocalDate fechaInicio, LocalDate fechaFin);
}
