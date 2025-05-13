package co.edu.unbosque.gestion_nomina.configurations;

import co.edu.unbosque.gestion_nomina.model.dto.*;
import co.edu.unbosque.gestion_nomina.model.entity.*;
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

        modelMapper.addMappings(new PropertyMap<Nomina, NominaDTO>() {
            @Override
            protected void configure() {
                // Empleado
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());

                // Devengado
                map().setIdDevengado(source.getDevengado().getIdDevengado());
                map().setTotalDevengado(source.getDevengado().getTotalDevengado());

                // Deducción
                map().setIdDeduccion(source.getDeduccion().getIdDeduccion());
                map().setTotalDeducciones(source.getDeduccion().getTotalDeducciones());

                // Prestaciones sociales
                map().setIdPrestacionSocial(source.getPrestacionSocial().getIdPrestacion());
                map().setTotalPrestaciones(source.getPrestacionSocial().getTotalPrestaciones());

                // Aportes patronales
                map().setIdAportePatronal(source.getAportePatronal().getIdAporte());
                map().setTotalAportes(source.getAportePatronal().getTotalAportes());
            }
        });

        modelMapper.addMappings(new PropertyMap<Deduccion, DeduccionDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getDevengado().getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getDevengado().getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getDevengado().getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getDevengado().getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getDevengado().getEmpleado().getSegundoApellido());
                map().setDevengadoId(source.getDevengado().getIdDevengado());
            }
        });

        modelMapper.addMappings(new PropertyMap<HorasExtras, HorasExtrasDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
                map().setIdTipoHoraExtra(source.getTipoHoraExtra().getIdTipoHoraExtra());
                map().setDescripcionTipo(source.getTipoHoraExtra().getDescripcion());
            }
        });

        modelMapper.addMappings(new PropertyMap<PrestacionSocial, PrestacionSocialDTO>() {
            @Override
            protected void configure() {
                map().setEmpleadoId(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
            }
        });

        modelMapper.addMappings(new PropertyMap<AportePatronal, AportePatronalDTO>() {
            @Override
            protected void configure() {
                map().setIdEmpleado(source.getEmpleado().getIdEmpleado());
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
            }
        });

        modelMapper.addMappings(new PropertyMap<AuditoriaNomina, AuditoriaNominaDTO>() {
            @Override
            protected void configure() {
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
            }
        });

        modelMapper.addMappings(new PropertyMap<LiquidacionPrestacion, LiquidacionPrestacionDTO>() {
            @Override
            protected void configure() {
                map().setPrimerNombre(source.getEmpleado().getPrimerNombre());
                map().setSegundoNombre(source.getEmpleado().getSegundoNombre());
                map().setPrimerApellido(source.getEmpleado().getPrimerApellido());
                map().setSegundoApellido(source.getEmpleado().getSegundoApellido());
            }
        });
    }
}
