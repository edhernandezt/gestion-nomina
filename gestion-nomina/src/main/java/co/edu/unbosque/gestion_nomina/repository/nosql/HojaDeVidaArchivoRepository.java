package co.edu.unbosque.gestion_nomina.repository.nosql;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVidaArchivo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HojaDeVidaArchivoRepository extends MongoRepository<HojaDeVidaArchivo, String> {
    List<HojaDeVidaArchivo> findByNumeroDocumentoContainingIgnoreCase(String keyword);
    Optional<HojaDeVidaArchivo> findByNumeroDocumento(String numeroDocumento);
}

