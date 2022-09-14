package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.client.PaisClient;
import com.example.springboot.client.ProductosClient;
import com.example.springboot.wsdl.paises.GetPaisResponse;
import com.example.springboot.wsdl.productos.GetProductosResponse;


@SpringBootApplication
public class ClienteWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteWsApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(PaisClient paisClient, ProductosClient productosClient) {
        return args -> {
            String paisNombre = "francia";
            String productoNombre = "monitor";
            
            GetPaisResponse response1 = paisClient.getPais(paisNombre);
            System.out.println(response1.getPais().getNombre());
            System.out.println(response1.getPais().getCapital());
            System.out.println(response1.getPais().getPoblacion());
            System.out.println(response1.getPais().getMoneda());
            GetProductosResponse response2 = productosClient.getProducto(productoNombre);
            System.out.println(response2.getProducto().getNombre());
            System.out.println(response2.getProducto().getDescripcion());
            System.out.println(response2.getProducto().getTipo());
            System.out.println(response2.getProducto().isEstado());
        };
    }
	

}
