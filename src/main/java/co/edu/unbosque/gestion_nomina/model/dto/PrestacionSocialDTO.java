package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestacionSocialDTO {
    private Integer idPrestacion;
    private Integer empleadoId;
    private BigDecimal cesantias;
    private BigDecimal intereses;
    private BigDecimal prima;
    private BigDecimal vacaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public PrestacionSocialDTO() {}

    public PrestacionSocialDTO(Integer idPrestacion, Integer empleadoId, BigDecimal cesantias, BigDecimal intereses, BigDecimal prima, BigDecimal vacaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idPrestacion = idPrestacion;
        this.empleadoId = empleadoId;
        this.cesantias = cesantias;
        this.intereses = intereses;
        this.prima = prima;
        this.vacaciones = vacaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(Integer idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public BigDecimal getCesantias() {
        return cesantias;
    }

    public void setCesantias(BigDecimal cesantias) {
        this.cesantias = cesantias;
    }

    public BigDecimal getIntereses() {
        return intereses;
    }

    public void setIntereses(BigDecimal intereses) {
        this.intereses = intereses;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public BigDecimal getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(BigDecimal vacaciones) {
        this.vacaciones = vacaciones;
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
}
