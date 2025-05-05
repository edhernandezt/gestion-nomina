package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "sp_generar_deducciones_mensual",
        procedureName = "sp_generar_deducciones_mensual",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_listar_deducciones",
        procedureName = "sp_listar_deducciones",
        resultClasses = Deduccion.class
)
@Entity
@Table(name = "deducciones")
public class Deduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deduccion")
    private Integer idDeduccion;

    @OneToOne
    @JoinColumn(name = "id_devengado", unique = true)
    private Devengado devengado;

    @Column(name = "salud")
    private BigDecimal salud;

    @Column(name = "pension")
    private BigDecimal pension;

    @Column(name = "fondo_solidaridad")
    private BigDecimal fondoSolidaridad;

    @Column(name = "rete_fuente")
    private BigDecimal reteFuente;

    @Column(name = "descuentos_dias")
    private BigDecimal descuentosDias;

    @Column(name = "total_deducciones")
    private BigDecimal totalDeducciones;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public Deduccion() {
    }

    public Deduccion(Devengado devengado, BigDecimal salud, BigDecimal pension, BigDecimal fondoSolidaridad, BigDecimal reteFuente, BigDecimal descuentosDias, BigDecimal totalDeducciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.devengado = devengado;
        this.salud = salud;
        this.pension = pension;
        this.fondoSolidaridad = fondoSolidaridad;
        this.reteFuente = reteFuente;
        this.descuentosDias = descuentosDias;
        this.totalDeducciones = totalDeducciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public Devengado getDevengado() {
        return devengado;
    }

    public void setDevengado(Devengado devengado) {
        this.devengado = devengado;
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

    public BigDecimal getFondoSolidaridad() {
        return fondoSolidaridad;
    }

    public void setFondoSolidaridad(BigDecimal fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }

    public BigDecimal getReteFuente() {
        return reteFuente;
    }

    public void setReteFuente(BigDecimal reteFuente) {
        this.reteFuente = reteFuente;
    }

    public BigDecimal getDescuentosDias() {
        return descuentosDias;
    }

    public void setDescuentosDias(BigDecimal descuentosDias) {
        this.descuentosDias = descuentosDias;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
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
