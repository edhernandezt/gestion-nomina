package co.edu.unbosque.gestion_nomina.model.dto;

import java.time.LocalDate;

public class NovedadDTO {

    private Integer idNovedad;
    private Integer idEmpleado;
    private Integer idTipoNovedad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String observaciones;
    private Integer diasAfectados;

    public NovedadDTO() {
    }

    public NovedadDTO(Integer idNovedad, Integer idEmpleado, Integer idTipoNovedad,
                      LocalDate fechaInicio, LocalDate fechaFin,
                      String observaciones, Integer diasAfectados) {
        this.idNovedad = idNovedad;
        this.idEmpleado = idEmpleado;
        this.idTipoNovedad = idTipoNovedad;
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

    public Integer getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(Integer idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
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
