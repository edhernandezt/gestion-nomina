package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVidaArchivo;
import co.edu.unbosque.gestion_nomina.repository.nosql.HojaDeVidaArchivoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHojaDeVidaArchivo;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HojaDeVidaArchivoService implements IHojaDeVidaArchivo {

    private final GridFsTemplate gridFsTemplate;
    private final HojaDeVidaArchivoRepository repository;

    @Autowired
    public HojaDeVidaArchivoService(GridFsTemplate gridFsTemplate, HojaDeVidaArchivoRepository repository) {
        this.gridFsTemplate = gridFsTemplate;
        this.repository = repository;
    }

    @Override
    public void guardar(String numeroDocumento, MultipartFile archivo) throws IOException {
        Optional<HojaDeVidaArchivo> existente = repository.findByNumeroDocumento(numeroDocumento);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una hoja de vida para este documento.");
        }

        ObjectId gridFsId = gridFsTemplate.store(
                archivo.getInputStream(),
                archivo.getOriginalFilename(),
                archivo.getContentType()
        );

        HojaDeVidaArchivo meta = new HojaDeVidaArchivo();
        meta.setNumeroDocumento(numeroDocumento);
        meta.setNombreArchivoOriginal(archivo.getOriginalFilename());
        meta.setGridFsId(gridFsId.toHexString());
        meta.setFechaSubida(LocalDate.now());

        repository.save(meta);
    }

    @Override
    public void actualizarHojaDeVida(String id, MultipartFile nuevoArchivo) throws IOException {
        HojaDeVidaArchivo existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la hoja de vida"));

        // Eliminar archivo anterior de GridFS
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(existente.getGridFsId())));

        // Guardar nuevo archivo en GridFS
        ObjectId nuevoGridId = gridFsTemplate.store(nuevoArchivo.getInputStream(),
                nuevoArchivo.getOriginalFilename(),
                nuevoArchivo.getContentType());

        // Actualizar metadatos
        existente.setGridFsId(nuevoGridId.toHexString());
        existente.setNombreArchivoOriginal(nuevoArchivo.getOriginalFilename());
        existente.setFechaSubida(LocalDate.now());

        repository.save(existente);
    }

    @Override
    public void eliminarPorId(String id) {
        HojaDeVidaArchivo existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el documento"));

        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(existente.getGridFsId())));
        repository.deleteById(id);
    }

    @Override
    public GridFSFile obtenerArchivo(String gridFsId) {
        return gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(gridFsId)));
    }

    @Override
    public List<HojaDeVidaArchivo> listarPorDocumento(String filtro) {
        return filtro == null || filtro.isEmpty()
                ? repository.findAll()
                : repository.findByNumeroDocumentoContainingIgnoreCase(filtro);
    }
}
