package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.LiquidacionPrestacion;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiquidacionPrestacionRepository extends CrudRepository<LiquidacionPrestacion, Integer> {

    @Procedure(name = "sp_generar_liquidacion_prestaciones_semestre")
    void generarLiquidacionPrestaciones(
            @Param("pn_anio") Integer anio,
            @Param("pn_semestre") Integer semestre
    );

    @Procedure(name = "sp_buscar_liquidaciones_prestaciones")
    List<LiquidacionPrestacion> buscarPorAnioSemestreYNombre(
            @Param("pn_anio") int anio,
            @Param("pn_semestre") int semestre,
            @Param("pv_nombre") String nombre
    );

    boolean existsByAnioAndSemestre(int anio, int semestre);

}
