package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NominaDTO {

    private Integer idNomina;
    private Integer idEmpleado;
    private Integer idDevengado;
    private Integer idDeduccion;
    private Integer idPrestacionSocial;
    private Integer idAportePatronal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal totalAPagarEmpleado;
    private BigDecimal totalNomina;

    public NominaDTO(){

    }

    public NominaDTO(Integer idNomina, Integer idEmpleado, Integer idDevengado, Integer idDeduccion, Integer idPrestacionSocial, Integer idAportePatronal, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalAPagarEmpleado, BigDecimal totalNomina) {
        this.idNomina = idNomina;
        this.idEmpleado = idEmpleado;
        this.idDevengado = idDevengado;
        this.idDeduccion = idDeduccion;
        this.idPrestacionSocial = idPrestacionSocial;
        this.idAportePatronal = idAportePatronal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalAPagarEmpleado = totalAPagarEmpleado;
        this.totalNomina = totalNomina;
    }
}
