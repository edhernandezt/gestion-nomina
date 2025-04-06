package co.edu.unbosque.gestion_nomina.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parametros_seguridad_social")
public class ParametroSeguridadSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Integer idParametro;

    @Column(name = "nombre_parametro", length = 150)
    private String nombreParametro;

    @Column(name = "tipo_aporte", length = 50)
    private String tipoAporte;

    @Column(name = "porcentaje")
    private BigDecimal porcentaje;

    public ParametroSeguridadSocial() {

    }

    public ParametroSeguridadSocial(String nombreParametro, String tipoAporte, BigDecimal porcentaje) {
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
