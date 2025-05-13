package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "liquidacion_prestacion")
@NamedStoredProcedureQuery(
        name = "sp_generar_liquidacion_prestaciones_semestre",
        procedureName = "sp_generar_liquidacion_prestaciones_semestre",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_anio", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_semestre", type = Integer.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_buscar_liquidaciones_prestaciones",
        procedureName = "sp_buscar_liquidaciones_prestaciones",
        resultClasses = LiquidacionPrestacion.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_anio", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_semestre", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_nombre", type = String.class)
        }
)
public class LiquidacionPrestacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion")
    private Integer idLiquidacion;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "cesantias")
    private BigDecimal cesantias;

    @Column(name = "intereses")
    private BigDecimal intereses;

    @Column(name = "prima")
    private BigDecimal prima;

    @Column(name = "vacaciones")
    private BigDecimal vacaciones;

    @Column(name = "total_liquidacion")
    private BigDecimal totalLiquidacion;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    public LiquidacionPrestacion() {

    }

    public LiquidacionPrestacion(Empleado empleado, Integer anio, Integer semestre, BigDecimal cesantias, BigDecimal intereses, BigDecimal prima, BigDecimal vacaciones, BigDecimal totalLiquidacion, LocalDateTime fechaGeneracion) {
        this.empleado = empleado;
        this.anio = anio;
        this.semestre = semestre;
        this.cesantias = cesantias;
        this.intereses = intereses;
        this.prima = prima;
        this.vacaciones = vacaciones;
        this.totalLiquidacion = totalLiquidacion;
        this.fechaGeneracion = fechaGeneracion;
    }

    public Integer getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
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

    public BigDecimal getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public void setTotalLiquidacion(BigDecimal totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
}
