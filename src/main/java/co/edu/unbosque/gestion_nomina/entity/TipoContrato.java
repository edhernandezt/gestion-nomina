package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_contrato")
public class TipoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contrato")
    private Integer idTipoContrato;

    @Column(name = "tipo_contrato", nullable = false, length = 100)
    private String tipoContrato;

    public TipoContrato() {}

    public TipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}

