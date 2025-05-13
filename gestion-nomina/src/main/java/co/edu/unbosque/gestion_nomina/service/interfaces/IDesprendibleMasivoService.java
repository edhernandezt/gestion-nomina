package co.edu.unbosque.gestion_nomina.service.interfaces;

import java.io.IOException;
import java.time.LocalDate;

public interface IDesprendibleMasivoService {

    /**
     * Genera un archivo ZIP con los desprendibles de nómina de todos los empleados
     * dentro del rango de fechas proporcionado.
     *
     * @param fechaInicio Fecha de inicio del período.
     * @param fechaFin    Fecha de fin del período.
     * @return Un arreglo de bytes que representa el contenido del archivo ZIP.
     */
    byte[] generarDesprendiblesComoZip(LocalDate fechaInicio, LocalDate fechaFin) throws IOException;
}
