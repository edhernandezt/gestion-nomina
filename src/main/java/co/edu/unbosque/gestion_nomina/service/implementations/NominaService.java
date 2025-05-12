package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.NominaDTO;
import co.edu.unbosque.gestion_nomina.repository.NominaRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.INominaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class NominaService implements INominaService {

    private final NominaRepository nominaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NominaService(NominaRepository nominaRepository, ModelMapper modelMapper) {
        this.nominaRepository = nominaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void generarNominaMensual(LocalDate fechaInicio, LocalDate fechaFin) {
        nominaRepository.generarNominaMensual(fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NominaDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return nominaRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre)
                .stream()
                .map(nomina -> modelMapper.map(nomina, NominaDTO.class))
                .toList();
    }
}
