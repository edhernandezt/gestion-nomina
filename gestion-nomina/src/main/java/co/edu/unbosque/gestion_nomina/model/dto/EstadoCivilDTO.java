package co.edu.unbosque.gestion_nomina.model.dto;

public class EstadoCivilDTO {
    private Integer idEstadoCivil;
    private String estado;

    public EstadoCivilDTO() {}

    public EstadoCivilDTO(Integer idEstadoCivil, String estado) {
        this.idEstadoCivil = idEstadoCivil;
        this.estado = estado;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
