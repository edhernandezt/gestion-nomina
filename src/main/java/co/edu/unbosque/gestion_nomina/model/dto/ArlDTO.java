package co.edu.unbosque.gestion_nomina.model.dto;

public class ArlDTO {
    private Integer idArl;
    private String nombreArl;

    public ArlDTO() {}

    public ArlDTO(Integer idArl, String nombreArl) {
        this.idArl = idArl;
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
