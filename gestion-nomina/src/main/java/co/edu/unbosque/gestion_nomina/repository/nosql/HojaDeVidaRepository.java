package co.edu.unbosque.gestion_nomina.repository.nosql;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVida;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HojaDeVidaRepository extends MongoRepository<HojaDeVida, String> {

    List<HojaDeVida> findByNumeroDocumentoContainingIgnoreCaseOrPrimerNombreContainingIgnoreCaseOrPrimerApellidoContainingIgnoreCase(
            String documento, String nombre, String apellido);
}
