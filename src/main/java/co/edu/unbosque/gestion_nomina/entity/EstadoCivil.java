package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_civil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    public EstadoCivil() {}

    public EstadoCivil(String estado) {
        this.estado = estado;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

