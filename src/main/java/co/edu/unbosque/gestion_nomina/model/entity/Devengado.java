package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "devengado")
@NamedStoredProcedureQuery(
        name = "sp_buscar_devengados_por_nombre",
        procedureName = "sp_buscar_devengados_por_nombre",
        resultClasses = Devengado.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = java.time.LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = java.time.LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_nombre", type = String.class)
        }
)
public class Devengado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devengado")
    private Integer idDevengado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "horas_trabajadas")
    private BigDecimal horasTrabajadas;

    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @Column(name = "auxilio_transporte")
    private BigDecimal auxilioTransporte;

    @Column(name = "total_horas_extras")
    private BigDecimal totalHorasExtras;

    @Column(name = "total_devengado")
    private BigDecimal totalDevengado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @OneToOne(mappedBy = "devengado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Deduccion deduccion;

    public Devengado() {}

    public Devengado(Empleado empleado, BigDecimal horasTrabajadas, BigDecimal sueldo, BigDecimal subTotal, BigDecimal auxilioTransporte, BigDecimal totalHorasExtras, BigDecimal totalDevengado, LocalDate fechaInicio, LocalDate fechaFin, Deduccion deduccion) {
        this.empleado = empleado;
        this.horasTrabajadas = horasTrabajadas;
        this.sueldo = sueldo;
        this.subTotal = subTotal;
        this.auxilioTransporte = auxilioTransporte;
        this.totalHorasExtras = totalHorasExtras;
        this.totalDevengado = totalDevengado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.deduccion = deduccion;
    }

    public Integer getIdDevengado() {
        return idDevengado;
    }

    public void setIdDevengado(Integer idDevengado) {
        this.idDevengado = idDevengado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(BigDecimal auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public BigDecimal getTotalHorasExtras() {
        return totalHorasExtras;
    }

    public void setTotalHorasExtras(BigDecimal totalHorasExtras) {
        this.totalHorasExtras = totalHorasExtras;
    }

    public BigDecimal getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(BigDecimal totalDevengado) {
        this.totalDevengado = totalDevengado;
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

    public Deduccion getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(Deduccion deduccion) {
        this.deduccion = deduccion;
    }
}
