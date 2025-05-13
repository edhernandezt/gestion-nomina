package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NominaDTO {

    private Integer idNomina;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer idDevengado;
    private BigDecimal totalDevengado;
    private Integer idDeduccion;
    private BigDecimal totalDeducciones;
    private Integer idPrestacionSocial;
    private BigDecimal totalPrestaciones;
    private Integer idAportePatronal;
    private BigDecimal totalAportes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal totalAPagarEmpleado;
    private BigDecimal totalNomina;

    public NominaDTO(){

    }

    public NominaDTO(Integer idNomina, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer idDevengado, BigDecimal totalDevengado, Integer idDeduccion, BigDecimal totalDeducciones, Integer idPrestacionSocial, BigDecimal totalPrestaciones, Integer idAportePatronal, BigDecimal totalAportes, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalAPagarEmpleado, BigDecimal totalNomina) {
        this.idNomina = idNomina;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.idDevengado = idDevengado;
        this.totalDevengado = totalDevengado;
        this.idDeduccion = idDeduccion;
        this.totalDeducciones = totalDeducciones;
        this.idPrestacionSocial = idPrestacionSocial;
        this.totalPrestaciones = totalPrestaciones;
        this.idAportePatronal = idAportePatronal;
        this.totalAportes = totalAportes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalAPagarEmpleado = totalAPagarEmpleado;
        this.totalNomina = totalNomina;
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

    public Integer getIdDevengado() {
        return idDevengado;
    }

    public void setIdDevengado(Integer idDevengado) {
        this.idDevengado = idDevengado;
    }

    public BigDecimal getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(BigDecimal totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public Integer getIdPrestacionSocial() {
        return idPrestacionSocial;
    }

    public void setIdPrestacionSocial(Integer idPrestacionSocial) {
        this.idPrestacionSocial = idPrestacionSocial;
    }

    public BigDecimal getTotalPrestaciones() {
        return totalPrestaciones;
    }

    public void setTotalPrestaciones(BigDecimal totalPrestaciones) {
        this.totalPrestaciones = totalPrestaciones;
    }

    public Integer getIdAportePatronal() {
        return idAportePatronal;
    }

    public void setIdAportePatronal(Integer idAportePatronal) {
        this.idAportePatronal = idAportePatronal;
    }

    public BigDecimal getTotalAportes() {
        return totalAportes;
    }

    public void setTotalAportes(BigDecimal totalAportes) {
        this.totalAportes = totalAportes;
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

    public BigDecimal getTotalAPagarEmpleado() {
        return totalAPagarEmpleado;
    }

    public void setTotalAPagarEmpleado(BigDecimal totalAPagarEmpleado) {
        this.totalAPagarEmpleado = totalAPagarEmpleado;
    }

    public BigDecimal getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(BigDecimal totalNomina) {
        this.totalNomina = totalNomina;
    }
}
