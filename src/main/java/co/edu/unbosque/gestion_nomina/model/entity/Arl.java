package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "arl")
public class Arl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arl")
    private Integer idArl;

    @Column(name = "nombre_arl", nullable = false, length = 100)
    private String nombreArl;

    public Arl() {}

    public Arl(String nombreArl) {
        this.nombreArl = nombreArl;
    }

    public Integer getIdArl() {
        return idArl;
    }

    public void setIdArl(Integer idArl) {
        this.idArl = idArl;
    }

    public String getNombreArl() {
        return nombreArl;
    }

    public void setNombreArl(String nombreArl) {
        this.nombreArl = nombreArl;
    }
}
