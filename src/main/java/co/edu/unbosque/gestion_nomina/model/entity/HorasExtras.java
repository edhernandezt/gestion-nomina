package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "sp_registrar_horas_extras",
        procedureName = "sp_registrar_horas_extras",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_devengado", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_tipo_hora_extra", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_cantidad_horas", type = BigDecimal.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = java.time.LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = java.time.LocalDate.class)
        }
)
@Entity
@Table(name = "horas_extras")
public class HorasExtras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hora_extra")
    private Integer idHoraExtra;

    @ManyToOne
    @JoinColumn(name = "id_tipo_hora_extra")
    private TipoHoraExtra tipoHoraExtra;

    @ManyToOne
    @JoinColumn(name = "id_devengado")
    private Devengado devengado;

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

    public HorasExtras(TipoHoraExtra tipoHoraExtra, Devengado devengado, BigDecimal cantidadHoras, BigDecimal valorHora, BigDecimal totalPagado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.tipoHoraExtra = tipoHoraExtra;
        this.devengado = devengado;
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

    public TipoHoraExtra getTipoHoraExtra() {
        return tipoHoraExtra;
    }

    public void setTipoHoraExtra(TipoHoraExtra tipoHoraExtra) {
        this.tipoHoraExtra = tipoHoraExtra;
    }

    public Devengado getDevengado() {
        return devengado;
    }

    public void setDevengado(Devengado devengado) {
        this.devengado = devengado;
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
