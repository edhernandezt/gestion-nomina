package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class AportePatronalDTO {
    private Integer idAporte;
    private Integer empleadoId;
    private BigDecimal cajaCompensacion;
    private BigDecimal saludPatronal;
    private BigDecimal afpPatronal;
    private BigDecimal riesgoLaboral;
    private Integer factorRiesgoId;

    public AportePatronalDTO() {
    }

    public AportePatronalDTO(Integer idAporte, Integer empleadoId, BigDecimal cajaCompensacion, BigDecimal saludPatronal,
                             BigDecimal afpPatronal, BigDecimal riesgoLaboral, Integer factorRiesgoId) {
        this.idAporte = idAporte;
        this.empleadoId = empleadoId;
        this.cajaCompensacion = cajaCompensacion;
        this.saludPatronal = saludPatronal;
        this.afpPatronal = afpPatronal;
        this.riesgoLaboral = riesgoLaboral;
        this.factorRiesgoId = factorRiesgoId;
    }

    public Integer getIdAporte() {
        return idAporte;
    }

    public void setIdAporte(Integer idAporte) {
        this.idAporte = idAporte;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public BigDecimal getCajaCompensacion() {
        return cajaCompensacion;
    }

    public void setCajaCompensacion(BigDecimal cajaCompensacion) {
        this.cajaCompensacion = cajaCompensacion;
    }

    public BigDecimal getSaludPatronal() {
        return saludPatronal;
    }

    public void setSaludPatronal(BigDecimal saludPatronal) {
        this.saludPatronal = saludPatronal;
    }

    public BigDecimal getAfpPatronal() {
        return afpPatronal;
    }

    public void setAfpPatronal(BigDecimal afpPatronal) {
        this.afpPatronal = afpPatronal;
    }

    public BigDecimal getRiesgoLaboral() {
        return riesgoLaboral;
    }

    public void setRiesgoLaboral(BigDecimal riesgoLaboral) {
        this.riesgoLaboral = riesgoLaboral;
    }

    public Integer getFactorRiesgoId() {
        return factorRiesgoId;
    }

    public void setFactorRiesgoId(Integer factorRiesgoId) {
        this.factorRiesgoId = factorRiesgoId;
    }
}
