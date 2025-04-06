package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entidad_bancaria")
public class EntidadBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Integer idBanco;

    @Column(name = "nombre_banco", nullable = false, length = 100)
    private String nombreBanco;

    public EntidadBancaria() {}

    public EntidadBancaria(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}

