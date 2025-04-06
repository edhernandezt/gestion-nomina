package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parametros_laborales")
public class ParametroLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Integer idParametro;

    @Column(name = "nombre_parametro", nullable = false, length = 100)
    private String nombreParametro;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "unidad", length = 20)
    private String unidad;

    public ParametroLaboral() {

    }

    public ParametroLaboral(String nombreParametro, BigDecimal valor, String unidad) {
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
