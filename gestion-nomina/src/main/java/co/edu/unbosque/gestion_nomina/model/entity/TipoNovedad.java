package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_novedad")
public class TipoNovedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_novedad")
    private Integer idTipoNovedad;

    @Column(name = "descripcion")
    private String descripcion;

    public TipoNovedad() {

    }

    public TipoNovedad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(Integer idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
