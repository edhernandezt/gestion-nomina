package co.edu.unbosque.gestion_nomina.service.implementations;

import co.edu.unbosque.gestion_nomina.exceptions.CargoException;
import co.edu.unbosque.gestion_nomina.model.dto.CargoDTO;
import co.edu.unbosque.gestion_nomina.model.entity.Cargo;
import co.edu.unbosque.gestion_nomina.repository.CargoRepository;
import co.edu.unbosque.gestion_nomina.service.interfaces.ICrud;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService implements ICrud<CargoDTO, Integer> {

    private final CargoRepository cargoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CargoService(CargoRepository cargoRepository, ModelMapper modelMapper) {
        this.cargoRepository = cargoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(CargoDTO objetoDTO) {
        Cargo cargo = modelMapper.map(objetoDTO, Cargo.class);
        cargoRepository.save(cargo);
    }

    @Override
    public Optional<CargoDTO> find(Integer id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new CargoException("Cargo con ID " + id + " no encontrado"));
        return Optional.of(modelMapper.map(cargo, CargoDTO.class));
    }

    @Override
    public CargoDTO update(Integer id, CargoDTO objetoDTO) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new CargoException("No se puede actualizar. Cargo con ID " + id + " no existe"));

        cargo.setNombre(objetoDTO.getNombre());

        Cargo actualizado = cargoRepository.save(cargo);
        return modelMapper.map(actualizado, CargoDTO.class);
    }

    @Override
    public void delete(Integer id) {
        if (!cargoRepository.existsById(id)) {
            throw new CargoException("No se puede eliminar. Cargo con ID " + id + " no existe");
        }
        cargoRepository.deleteById(id);
    }

    @Override
    public List<CargoDTO> findAll() {
        return cargoRepository.findAll()
                .stream()
                .map(cargo -> modelMapper.map(cargo, CargoDTO.class))
                .collect(Collectors.toList());
    }
}
