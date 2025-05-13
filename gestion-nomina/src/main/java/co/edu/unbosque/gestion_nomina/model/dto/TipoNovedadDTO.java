package co.edu.unbosque.gestion_nomina.model.dto;

public class TipoNovedadDTO {

    private Integer idTipoNovedad;
    private String descripcion;

    public TipoNovedadDTO() {
    }

    public TipoNovedadDTO(Integer idTipoNovedad, String descripcion) {
        this.idTipoNovedad = idTipoNovedad;
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
