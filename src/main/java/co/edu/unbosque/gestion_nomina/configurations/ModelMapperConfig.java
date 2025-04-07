package co.edu.unbosque.gestion_nomina.configurations;

import co.edu.unbosque.gestion_nomina.model.dto.*;
import co.edu.unbosque.gestion_nomina.model.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;

    }
}