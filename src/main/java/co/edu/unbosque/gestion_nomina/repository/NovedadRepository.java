package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NovedadRepository extends JpaRepository<Novedad, Integer> {

    @Procedure(name = "sp_registrar_novedad")
    void registrarNovedad(
            @Param("pn_id_empleado") Integer idEmpleado,
            @Param("pn_id_tipo_novedad") Integer idTipoNovedad,
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin,
            @Param("pv_observaciones") String observaciones
    );

    @Procedure(name = "sp_buscar_novedades_por_nombre")
    List<Novedad> buscarPorNombreYFechas(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin,
            @Param("pv_nombre") String nombre
    );

}
