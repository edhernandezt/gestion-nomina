package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class DeduccionDTO {
    private Integer idDeduccion;
    private Integer devengadoId;
    private BigDecimal salud;
    private BigDecimal pension;
    private BigDecimal fondoSolidaridad;
    private BigDecimal reteFuente;
    private BigDecimal saludPrepagada;
    private BigDecimal aportesVoluntarios;
    private BigDecimal prestamos;
    private BigDecimal descuentosDias;
    private BigDecimal totalDeducciones;

    public DeduccionDTO() {}

    public DeduccionDTO(Integer idDeduccion, Integer devengadoId, BigDecimal salud, BigDecimal pension,
                        BigDecimal fondoSolidaridad, BigDecimal reteFuente, BigDecimal saludPrepagada,
                        BigDecimal aportesVoluntarios, BigDecimal prestamos, BigDecimal descuentosDias,
                        BigDecimal totalDeducciones) {
        this.idDeduccion = idDeduccion;
        this.devengadoId = devengadoId;
        this.salud = salud;
        this.pension = pension;
        this.fondoSolidaridad = fondoSolidaridad;
        this.reteFuente = reteFuente;
        this.saludPrepagada = saludPrepagada;
        this.aportesVoluntarios = aportesVoluntarios;
        this.prestamos = prestamos;
        this.descuentosDias = descuentosDias;
        this.totalDeducciones = totalDeducciones;
    }

    public Integer getIdDeduccion() {
        return idDeduccion;
    }

    public void setIdDeduccion(Integer idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public Integer getDevengadoId() {
        return devengadoId;
    }

    public void setDevengadoId(Integer devengadoId) {
        this.devengadoId = devengadoId;
    }

    public BigDecimal getSalud() {
        return salud;
    }

    public void setSalud(BigDecimal salud) {
        this.salud = salud;
    }

    public BigDecimal getPension() {
        return pension;
    }

    public void setPension(BigDecimal pension) {
        this.pension = pension;
    }

    public BigDecimal getFondoSolidaridad() {
        return fondoSolidaridad;
    }

    public void setFondoSolidaridad(BigDecimal fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }

    public BigDecimal getReteFuente() {
        return reteFuente;
    }

    public void setReteFuente(BigDecimal reteFuente) {
        this.reteFuente = reteFuente;
    }

    public BigDecimal getSaludPrepagada() {
        return saludPrepagada;
    }

    public void setSaludPrepagada(BigDecimal saludPrepagada) {
        this.saludPrepagada = saludPrepagada;
    }

    public BigDecimal getAportesVoluntarios() {
        return aportesVoluntarios;
    }

    public void setAportesVoluntarios(BigDecimal aportesVoluntarios) {
        this.aportesVoluntarios = aportesVoluntarios;
    }

    public BigDecimal getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(BigDecimal prestamos) {
        this.prestamos = prestamos;
    }

    public BigDecimal getDescuentosDias() {
        return descuentosDias;
    }

    public void setDescuentosDias(BigDecimal descuentosDias) {
        this.descuentosDias = descuentosDias;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }
}
