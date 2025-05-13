package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DesprendibleNominaDTO {

    private int idNomina;
    private String nombreEmpleado;
    private String documento;
    private BigDecimal salarioBasico;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal totalIngresos;
    private BigDecimal totalDeducciones;
    private BigDecimal netoPagar;
    private List<ConceptoValorDTO> ingresos;
    private List<ConceptoValorDTO> deducciones;

    public DesprendibleNominaDTO() {

    }

    public int getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(int idNomina) {
        this.idNomina = idNomina;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(BigDecimal salarioBasico) {
        this.salarioBasico = salarioBasico;
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

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public BigDecimal getNetoPagar() {
        return netoPagar;
    }

    public void setNetoPagar(BigDecimal netoPagar) {
        this.netoPagar = netoPagar;
    }

    public List<ConceptoValorDTO> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<ConceptoValorDTO> ingresos) {
        this.ingresos = ingresos;
    }

    public List<ConceptoValorDTO> getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(List<ConceptoValorDTO> deducciones) {
        this.deducciones = deducciones;
    }
}
