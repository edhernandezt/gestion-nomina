package co.edu.unbosque.gestion_nomina.configurations;

import co.edu.unbosque.gestion_nomina.model.dto.DevengadoDTO;
import co.edu.unbosque.gestion_nomina.model.dto.NovedadDTO;
import co.edu.unbosque.gestion_nomina.model.entity.Devengado;
import co.edu.unbosque.gestion_nomina.model.entity.Novedad;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        cargarMapeos(modelMapper);
        return modelMapper;
    }

    public void cargarMapeos(ModelMapper modelMapper){

        // Mapeo para Devengado - DevengadoDTO
        modelMapper.addMappings(new PropertyMap<Devengado, DevengadoDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
            }
        });

        // Mapeo para Novedad - NovedadDTO
        modelMapper.addMappings(new PropertyMap<Novedad, NovedadDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
                map().setDescripcion(source.getTipoNovedad().getDescripcion());
            }
        });
    }
}
