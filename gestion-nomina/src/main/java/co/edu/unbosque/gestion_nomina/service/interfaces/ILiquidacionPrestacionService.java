package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.dto.LiquidacionPrestacionDTO;

import java.util.List;

public interface ILiquidacionPrestacionService {

    void generarLiquidacionPorSemestre(Integer anio, Integer semestre);
    boolean yaExisteLiquidacion(int anio, int semestre);
    List<LiquidacionPrestacionDTO> buscarPorNombreYPeriodo(Integer anio, Integer semestre, String nombre);
}
