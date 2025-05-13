package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DevengadoDTO {

    private Integer idDevengado;
    private Integer idEmpleado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private BigDecimal horasTrabajadas;
    private BigDecimal sueldo;
    private BigDecimal subTotal;
    private BigDecimal auxilioTransporte;
    private BigDecimal totalHorasExtras;
    private BigDecimal totalDevengado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public DevengadoDTO() {
    }

    public DevengadoDTO(Integer idDevengado, Integer idEmpleado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, BigDecimal horasTrabajadas, BigDecimal sueldo, BigDecimal subTotal, BigDecimal auxilioTransporte, BigDecimal totalHorasExtras, BigDecimal totalDevengado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idDevengado = idDevengado;
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.horasTrabajadas = horasTrabajadas;
        this.sueldo = sueldo;
        this.subTotal = subTotal;
        this.auxilioTransporte = auxilioTransporte;
        this.totalHorasExtras = totalHorasExtras;
        this.totalDevengado = totalDevengado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdDevengado() {
        return idDevengado;
    }

    public void setIdDevengado(Integer idDevengado) {
        this.idDevengado = idDevengado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(BigDecimal auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public BigDecimal getTotalHorasExtras() {
        return totalHorasExtras;
    }

    public void setTotalHorasExtras(BigDecimal totalHorasExtras) {
        this.totalHorasExtras = totalHorasExtras;
    }

    public BigDecimal getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(BigDecimal totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
