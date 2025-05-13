package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class TipoHoraExtraDTO {

    private Integer idTipoHoraExtra;
    private String descripcion;
    private BigDecimal porcentaje;

    public TipoHoraExtraDTO() {}

    public TipoHoraExtraDTO(Integer idTipoHoraExtra, String descripcion, BigDecimal porcentaje) {
        this.idTipoHoraExtra = idTipoHoraExtra;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public Integer getIdTipoHoraExtra() {
        return idTipoHoraExtra;
    }

    public void setIdTipoHoraExtra(Integer idTipoHoraExtra) {
        this.idTipoHoraExtra = idTipoHoraExtra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
