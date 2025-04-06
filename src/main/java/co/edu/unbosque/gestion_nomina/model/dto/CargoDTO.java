package co.edu.unbosque.gestion_nomina.model.dto;

public class CargoDTO {
    private Integer idCargo;
    private String nombre;

    public CargoDTO() {}

    public CargoDTO(Integer idCargo, String nombre) {
        this.idCargo = idCargo;
        this.nombre = nombre;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
