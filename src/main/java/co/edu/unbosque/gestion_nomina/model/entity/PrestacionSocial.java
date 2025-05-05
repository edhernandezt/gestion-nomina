package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "sp_generar_prestaciones_sociales_mensual",
        procedureName = "sp_generar_prestaciones_sociales_mensual",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_listar_prestaciones",
        procedureName = "sp_listar_prestaciones",
        resultClasses = PrestacionSocial.class
)
@Entity
@Table(name = "prestaciones_sociales")
public class PrestacionSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestacion")
    private Integer idPrestacion;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "cesantias")
    private BigDecimal cesantias;

    @Column(name = "intereses")
    private BigDecimal intereses;

    @Column(name = "prima")
    private BigDecimal prima;

    @Column(name = "vacaciones")
    private BigDecimal vacaciones;

    @Column(name = "total_prestaciones")
    private BigDecimal totalPrestaciones;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public PrestacionSocial() {

    }

    public PrestacionSocial(Empleado empleado, BigDecimal cesantias, BigDecimal intereses, BigDecimal prima, BigDecimal vacaciones, BigDecimal totalPrestaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.empleado = empleado;
        this.cesantias = cesantias;
        this.intereses = intereses;
        this.prima = prima;
        this.vacaciones = vacaciones;
        this.totalPrestaciones = totalPrestaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(Integer idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    public BigDecimal getTotalPrestaciones() {
        return totalPrestaciones;
    }

    public void setTotalPrestaciones(BigDecimal totalPrestaciones) {
        this.totalPrestaciones = totalPrestaciones;
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

