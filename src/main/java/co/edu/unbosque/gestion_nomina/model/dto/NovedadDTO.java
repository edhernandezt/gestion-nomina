package co.edu.unbosque.gestion_nomina.model.dto;

import java.time.LocalDate;

public class NovedadDTO {

    private Integer idNovedad;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer idTipoNovedad;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String observaciones;
    private Integer diasAfectados;

    public NovedadDTO() {
    }

    public NovedadDTO(Integer idNovedad, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Integer idTipoNovedad, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String observaciones, Integer diasAfectados) {
        this.idNovedad = idNovedad;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.idTipoNovedad = idTipoNovedad;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
        this.diasAfectados = diasAfectados;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
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

    public Integer getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(Integer idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getDiasAfectados() {
        return diasAfectados;
    }

    public void setDiasAfectados(Integer diasAfectados) {
        this.diasAfectados = diasAfectados;
    }
}
