package co.edu.unbosque.gestion_nomina.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "tipo_documento", length = 30)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 20)
    private String numeroDocumento;

    @Column(name = "primer_nombre", length = 50)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 50)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 50)
    private String segundoApellido;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "salario_basico")
    private BigDecimal salarioBasico;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "estado_civil_id")
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name = "arl_id")
    private Arl arl;

    @ManyToOne
    @JoinColumn(name = "eps_id")
    private Eps eps;

    @ManyToOne
    @JoinColumn(name = "fondo_pension_id")
    private FondoPension fondoPension;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "tipo_contrato_id")
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "riesgo_id")
    private FactorRiesgo riesgo;

    @Column(name = "cuenta_bancaria", length = 30)
    private String cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "banco_id")
    private EntidadBancaria banco;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Empleado() {
    }

    public Empleado(String tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Cargo cargo, Departamento departamento, LocalDate fechaIngreso, BigDecimal salarioBasico, String correoElectronico, String telefono, EstadoCivil estadoCivil, Arl arl, Eps eps, FondoPension fondoPension, LocalDate fechaNacimiento, String direccion, TipoContrato tipoContrato, FactorRiesgo riesgo, String cuentaBancaria, EntidadBancaria banco, Estado estado) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cargo = cargo;
        this.departamento = departamento;
        this.fechaIngreso = fechaIngreso;
        this.salarioBasico = salarioBasico;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.estadoCivil = estadoCivil;
        this.arl = arl;
        this.eps = eps;
        this.fondoPension = fondoPension;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.tipoContrato = tipoContrato;
        this.riesgo = riesgo;
        this.cuentaBancaria = cuentaBancaria;
        this.banco = banco;
        this.estado = estado;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Arl getArl() {
        return arl;
    }

    public void setArl(Arl arl) {
        this.arl = arl;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public FondoPension getFondoPension() {
        return fondoPension;
    }

    public void setFondoPension(FondoPension fondoPension) {
        this.fondoPension = fondoPension;
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

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public FactorRiesgo getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(FactorRiesgo riesgo) {
        this.riesgo = riesgo;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public EntidadBancaria getBanco() {
        return banco;
    }

    public void setBanco(EntidadBancaria banco) {
        this.banco = banco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
