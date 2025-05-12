package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HorasExtrasDTO {
    private Integer idHoraExtra;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer idTipoHoraExtra;
    private String descripcionTipo;
    private BigDecimal cantidadHoras;
    private BigDecimal valorHora;
    private BigDecimal totalPagado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public HorasExtrasDTO() {}

    public HorasExtrasDTO(Integer idHoraExtra, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer idTipoHoraExtra, String descripcionTipo, BigDecimal cantidadHoras, BigDecimal valorHora, BigDecimal totalPagado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idHoraExtra = idHoraExtra;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.idTipoHoraExtra = idTipoHoraExtra;
        this.descripcionTipo = descripcionTipo;
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
        this.totalPagado = totalPagado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdHoraExtra() {
        return idHoraExtra;
    }

    public void setIdHoraExtra(Integer idHoraExtra) {
        this.idHoraExtra = idHoraExtra;
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

    public Integer getIdTipoHoraExtra() {
        return idTipoHoraExtra;
    }

    public void setIdTipoHoraExtra(Integer idTipoHoraExtra) {
        this.idTipoHoraExtra = idTipoHoraExtra;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public BigDecimal getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(BigDecimal cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(BigDecimal totalPagado) {
        this.totalPagado = totalPagado;
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
