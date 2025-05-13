package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.DesprendibleNominaDTO;

public interface IDesprendibleService {

    DesprendibleNominaDTO obtenerDesprendiblePorIdNomina(Integer idNomina);
}
