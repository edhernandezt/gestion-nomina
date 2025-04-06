package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fondo_pension")
public class FondoPension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fondo_pension")
    private Integer idFondoPension;

    @Column(name = "nombre_fondo", nullable = false, length = 100)
    private String nombreFondo;

    public FondoPension() {}

    public FondoPension(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public Integer getIdFondoPension() {
        return idFondoPension;
    }

    public void setIdFondoPension(Integer idFondoPension) {
        this.idFondoPension = idFondoPension;
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }
}
