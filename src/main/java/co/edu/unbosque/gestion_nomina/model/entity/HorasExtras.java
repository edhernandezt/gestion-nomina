package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "horas_extras")
@NamedStoredProcedureQuery(
        name = "sp_registrar_horas_extras_empleado",
        procedureName = "sp_registrar_horas_extras_empleado",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_empleado", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_tipo_hora_extra", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_cantidad_horas", type = BigDecimal.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_buscar_horas_extras_por_nombre",
        procedureName = "sp_buscar_horas_extras_por_nombre",
        resultClasses = HorasExtras.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_nombre", type = String.class)
        }
)
public class HorasExtras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hora_extra")
    private Integer idHoraExtra;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_hora_extra")
    private TipoHoraExtra tipoHoraExtra;

    @Column(name = "cantidad_horas")
    private BigDecimal cantidadHoras;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "total_pagado")
    private BigDecimal totalPagado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public HorasExtras() {

    }

    public HorasExtras(Empleado empleado, TipoHoraExtra tipoHoraExtra, BigDecimal cantidadHoras, BigDecimal valorHora, BigDecimal totalPagado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.empleado = empleado;
        this.tipoHoraExtra = tipoHoraExtra;
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
        this.totalPagado = totalPagado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdHoraExtra() {
        return idHoraExtra;
    }

    public void setIdHoraExtra(Integer idHoraExtra) {
        this.idHoraExtra = idHoraExtra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoHoraExtra getTipoHoraExtra() {
        return tipoHoraExtra;
    }

    public void setTipoHoraExtra(TipoHoraExtra tipoHoraExtra) {
        this.tipoHoraExtra = tipoHoraExtra;
    }

    public BigDecimal getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(BigDecimal cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(BigDecimal totalPagado) {
        this.totalPagado = totalPagado;
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
