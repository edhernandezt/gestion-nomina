package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface NovedadRepository extends JpaRepository<Novedad, Integer> {

    @Procedure(name = "sp_registrar_novedad")
    void registrarNovedad(
            Integer pn_id_empleado,
            Integer pn_id_tipo_novedad,
            LocalDate pd_fecha_inicio,
            LocalDate pd_fecha_fin,
            String pv_observaciones
    );
}
