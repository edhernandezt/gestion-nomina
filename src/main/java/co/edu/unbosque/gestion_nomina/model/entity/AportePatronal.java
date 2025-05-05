package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "sp_generar_aportes_patronales_mensual",
        procedureName = "sp_generar_aportes_patronales_mensual",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_listar_aportes_patronales",
        procedureName = "sp_listar_aportes_patronales",
        resultClasses = AportePatronal.class
)
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

    @ManyToOne
    @JoinColumn(name = "factor_riesgo_id")
    private FactorRiesgo factorRiesgo;

    @Column(name = "caja_compensacion")
    private BigDecimal cajaCompensacion;

    @Column(name = "salud")
    private BigDecimal salud;

    @Column(name = "pension")
    private BigDecimal pension;

    @Column(name = "sena")
    private BigDecimal sena;

    @Column(name = "icbf")
    private BigDecimal icbf;

    @Column(name = "riesgo_laboral")
    private BigDecimal riesgoLaboral;

    @Column(name = "total_aportes")
    private BigDecimal totalAportes;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public AportePatronal() {

    }

    public AportePatronal(Empleado empleado, FactorRiesgo factorRiesgo, BigDecimal cajaCompensacion, BigDecimal salud, BigDecimal pension, BigDecimal sena, BigDecimal icbf, BigDecimal riesgoLaboral, BigDecimal totalAportes, LocalDate fechaInicio, LocalDate fechaFin) {
        this.empleado = empleado;
        this.factorRiesgo = factorRiesgo;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public FactorRiesgo getFactorRiesgo() {
        return factorRiesgo;
    }

    public void setFactorRiesgo(FactorRiesgo factorRiesgo) {
        this.factorRiesgo = factorRiesgo;
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
