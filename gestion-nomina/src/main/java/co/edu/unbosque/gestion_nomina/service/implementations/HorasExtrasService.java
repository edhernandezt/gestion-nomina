package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.HorasExtrasDTO;
import co.edu.unbosque.gestion_nomina.repository.HorasExtrasRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.IHorasExtrasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class HorasExtrasService implements IHorasExtrasService {

    private final HorasExtrasRepository horasExtrasRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HorasExtrasService(HorasExtrasRepository horasExtrasRepository, ModelMapper modelMapper) {
        this.horasExtrasRepository = horasExtrasRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registrarHorasExtrasEmpleado(Integer idEmpleado, Integer idTipoHoraExtra,
                                             BigDecimal cantidadHoras, LocalDate fechaInicio, LocalDate fechaFin) {
        horasExtrasRepository.registrarHorasExtrasEmpleado(idEmpleado, idTipoHoraExtra, cantidadHoras, fechaInicio, fechaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorasExtrasDTO> findByFechasAndNombre(LocalDate fechaInicio, LocalDate fechaFin, String nombre) {
        return horasExtrasRepository.buscarPorNombreYFechas(fechaInicio, fechaFin, nombre)
                .stream()
                .map(he -> modelMapper.map(he, HorasExtrasDTO.class))
                .toList();
    }
}
