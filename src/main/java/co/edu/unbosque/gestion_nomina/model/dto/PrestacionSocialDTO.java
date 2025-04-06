package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class PrestacionSocialDTO {
    private Integer idPrestacion;
    private Integer empleadoId;
    private BigDecimal cesantias;
    private BigDecimal intereses;
    private BigDecimal prima;
    private BigDecimal vacaciones;

    public PrestacionSocialDTO() {}

    public PrestacionSocialDTO(Integer idPrestacion, Integer empleadoId, BigDecimal cesantias, BigDecimal intereses,
                               BigDecimal prima, BigDecimal vacaciones) {
        this.idPrestacion = idPrestacion;
        this.empleadoId = empleadoId;
        this.cesantias = cesantias;
        this.intereses = intereses;
        this.prima = prima;
        this.vacaciones = vacaciones;
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
}
