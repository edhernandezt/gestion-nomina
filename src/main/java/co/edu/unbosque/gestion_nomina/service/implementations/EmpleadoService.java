package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.model.dto.EmpleadoDTO;
import co.edu.unbosque.gestion_nomina.repository.EmpleadoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements ICrud<EmpleadoDTO, String> {

    private final EmpleadoRepository empleadoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EmpleadoDTO objetoDTO) {

    }

    @Override
    public Optional<EmpleadoDTO> find(String id) {
        return Optional.empty();
    }

    @Override
    public void update(String id, EmpleadoDTO objetoDTO) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<EmpleadoDTO> findAll() {
        return List.of();
    }
}
