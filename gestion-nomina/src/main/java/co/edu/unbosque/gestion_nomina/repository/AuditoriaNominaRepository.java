package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.AuditoriaNomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuditoriaNominaRepository extends JpaRepository<AuditoriaNomina, Integer> {

    @Procedure(name = "sp_buscar_auditoria_nomina_por_usuario")
    List<AuditoriaNomina> buscarPorUsuarioYFechas(
            @Param("pd_fecha_inicio") LocalDate fechaInicio,
            @Param("pd_fecha_fin") LocalDate fechaFin,
            @Param("usuario") String usuario
    );
}
