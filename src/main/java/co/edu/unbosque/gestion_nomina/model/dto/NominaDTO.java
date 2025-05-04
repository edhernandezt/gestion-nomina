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
    private BigDecimal totalAPagar;

    public NominaDTO(){

    }

    public NominaDTO(Integer idNomina, Integer idEmpleado, Integer idDevengado, Integer idDeduccion, Integer idPrestacionSocial, Integer idAportePatronal, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalAPagar) {
        this.idNomina = idNomina;
        this.idEmpleado = idEmpleado;
        this.idDevengado = idDevengado;
        this.idDeduccion = idDeduccion;
        this.idPrestacionSocial = idPrestacionSocial;
        this.idAportePatronal = idAportePatronal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalAPagar = totalAPagar;
    }

    public Integer getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdDevengado() {
        return idDevengado;
    }

    public void setIdDevengado(Integer idDevengado) {
        this.idDevengado = idDevengado;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public Integer getIdPrestacionSocial() {
        return idPrestacionSocial;
    }

    public void setIdPrestacionSocial(Integer idPrestacionSocial) {
        this.idPrestacionSocial = idPrestacionSocial;
    }

    public Integer getIdAportePatronal() {
        return idAportePatronal;
    }

    public void setIdAportePatronal(Integer idAportePatronal) {
        this.idAportePatronal = idAportePatronal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(BigDecimal totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
