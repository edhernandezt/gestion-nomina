package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.repository.HorasExtrasRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHorasExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class HorasExtrasService implements IHorasExtrasService {

    private final HorasExtrasRepository horasExtrasRepository;

    @Autowired
    public HorasExtrasService(HorasExtrasRepository horasExtrasRepository) {
        this.horasExtrasRepository = horasExtrasRepository;
    }

    @Override
    public void registrarHorasExtras(Integer idDevengado, Integer idTipoHoraExtra, BigDecimal cantidadHoras,
                                     LocalDate fechaInicio, LocalDate fechaFin) {
        horasExtrasRepository.registrarHorasExtras(idDevengado, idTipoHoraExtra, cantidadHoras, fechaInicio, fechaFin);
    }
}
