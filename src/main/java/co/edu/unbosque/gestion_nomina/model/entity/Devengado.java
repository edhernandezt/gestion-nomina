package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedStoredProcedureQuery(
        name = "sp_generar_devengados_mensual",
        procedureName = "sp_generar_devengados_mensual",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_listar_devengados",
        procedureName = "sp_listar_devengados",
        resultClasses = Devengado.class
)
@Entity
@Table(name = "devengado")
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

    @Column(name = "total_devengado")
    private BigDecimal totalDevengado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "devengado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorasExtras> horasExtras = new ArrayList<>();

    @OneToOne(mappedBy = "devengado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Deduccion deduccion;

    // Constructores
    public Devengado() {}

    public Devengado(Empleado empleado, BigDecimal horasTrabajadas, BigDecimal sueldo, BigDecimal subTotal,
                     BigDecimal auxilioTransporte, BigDecimal totalDevengado,
                     LocalDate fechaInicio, LocalDate fechaFin, List<HorasExtras> horasExtras, Deduccion deduccion) {
        this.empleado = empleado;
        this.horasTrabajadas = horasTrabajadas;
        this.sueldo = sueldo;
        this.subTotal = subTotal;
        this.auxilioTransporte = auxilioTransporte;
        this.totalDevengado = totalDevengado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasExtras = horasExtras;
        this.deduccion = deduccion;
    }

    // Getters y setters
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

    public List<HorasExtras> getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(List<HorasExtras> horasExtras) {
        this.horasExtras = horasExtras;
    }

    public Deduccion getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(Deduccion deduccion) {
        this.deduccion = deduccion;
    }
}
