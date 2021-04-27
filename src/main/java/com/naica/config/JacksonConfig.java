package com.naica.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naica.services.EmailService;
import com.naica.services.SmtpEmailService;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                super.configure(objectMapper);
            }
        };
        return builder;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }


}
