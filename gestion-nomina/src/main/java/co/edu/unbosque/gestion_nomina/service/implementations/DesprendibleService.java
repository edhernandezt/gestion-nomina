package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.ConceptoValorDTO;
import co.edu.unbosque.gestion_nomina.model.dto.DesprendibleNominaDTO;
import co.edu.unbosque.gestion_nomina.model.entity.*;
import co.edu.unbosque.gestion_nomina.repository.*;
import co.edu.unbosque.gestion_nomina.service.interfaces.IDesprendibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesprendibleService implements IDesprendibleService {

    private final NominaRepository nominaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final DevengadoRepository devengadoRepository;
    private final DeduccionRepository deduccionRepository;
    private final PrestacionSocialRepository prestacionRepository;
    private final AportePatronalRepository aporteRepository;

    @Autowired
    public DesprendibleService(
            NominaRepository nominaRepository,
            EmpleadoRepository empleadoRepository,
            DevengadoRepository devengadoRepository,
            DeduccionRepository deduccionRepository,
            PrestacionSocialRepository prestacionRepository,
            AportePatronalRepository aporteRepository) {
        this.nominaRepository = nominaRepository;
        this.empleadoRepository = empleadoRepository;
        this.devengadoRepository = devengadoRepository;
        this.deduccionRepository = deduccionRepository;
        this.prestacionRepository = prestacionRepository;
        this.aporteRepository = aporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DesprendibleNominaDTO obtenerDesprendiblePorIdNomina(Integer idNomina) {
        Nomina nomina = nominaRepository.findById(idNomina)
                .orElseThrow(() -> new RuntimeException("Nómina no encontrada"));

        Empleado empleado = empleadoRepository.findById(nomina.getEmpleado().getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Devengado devengado = devengadoRepository.findById(nomina.getDevengado().getIdDevengado())
                .orElseThrow(() -> new RuntimeException("Devengado no encontrado"));

        Deduccion deduccion = deduccionRepository.findById(nomina.getDeduccion().getIdDeduccion())
                .orElseThrow(() -> new RuntimeException("Deducción no encontrada"));

        PrestacionSocial prestacion = prestacionRepository.findById(nomina.getPrestacionSocial().getIdPrestacion())
                .orElseThrow(() -> new RuntimeException("Prestación no encontrada"));

        AportePatronal aporte = aporteRepository.findById(nomina.getAportePatronal().getIdAporte())
                .orElseThrow(() -> new RuntimeException("Aporte no encontrado"));

        DesprendibleNominaDTO dto = new DesprendibleNominaDTO();
        dto.setNombreEmpleado(empleado.getPrimerNombre() + " " + empleado.getPrimerApellido());
        dto.setDocumento(empleado.getNumeroDocumento());
        dto.setSalarioBasico(empleado.getSalarioBasico());
        dto.setFechaInicio(nomina.getFechaInicio());
        dto.setFechaFin(nomina.getFechaFin());

        // Ingresos
        List<ConceptoValorDTO> ingresos = new ArrayList<>();
        ingresos.add(new ConceptoValorDTO("Pago nominal", devengado.getSubTotal()));
        ingresos.add(new ConceptoValorDTO("Subsidio transporte", devengado.getAuxilioTransporte()));
        ingresos.add(new ConceptoValorDTO("Pago por horas extras", devengado.getTotalHorasExtras()));
        dto.setIngresos(ingresos);

        // Deducciones
        List<ConceptoValorDTO> deducciones = new ArrayList<>();
        deducciones.add(new ConceptoValorDTO("Salud", deduccion.getSalud()));
        deducciones.add(new ConceptoValorDTO("Pensión", deduccion.getPension()));
        deducciones.add(new ConceptoValorDTO("Fondo de Solidaridad", deduccion.getFondoSolidaridad()));
        deducciones.add(new ConceptoValorDTO("ReteFuente", deduccion.getReteFuente()));
        deducciones.add(new ConceptoValorDTO("Descuentos por días", deduccion.getDescuentosDias()));
        dto.setDeducciones(deducciones);

        dto.setTotalIngresos(devengado.getTotalDevengado());
        dto.setTotalDeducciones(deduccion.getTotalDeducciones());
        dto.setNetoPagar(nomina.getTotalAPagarEmpleado());

        return dto;
    }
}
