package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.AportePatronal;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AportePatronalRepository extends CrudRepository<AportePatronal, Integer> {

    @Procedure(procedureName = "sp_generar_aportes_patronales_mensual")
    void generarAportesMensuales(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );

    @Procedure(name = "sp_listar_aportes_patronales")
    List<AportePatronal> listarAportesPatronales();

    List<AportePatronal> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(
            LocalDate fechaInicio, LocalDate fechaFin
    );
}
