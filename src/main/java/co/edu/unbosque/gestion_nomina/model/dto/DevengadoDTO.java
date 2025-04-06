package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;

public class DevengadoDTO {
    private Integer idDevengado;
    private Integer empleadoId;
    private BigDecimal sueldo;
    private BigDecimal auxilioTransporte;
    private BigDecimal horasTrabajadas;
    private BigDecimal totalDevengado;
    private BigDecimal aPagar;

    public DevengadoDTO() {}

    public DevengadoDTO(Integer idDevengado, Integer empleadoId, BigDecimal sueldo, BigDecimal auxilioTransporte,
                        BigDecimal horasTrabajadas, BigDecimal totalDevengado, BigDecimal aPagar) {
        this.idDevengado = idDevengado;
        this.empleadoId = empleadoId;
        this.sueldo = sueldo;
        this.auxilioTransporte = auxilioTransporte;
        this.horasTrabajadas = horasTrabajadas;
        this.totalDevengado = totalDevengado;
        this.aPagar = aPagar;
    }

    public Integer getIdDevengado() {
        return idDevengado;
    }

    public void setIdDevengado(Integer idDevengado) {
        this.idDevengado = idDevengado;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(BigDecimal auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public BigDecimal getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(BigDecimal totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public BigDecimal getAPagar() {
        return aPagar;
    }

    public void setAPagar(BigDecimal aPagar) {
        this.aPagar = aPagar;
    }
}
