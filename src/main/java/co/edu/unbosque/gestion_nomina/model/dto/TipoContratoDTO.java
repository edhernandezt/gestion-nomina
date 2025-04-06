package co.edu.unbosque.gestion_nomina.model.dto;

public class TipoContratoDTO {
    private Integer idTipoContrato;
    private String tipoContrato;

    public TipoContratoDTO() {}

    public TipoContratoDTO(Integer idTipoContrato, String tipoContrato) {
        this.idTipoContrato = idTipoContrato;
        this.tipoContrato = tipoContrato;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
