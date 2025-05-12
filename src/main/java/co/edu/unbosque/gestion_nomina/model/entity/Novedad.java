package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "novedad")
@NamedStoredProcedureQuery(
        name = "sp_registrar_novedad",
        procedureName = "sp_registrar_novedad",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_empleado", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pn_id_tipo_novedad", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = java.time.LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = java.time.LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_observaciones", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_buscar_novedades_por_nombre",
        procedureName = "sp_buscar_novedades_por_nombre",
        resultClasses = Novedad.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_inicio", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pd_fecha_fin", type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pv_nombre", type = String.class)
        }
)
public class Novedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_novedad")
    private Integer idNovedad;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_novedad")
    private TipoNovedad tipoNovedad;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "dias_afectados")
    private Integer diasAfectados;

    public Novedad() {
    }

    public Novedad(Empleado empleado, TipoNovedad tipoNovedad, LocalDate fechaInicio, LocalDate fechaFin, String observaciones, Integer diasAfectados) {
        this.empleado = empleado;
        this.tipoNovedad = tipoNovedad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
        this.diasAfectados = diasAfectados;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoNovedad getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(TipoNovedad tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getDiasAfectados() {
        return diasAfectados;
    }

    public void setDiasAfectados(Integer diasAfectados) {
        this.diasAfectados = diasAfectados;
    }
}
