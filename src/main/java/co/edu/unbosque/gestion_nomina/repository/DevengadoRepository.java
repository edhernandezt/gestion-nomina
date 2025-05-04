package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Devengado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DevengadoRepository extends JpaRepository<Devengado, Integer> {

    // Llamada al procedimiento que genera devengados automáticamente
    @Procedure(procedureName = "sp_generar_devengados_mensual")
    void generarDevengadosMensual(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );

    // Para listar todos los devengados si usas un procedimiento almacenado
    @Procedure(name = "sp_listar_devengados")
    List<Devengado> listarDevengados();

    // Consulta por fechas si estás usando repositorio directo
    List<Devengado> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(LocalDate fechaInicio, LocalDate fechaFin);
}
