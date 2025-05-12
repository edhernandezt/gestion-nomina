package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {

    @Procedure(procedureName = "sp_generar_nomina_mensual")
    void generarNominaMensual(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );

    @Procedure(name = "sp_buscar_nominas_por_nombre")
    List<Nomina> buscarPorNombreYFechas(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin,
            @Param("pv_nombre") String nombre
    );
}
