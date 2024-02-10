package com.rcastrucci.dev.commons.config;

import com.rcastrucci.dev.commons.ModelMapping;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

    @Bean
    public ModelMapping modelMapping() {
        return new ModelMapping(new ModelMapper());
    }

}