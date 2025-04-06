package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "aportes_patronales")
public class AportePatronal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aporte")
    private Integer idAporte;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "caja_compensacion")
    private BigDecimal cajaCompensacion;

    @Column(name = "salud_patronal")
    private BigDecimal saludPatronal;

    @Column(name = "afp_patronal")
    private BigDecimal afpPatronal;

    @Column(name = "riesgo_laboral")
    private BigDecimal riesgoLaboral;

    @ManyToOne
    @JoinColumn(name = "factor_riesgo_id")
    private FactorRiesgo factorRiesgo;

    public AportePatronal() {

    }

    public AportePatronal(Empleado empleado, BigDecimal cajaCompensacion, BigDecimal saludPatronal, BigDecimal afpPatronal, BigDecimal riesgoLaboral, FactorRiesgo factorRiesgo) {
        this.empleado = empleado;
        this.cajaCompensacion = cajaCompensacion;
        this.saludPatronal = saludPatronal;
        this.afpPatronal = afpPatronal;
        this.riesgoLaboral = riesgoLaboral;
        this.factorRiesgo = factorRiesgo;
    }

    public Integer getIdAporte() {
        return idAporte;
    }

    public void setIdAporte(Integer idAporte) {
        this.idAporte = idAporte;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    public FactorRiesgo getFactorRiesgo() {
        return factorRiesgo;
    }

    public void setFactorRiesgo(FactorRiesgo factorRiesgo) {
        this.factorRiesgo = factorRiesgo;
    }
}
