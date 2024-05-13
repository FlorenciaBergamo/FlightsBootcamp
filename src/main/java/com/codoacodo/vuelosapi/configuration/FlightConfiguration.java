package com.codoacodo.vuelosapi.configuration;

import com.codoacodo.vuelosapi.models.Dollar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Dollar fetchDollar(){
        RestTemplate restTemplate = restTemplate();
        return restTemplate.getForObject("https://dolarapi.com/v1/dolares/tarjeta", Dollar.class);
    }

}