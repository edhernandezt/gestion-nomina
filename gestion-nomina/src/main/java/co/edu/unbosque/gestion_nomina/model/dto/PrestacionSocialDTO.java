package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestacionSocialDTO {
    private Integer idPrestacion;
    private Integer empleadoId;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private BigDecimal cesantias;
    private BigDecimal intereses;
    private BigDecimal prima;
    private BigDecimal vacaciones;
    private BigDecimal totalPrestaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public PrestacionSocialDTO() {}

    public PrestacionSocialDTO(Integer idPrestacion, Integer empleadoId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, BigDecimal cesantias, BigDecimal intereses, BigDecimal prima, BigDecimal vacaciones, BigDecimal totalPrestaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idPrestacion = idPrestacion;
        this.empleadoId = empleadoId;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cesantias = cesantias;
        this.intereses = intereses;
        this.prima = prima;
        this.vacaciones = vacaciones;
        this.totalPrestaciones = totalPrestaciones;
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

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public BigDecimal getTotalPrestaciones() {
        return totalPrestaciones;
    }

    public void setTotalPrestaciones(BigDecimal totalPrestaciones) {
        this.totalPrestaciones = totalPrestaciones;
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
