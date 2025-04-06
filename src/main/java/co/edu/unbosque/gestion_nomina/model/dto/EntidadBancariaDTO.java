package co.edu.unbosque.gestion_nomina.model.dto;

public class EntidadBancariaDTO {
    private Integer idBanco;
    private String nombreBanco;

    public EntidadBancariaDTO() {}

    public EntidadBancariaDTO(Integer idBanco, String nombreBanco) {
        this.idBanco = idBanco;
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
