package co.edu.unbosque.gestion_nomina.model.dto;

public class DepartamentoDTO {
    private Integer idDepartamento;
    private String nombre;

    public DepartamentoDTO() {}

    public DepartamentoDTO(Integer idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
