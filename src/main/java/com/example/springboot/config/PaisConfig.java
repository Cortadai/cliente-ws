package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.springboot.client.PaisClient;

@Configuration
public class PaisConfig {

	@Bean
    public Jaxb2Marshaller paisesMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // context para marshaller = paqueteria donde se generan las clases por plugin
        marshaller.setContextPath("com.example.springboot.wsdl.paises");
        return marshaller;
    }

    @Bean
    public PaisClient paisClient() {
    	PaisClient client = new PaisClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(paisesMarshaller());
        client.setUnmarshaller(paisesMarshaller());
        return client;
    }
	
	
}
