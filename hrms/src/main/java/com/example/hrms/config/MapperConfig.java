package com.example.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.modelmapper.ModelMapper;
@Configuration
public class MapperConfig {

	// new lemeden kullanabilceğiz
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();



    }

}