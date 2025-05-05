package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.NovedadDTO;

import java.time.LocalDate;
import java.util.List;

public interface INovedadService {

    void registrarNovedad(Integer idEmpleado, Integer idTipoNovedad, LocalDate fechaInicio, LocalDate fechaFin, String observaciones);
    List<NovedadDTO> listarNovedades();
}
