package co.edu.unbosque.gestion_nomina.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoDTO {
    private Integer idEmpleado;
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer cargoId;
    private Integer departamentoId;
    private LocalDate fechaIngreso;
    private BigDecimal salarioBasico;
    private String correoElectronico;
    private String telefono;
    private Integer estadoCivilId;
    private Integer arlId;
    private Integer epsId;
    private Integer fondoPensionId;
    private LocalDate fechaNacimiento;
    private String direccion;
    private Integer tipoContratoId;
    private Integer riesgoId;
    private String cuentaBancaria;
    private Integer bancoId;
    private Integer estadoId;

    public EmpleadoDTO() {}

    public EmpleadoDTO(Integer idEmpleado, String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre,
                       String primerApellido, String segundoApellido, Integer cargoId, Integer departamentoId, LocalDate fechaIngreso,
                       BigDecimal salarioBasico, String correoElectronico, String telefono, Integer estadoCivilId, Integer arlId,
                       Integer epsId, Integer fondoPensionId, LocalDate fechaNacimiento, String direccion, Integer tipoContratoId,
                       Integer riesgoId, String cuentaBancaria, Integer bancoId, Integer estadoId) {
        this.idEmpleado = idEmpleado;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cargoId = cargoId;
        this.departamentoId = departamentoId;
        this.fechaIngreso = fechaIngreso;
        this.salarioBasico = salarioBasico;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.estadoCivilId = estadoCivilId;
        this.arlId = arlId;
        this.epsId = epsId;
        this.fondoPensionId = fondoPensionId;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.tipoContratoId = tipoContratoId;
        this.riesgoId = riesgoId;
        this.cuentaBancaria = cuentaBancaria;
        this.bancoId = bancoId;
        this.estadoId = estadoId;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigDecimal getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(BigDecimal salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Integer estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public Integer getArlId() {
        return arlId;
    }

    public void setArlId(Integer arlId) {
        this.arlId = arlId;
    }

    public Integer getEpsId() {
        return epsId;
    }

    public void setEpsId(Integer epsId) {
        this.epsId = epsId;
    }

    public Integer getFondoPensionId() {
        return fondoPensionId;
    }

    public void setFondoPensionId(Integer fondoPensionId) {
        this.fondoPensionId = fondoPensionId;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTipoContratoId() {
        return tipoContratoId;
    }

    public void setTipoContratoId(Integer tipoContratoId) {
        this.tipoContratoId = tipoContratoId;
    }

    public Integer getRiesgoId() {
        return riesgoId;
    }

    public void setRiesgoId(Integer riesgoId) {
        this.riesgoId = riesgoId;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getBancoId() {
        return bancoId;
    }

    public void setBancoId(Integer bancoId) {
        this.bancoId = bancoId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }
}
