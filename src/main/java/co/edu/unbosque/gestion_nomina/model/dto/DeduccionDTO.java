package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DeduccionDTO {
    private Integer idDeduccion;
    private Integer devengadoId;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private BigDecimal salud;
    private BigDecimal pension;
    private BigDecimal fondoSolidaridad;
    private BigDecimal reteFuente;
    private BigDecimal descuentosDias;
    private BigDecimal totalDeducciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public DeduccionDTO() {}

    public DeduccionDTO(Integer idDeduccion, Integer devengadoId, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, BigDecimal salud, BigDecimal pension, BigDecimal fondoSolidaridad, BigDecimal reteFuente, BigDecimal descuentosDias, BigDecimal totalDeducciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idDeduccion = idDeduccion;
        this.devengadoId = devengadoId;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.salud = salud;
        this.pension = pension;
        this.fondoSolidaridad = fondoSolidaridad;
        this.reteFuente = reteFuente;
        this.descuentosDias = descuentosDias;
        this.totalDeducciones = totalDeducciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public Integer getDevengadoId() {
        return devengadoId;
    }

    public void setDevengadoId(Integer devengadoId) {
        this.devengadoId = devengadoId;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public BigDecimal getSalud() {
        return salud;
    }

    public void setSalud(BigDecimal salud) {
        this.salud = salud;
    }

    public BigDecimal getPension() {
        return pension;
    }

    public void setPension(BigDecimal pension) {
        this.pension = pension;
    }

    public BigDecimal getFondoSolidaridad() {
        return fondoSolidaridad;
    }

    public void setFondoSolidaridad(BigDecimal fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }

    public BigDecimal getReteFuente() {
        return reteFuente;
    }

    public void setReteFuente(BigDecimal reteFuente) {
        this.reteFuente = reteFuente;
    }

    public BigDecimal getDescuentosDias() {
        return descuentosDias;
    }

    public void setDescuentosDias(BigDecimal descuentosDias) {
        this.descuentosDias = descuentosDias;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
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
