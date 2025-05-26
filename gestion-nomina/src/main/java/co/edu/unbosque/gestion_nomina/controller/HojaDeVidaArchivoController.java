package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.service.interfaces.IHojaDeVidaArchivo;
import com.mongodb.client.gridfs.model.GridFSFile;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/hojas-de-vida")
public class HojaDeVidaArchivoController {

    private final IHojaDeVidaArchivo service;
    private final GridFsOperations operations;

    @Autowired
    public HojaDeVidaArchivoController(IHojaDeVidaArchivo service, GridFsOperations operations) {
        this.service = service;
        this.operations = operations;
    }

    @GetMapping
    public String verSubidas(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("archivos", service.listarPorDocumento(keyword));
        model.addAttribute("keyword", keyword);
        return "hojas_de_vida_pdf";
    }

    @PostMapping("/subir")
    public String subir(@RequestParam("numeroDocumento") String doc,
                        @RequestParam("archivo") MultipartFile archivo,
                        RedirectAttributes redirectAttributes) {
        try {
            service.guardar(doc, archivo);
            redirectAttributes.addFlashAttribute("mensajeHoja", "PDF cargado correctamente.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorHoja", ex.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorHoja", "Error inesperado: " + e.getMessage());
        }
        return "redirect:/hojas-de-vida";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarHojaDeVida(@PathVariable String id,
                                       @RequestParam("archivoNuevo") MultipartFile nuevoArchivo,
                                       RedirectAttributes redirectAttributes) {
        try {
            service.actualizarHojaDeVida(id, nuevoArchivo);
            redirectAttributes.addFlashAttribute("mensajeHoja", "Hoja de vida actualizada exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorHoja", "Error al actualizar: " + e.getMessage());
        }
        return "redirect:/hojas-de-vida";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarHojaDeVida(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            service.eliminarPorId(id);
            redirectAttributes.addFlashAttribute("mensajeHoja", "Hoja de vida eliminada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorHoja", "Error al eliminar: " + e.getMessage());
        }
        return "redirect:/hojas-de-vida";
    }

    @GetMapping("/ver/{gridFsId}")
    public void verPdf(@PathVariable String gridFsId, HttpServletResponse response) throws IOException {
        GridFSFile archivo = service.obtenerArchivo(gridFsId);
        if (archivo == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        try (InputStream in = operations.getResource(archivo).getInputStream()) {
            response.setContentType("application/pdf");
            StreamUtils.copy(in, response.getOutputStream());
        }
    }
}

