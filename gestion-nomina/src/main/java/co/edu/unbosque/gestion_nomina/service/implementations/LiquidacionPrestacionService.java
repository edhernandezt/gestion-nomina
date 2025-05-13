package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.LiquidacionPrestacionDTO;
import co.edu.unbosque.gestion_nomina.repository.LiquidacionPrestacionRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ILiquidacionPrestacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class LiquidacionPrestacionService implements ILiquidacionPrestacionService {

    private final LiquidacionPrestacionRepository repository;
    private final ModelMapper modelMapper;

    public LiquidacionPrestacionService(LiquidacionPrestacionRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void generarLiquidacionPorSemestre(Integer anio, Integer semestre) {
        if (yaExisteLiquidacion(anio, semestre)) {
            throw new IllegalStateException("Ya existe una liquidación generada para ese semestre.");
        }
        repository.generarLiquidacionPrestaciones(anio, semestre);
    }

    @Override
    public boolean yaExisteLiquidacion(int anio, int semestre) {
        return repository.existsByAnioAndSemestre(anio, semestre);
    }

    @Override
    @Transactional
    public List<LiquidacionPrestacionDTO> buscarPorNombreYPeriodo(Integer anio, Integer semestre, String nombre) {
        return repository.buscarPorAnioSemestreYNombre(anio, semestre, nombre).stream()
                .map(lp -> modelMapper.map(lp, LiquidacionPrestacionDTO.class))
                .toList();
    }
}
