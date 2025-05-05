package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AportePatronalDTO {

    private Integer idAporte;
    private Integer idEmpleado;
    private Integer idFactorRiesgo;
    private BigDecimal cajaCompensacion;
    private BigDecimal salud;
    private BigDecimal pension;
    private BigDecimal sena;
    private BigDecimal icbf;
    private BigDecimal riesgoLaboral;
    private BigDecimal totalAportes;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public AportePatronalDTO() {
    }

    public AportePatronalDTO(Integer idAporte, Integer idEmpleado, Integer idFactorRiesgo, BigDecimal cajaCompensacion, BigDecimal salud, BigDecimal pension, BigDecimal sena, BigDecimal icbf, BigDecimal riesgoLaboral, BigDecimal totalAportes, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idAporte = idAporte;
        this.idEmpleado = idEmpleado;
        this.idFactorRiesgo = idFactorRiesgo;
        this.cajaCompensacion = cajaCompensacion;
        this.salud = salud;
        this.pension = pension;
        this.sena = sena;
        this.icbf = icbf;
        this.riesgoLaboral = riesgoLaboral;
        this.totalAportes = totalAportes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdAporte() {
        return idAporte;
    }

    public void setIdAporte(Integer idAporte) {
        this.idAporte = idAporte;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdFactorRiesgo() {
        return idFactorRiesgo;
    }

    public void setIdFactorRiesgo(Integer idFactorRiesgo) {
        this.idFactorRiesgo = idFactorRiesgo;
    }

    public BigDecimal getCajaCompensacion() {
        return cajaCompensacion;
    }

    public void setCajaCompensacion(BigDecimal cajaCompensacion) {
        this.cajaCompensacion = cajaCompensacion;
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

    public BigDecimal getSena() {
        return sena;
    }

    public void setSena(BigDecimal sena) {
        this.sena = sena;
    }

    public BigDecimal getIcbf() {
        return icbf;
    }

    public void setIcbf(BigDecimal icbf) {
        this.icbf = icbf;
    }

    public BigDecimal getRiesgoLaboral() {
        return riesgoLaboral;
    }

    public void setRiesgoLaboral(BigDecimal riesgoLaboral) {
        this.riesgoLaboral = riesgoLaboral;
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
}
