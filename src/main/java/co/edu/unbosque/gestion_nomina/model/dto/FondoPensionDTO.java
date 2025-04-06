package co.edu.unbosque.gestion_nomina.model.dto;

public class FondoPensionDTO {
    private Integer idFondoPension;
    private String nombreFondo;

    public FondoPensionDTO() {}

    public FondoPensionDTO(Integer idFondoPension, String nombreFondo) {
        this.idFondoPension = idFondoPension;
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
