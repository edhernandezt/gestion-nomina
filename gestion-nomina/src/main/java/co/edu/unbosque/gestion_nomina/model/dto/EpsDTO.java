package co.edu.unbosque.gestion_nomina.model.dto;

public class EpsDTO {
    private Integer idEps;
    private String nombreEps;

    public EpsDTO() {}

    public EpsDTO(Integer idEps, String nombreEps) {
        this.idEps = idEps;
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
