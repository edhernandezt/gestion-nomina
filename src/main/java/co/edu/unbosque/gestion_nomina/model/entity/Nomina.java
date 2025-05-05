package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "sp_generar_nomina_mensual",
        procedureName = "sp_generar_nomina_mensual",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_listar_nominas",
        procedureName = "sp_listar_nominas",
        resultClasses = Nomina.class
)
@Entity
@Table(name = "nomina")
public class Nomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nomina")
    private Integer idNomina;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name = "id_devengado")
    private Devengado devengado;

    @OneToOne
    @JoinColumn(name = "id_deduccion")
    private Deduccion deduccion;

    @OneToOne
    @JoinColumn(name = "id_prestacion")
    private PrestacionSocial prestacionSocial;

    @OneToOne
    @JoinColumn(name = "id_aporte")
    private AportePatronal aportePatronal;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "total_a_pagar_empleado")
    private BigDecimal totalAPagarEmpleado;

    @Column(name = "total_nomina")
    private BigDecimal totalNomina;

    public Nomina(){

    }

    public Nomina(Empleado empleado, Devengado devengado, Deduccion deduccion, PrestacionSocial prestacionSocial, AportePatronal aportePatronal, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalAPagarEmpleado, BigDecimal totalNomina) {
        this.empleado = empleado;
        this.devengado = devengado;
        this.deduccion = deduccion;
        this.prestacionSocial = prestacionSocial;
        this.aportePatronal = aportePatronal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalAPagarEmpleado = totalAPagarEmpleado;
        this.totalNomina = totalNomina;
    }

    public Integer getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Devengado getDevengado() {
        return devengado;
    }

    public void setDevengado(Devengado devengado) {
        this.devengado = devengado;
    }

    public Deduccion getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(Deduccion deduccion) {
        this.deduccion = deduccion;
    }

    public PrestacionSocial getPrestacionSocial() {
        return prestacionSocial;
    }

    public void setPrestacionSocial(PrestacionSocial prestacionSocial) {
        this.prestacionSocial = prestacionSocial;
    }

    public AportePatronal getAportePatronal() {
        return aportePatronal;
    }

    public void setAportePatronal(AportePatronal aportePatronal) {
        this.aportePatronal = aportePatronal;
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

    public BigDecimal getTotalAPagarEmpleado() {
        return totalAPagarEmpleado;
    }

    public void setTotalAPagarEmpleado(BigDecimal totalAPagarEmpleado) {
        this.totalAPagarEmpleado = totalAPagarEmpleado;
    }

    public BigDecimal getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(BigDecimal totalNomina) {
        this.totalNomina = totalNomina;
    }
}
