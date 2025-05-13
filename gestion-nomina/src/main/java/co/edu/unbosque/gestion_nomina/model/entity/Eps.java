package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eps")
public class Eps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eps")
    private Integer idEps;

    @Column(name = "nombre_eps", nullable = false, length = 100)
    private String nombreEps;

    public Eps() {}

    public Eps(String nombreEps) {
        this.nombreEps = nombreEps;
    }

    public Integer getIdEps() {
        return idEps;
    }

    public void setIdEps(Integer idEps) {
        this.idEps = idEps;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }
}
