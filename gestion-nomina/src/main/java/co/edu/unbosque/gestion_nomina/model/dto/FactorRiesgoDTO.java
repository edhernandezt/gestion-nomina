package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class FactorRiesgoDTO {
    private Integer idFactor;
    private String nombre;
    private BigDecimal porcentaje;

    public FactorRiesgoDTO() {}

    public FactorRiesgoDTO(Integer idFactor, String nombre, BigDecimal porcentaje) {
        this.idFactor = idFactor;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Integer getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
