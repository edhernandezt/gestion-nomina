package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.PrestacionSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestacionSocialRepository extends JpaRepository<PrestacionSocial, Integer> {

    @Procedure(procedureName = "sp_generar_prestaciones_sociales_mensual")
    void generarPrestacionesMensual(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );

    @Procedure(name = "sp_listar_prestaciones")
    List<PrestacionSocial> listarPrestaciones();

    List<PrestacionSocial> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(
            LocalDate fechaInicio, LocalDate fechaFin
    );
}
