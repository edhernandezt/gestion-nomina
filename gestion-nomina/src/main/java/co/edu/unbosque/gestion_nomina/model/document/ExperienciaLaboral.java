package co.edu.unbosque.gestion_nomina.model.document;

import java.time.LocalDate;

public class ExperienciaLaboral {

    private String empresa;
    private String cargo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;

    public ExperienciaLaboral() {

    }

    public ExperienciaLaboral(String empresa, String cargo, LocalDate fechaInicio, LocalDate fechaFin, String descripcion) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
