package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tipo_hora_extra")
public class TipoHoraExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_hora_extra")
    private Integer idTipoHoraExtra;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "porcentaje")
    private BigDecimal porcentaje;

    public TipoHoraExtra() {}

    public TipoHoraExtra(String descripcion, BigDecimal porcentaje) {
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public Integer getIdTipoHoraExtra() {
        return idTipoHoraExtra;
    }

    public void setIdTipoHoraExtra(Integer idTipoHoraExtra) {
        this.idTipoHoraExtra = idTipoHoraExtra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}

