package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Deduccion;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeduccionRepository extends CrudRepository<Deduccion, Integer> {

    @Procedure(procedureName = "sp_generar_deducciones_mensual")
    void generarDeduccionesMensual(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );

    // Para listar todas las deucciones si usas un procedimiento almacenado
    @Procedure(name = "sp_listar_deducciones")
    List<Deduccion> listarDeducciones();

    // Consulta por fechas si estás usando repositorio directo
    List<Deduccion> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(LocalDate fechaInicio, LocalDate fechaFin);
}
