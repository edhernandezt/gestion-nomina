package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "devengado")
public class Devengado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devengado")
    private Integer idDevengado;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "auxilio_transporte")
    private BigDecimal auxilioTransporte;

    @Column(name = "horas_trabajadas")
    private BigDecimal horasTrabajadas;

    @Column(name = "total_devengado")
    private BigDecimal totalDevengado;

    @Column(name = "a_pagar")
    private BigDecimal aPagar;

    @OneToMany(mappedBy = "devengado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorasExtras> horasExtras = new ArrayList<>();

    @OneToOne(mappedBy = "devengado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Deduccion deduccion;

    public Devengado() {
    }

    public Devengado(Empleado empleado, BigDecimal sueldo, BigDecimal auxilioTransporte, BigDecimal horasTrabajadas, BigDecimal totalDevengado, BigDecimal aPagar) {
        this.empleado = empleado;
        this.sueldo = sueldo;
        this.auxilioTransporte = auxilioTransporte;
        this.horasTrabajadas = horasTrabajadas;
        this.totalDevengado = totalDevengado;
        this.aPagar = aPagar;
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

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(BigDecimal auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public BigDecimal getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(BigDecimal totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public BigDecimal getAPagar() {
        return aPagar;
    }

    public void setAPagar(BigDecimal aPagar) {
        this.aPagar = aPagar;
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
