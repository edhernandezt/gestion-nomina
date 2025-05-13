package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_nomina")
@NamedStoredProcedureQuery(
        name = "sp_buscar_auditoria_nomina_por_usuario",
        procedureName = "sp_buscar_auditoria_nomina_por_usuario",
        resultClasses = AuditoriaNomina.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "usuario", type = String.class)
        }
)
public class AuditoriaNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Integer idAuditoria;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "total_pagado_empleado")
    private BigDecimal totalPagadoEmpleado;

    @Column(name = "total_nomina")
    private BigDecimal totalNomina;

    @Column(name = "fecha_operacion")
    private LocalDateTime fechaOperacion;

    @Column(name = "usuario")
    private String usuario;

    public AuditoriaNomina() {

    }

    public AuditoriaNomina(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal totalPagadoEmpleado, BigDecimal totalNomina, LocalDateTime fechaOperacion, String usuario) {
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalPagadoEmpleado = totalPagadoEmpleado;
        this.totalNomina = totalNomina;
        this.fechaOperacion = fechaOperacion;
        this.usuario = usuario;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    public BigDecimal getTotalPagadoEmpleado() {
        return totalPagadoEmpleado;
    }

    public void setTotalPagadoEmpleado(BigDecimal totalPagadoEmpleado) {
        this.totalPagadoEmpleado = totalPagadoEmpleado;
    }

    public BigDecimal getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(BigDecimal totalNomina) {
        this.totalNomina = totalNomina;
    }

    public LocalDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
