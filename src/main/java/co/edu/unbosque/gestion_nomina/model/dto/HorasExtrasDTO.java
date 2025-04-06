package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class HorasExtrasDTO {
    private Integer idHoraExtra;
    private Integer tipoHoraExtraId;
    private Integer devengadoId;
    private BigDecimal cantidadHoras;
    private BigDecimal valorHora;
    private BigDecimal totalPagado;

    public HorasExtrasDTO() {}

    public HorasExtrasDTO(Integer idHoraExtra, Integer tipoHoraExtraId, Integer devengadoId,
                          BigDecimal cantidadHoras, BigDecimal valorHora, BigDecimal totalPagado) {
        this.idHoraExtra = idHoraExtra;
        this.tipoHoraExtraId = tipoHoraExtraId;
        this.devengadoId = devengadoId;
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
        this.totalPagado = totalPagado;
    }

    public Integer getIdHoraExtra() {
        return idHoraExtra;
    }

    public void setIdHoraExtra(Integer idHoraExtra) {
        this.idHoraExtra = idHoraExtra;
    }

    public Integer getTipoHoraExtraId() {
        return tipoHoraExtraId;
    }

    public void setTipoHoraExtraId(Integer tipoHoraExtraId) {
        this.tipoHoraExtraId = tipoHoraExtraId;
    }

    public Integer getDevengadoId() {
        return devengadoId;
    }

    public void setDevengadoId(Integer devengadoId) {
        this.devengadoId = devengadoId;
    }

    public BigDecimal getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(BigDecimal cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(BigDecimal totalPagado) {
        this.totalPagado = totalPagado;
    }
}
