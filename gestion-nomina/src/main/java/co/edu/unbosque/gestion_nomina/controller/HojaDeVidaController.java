package co.edu.unbosque.gestion_nomina.controller;

import co.edu.unbosque.gestion_nomina.model.document.HojaDeVida;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHojaDeVidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hojas-de-vida")
public class HojaDeVidaController {

    private final IHojaDeVidaService hojaDeVidaService;

    @Autowired
    public HojaDeVidaController(IHojaDeVidaService hojaDeVidaService) {
        this.hojaDeVidaService = hojaDeVidaService;
    }

    @GetMapping
    public String mostrarVista(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("hojas", hojaDeVidaService.buscarPorNombreODocumento(keyword));
        } else {
            model.addAttribute("hojas", hojaDeVidaService.buscarTodas());
        }
        model.addAttribute("nuevaHoja", new HojaDeVida());
        model.addAttribute("keyword", keyword);
        return "hojas_de_vida";
    }

    @PostMapping("/guardar")
    public String guardarHojaDeVida(
            @ModelAttribute HojaDeVida hoja,
            @RequestParam("estudiosStr") String estudiosStr,
            @RequestParam("habilidadesStr") String habilidadesStr,
            @RequestParam("certificacionesStr") String certificacionesStr,
            RedirectAttributes redirectAttributes
    ) {
        // Limpiar y separar por comas, ignorando espacios extras y vacíos
        hoja.setEstudios(Arrays.stream(estudiosStr.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));

        hoja.setHabilidades(Arrays.stream(habilidadesStr.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));

        hoja.setCertificaciones(Arrays.stream(certificacionesStr.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));

        hojaDeVidaService.guardarHojaDeVida(hoja);
        redirectAttributes.addFlashAttribute("mensajeHoja", "Hoja de vida registrada correctamente.");
        return "redirect:/hojas-de-vida";
    }


    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id, RedirectAttributes ra) {
        hojaDeVidaService.eliminarPorId(id);
        ra.addFlashAttribute("mensajeHoja", "Hoja de vida eliminada correctamente.");
        return "redirect:/hojas-de-vida";
    }
}
