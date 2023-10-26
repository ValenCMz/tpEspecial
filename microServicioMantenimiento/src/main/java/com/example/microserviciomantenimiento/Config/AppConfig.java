package com.example.microserviciomantenimiento.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("mantenimientoRest")
    public RestTemplate registarRestTemplate() { return new RestTemplate(); }
}
