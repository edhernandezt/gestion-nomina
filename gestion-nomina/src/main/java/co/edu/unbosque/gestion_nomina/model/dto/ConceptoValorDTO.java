package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class ConceptoValorDTO {

    private String concepto;
    private BigDecimal valor;
    private Integer cantidad;

    public ConceptoValorDTO() {

    }

    public ConceptoValorDTO(String concepto, BigDecimal valor) {
        this.concepto = concepto;
        this.valor = valor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
