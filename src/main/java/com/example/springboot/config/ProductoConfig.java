package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.springboot.client.PaisClient;
import com.example.springboot.client.ProductosClient;

@Configuration
public class ProductoConfig {

	@Bean
    public Jaxb2Marshaller productosMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // context para marshaller = paqueteria donde se generan las clases por plugin
        marshaller.setContextPath("com.example.springboot.wsdl.productos");
        return marshaller;
    }

    @Bean
    public ProductosClient productosClient() {
    	ProductosClient client = new ProductosClient();
        client.setDefaultUri("http://localhost:8082/ws");
        client.setMarshaller(productosMarshaller());
        client.setUnmarshaller(productosMarshaller());
        return client;
    }
	
	
}
