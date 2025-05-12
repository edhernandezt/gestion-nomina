package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.DesprendibleNominaDTO;
import co.edu.unbosque.gestion_nomina.repository.NominaRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDesprendibleMasivoService;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDesprendibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DesprendibleMasivoService implements IDesprendibleMasivoService {

    private final NominaRepository nominaRepository;
    private final IDesprendibleService desprendibleService;
    private final TemplateEngine templateEngine;

    @Autowired
    public DesprendibleMasivoService(NominaRepository nominaRepository, IDesprendibleService desprendibleService, TemplateEngine templateEngine) {
        this.nominaRepository = nominaRepository;
        this.desprendibleService = desprendibleService;
        this.templateEngine = templateEngine;
    }

    @Override
    @Transactional(readOnly = true)
    public byte[] generarDesprendiblesComoZip(LocalDate fechaInicio, LocalDate fechaFin) throws IOException {
        var nominas = nominaRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, "");

        Path tempDir = Files.createTempDirectory("desprendibles");
        Path zipPath = tempDir.resolve("desprendibles_nomina.zip");

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath.toFile()))) {
            for (var nomina : nominas) {
                DesprendibleNominaDTO dto = desprendibleService.obtenerDesprendiblePorIdNomina(nomina.getIdNomina());
                String html = renderizarHtml(dto);
                byte[] pdfBytes = generarPdfDesdeHtml(html);

                String filename = "desprendible_" + dto.getDocumento() + ".pdf";
                zipOut.putNextEntry(new ZipEntry(filename));
                zipOut.write(pdfBytes);
                zipOut.closeEntry();
            }
        }

        byte[] zipBytes = Files.readAllBytes(zipPath);
        Files.walk(tempDir)
                .sorted((a, b) -> b.compareTo(a))
                .map(Path::toFile)
                .forEach(File::delete);

        return zipBytes;
    }

    private String renderizarHtml(DesprendibleNominaDTO dto) {
        Context context = new Context();
        context.setVariable("desprendible", dto);
        return templateEngine.process("desprendible_pdf", context);
    }

    private byte[] generarPdfDesdeHtml(String html) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(html, null);
        builder.toStream(outputStream);
        builder.run();
        return outputStream.toByteArray();
    }
}
