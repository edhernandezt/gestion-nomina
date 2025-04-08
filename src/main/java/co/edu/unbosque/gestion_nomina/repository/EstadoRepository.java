package co.edu.unbosque.gestion_nomina.repository;

import co.edu.unbosque.gestion_nomina.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
