package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuditoriaNominaDTO {

    private Integer idAuditoria;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal totalPagadoEmpleado;
    private BigDecimal totalNomina;
    private LocalDateTime fechaOperacion;
    private String usuario;

    public AuditoriaNominaDTO() {

    }

    public AuditoriaNominaDTO(Integer idAuditoria, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalPagadoEmpleado, BigDecimal totalNomina, LocalDateTime fechaOperacion, String usuario) {
        this.idAuditoria = idAuditoria;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalPagadoEmpleado = totalPagadoEmpleado;
        this.totalNomina = totalNomina;
        this.fechaOperacion = fechaOperacion;
        this.usuario = usuario;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
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

    public BigDecimal getTotalPagadoEmpleado() {
        return totalPagadoEmpleado;
    }

    public void setTotalPagadoEmpleado(BigDecimal totalPagadoEmpleado) {
        this.totalPagadoEmpleado = totalPagadoEmpleado;
    }

    public BigDecimal getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(BigDecimal totalNomina) {
        this.totalNomina = totalNomina;
    }

    public LocalDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
