package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class ParametroSeguridadSocialDTO {
    private Integer idParametro;
    private String nombreParametro;
    private String tipoAporte;
    private BigDecimal porcentaje;

    public ParametroSeguridadSocialDTO() {}

    public ParametroSeguridadSocialDTO(Integer idParametro, String nombreParametro, String tipoAporte, BigDecimal porcentaje) {
        this.idParametro = idParametro;
        this.nombreParametro = nombreParametro;
        this.tipoAporte = tipoAporte;
        this.porcentaje = porcentaje;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getTipoAporte() {
        return tipoAporte;
    }

    public void setTipoAporte(String tipoAporte) {
        this.tipoAporte = tipoAporte;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
