package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.HorasExtras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface HorasExtrasRepository extends JpaRepository<HorasExtras, Integer> {

    @Procedure(name = "sp_registrar_horas_extras")
    void registrarHorasExtras(
            @Param("pn_id_devengado") Integer idDevengado,
            @Param("pn_id_tipo_hora_extra") Integer idTipoHoraExtra,
            @Param("pn_cantidad_horas") BigDecimal cantidadHoras,
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin
    );
}
