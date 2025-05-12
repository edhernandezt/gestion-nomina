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

    @Procedure(name = "sp_buscar_deducciones_por_nombre")
    List<Deduccion> buscarPorNombreYFechas(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin,
            @Param("pv_nombre") String nombre
    );
}
