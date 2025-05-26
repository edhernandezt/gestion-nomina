package co.edu.unbosque.gestion_nomina.service.interfaces;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVidaArchivo;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IHojaDeVidaArchivo {

    void guardar(String numeroDocumento, MultipartFile archivo) throws IOException;
    void actualizarHojaDeVida(String id, MultipartFile nuevoArchivo) throws IOException;
    public void eliminarPorId(String id);
    GridFSFile obtenerArchivo(String gridFsId);
    List<HojaDeVidaArchivo> listarPorDocumento(String filtro);
}
