package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class ParametroLaboralDTO {
    private Integer idParametro;
    private String nombreParametro;
    private BigDecimal valor;
    private String unidad;

    public ParametroLaboralDTO() {}

    public ParametroLaboralDTO(Integer idParametro, String nombreParametro, BigDecimal valor, String unidad) {
        this.idParametro = idParametro;
        this.nombreParametro = nombreParametro;
        this.valor = valor;
        this.unidad = unidad;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
