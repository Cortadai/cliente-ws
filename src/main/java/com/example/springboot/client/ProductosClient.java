package com.example.springboot.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.springboot.wsdl.paises.GetPaisRequest;
import com.example.springboot.wsdl.paises.GetPaisResponse;
import com.example.springboot.wsdl.productos.GetProductosRequest;
import com.example.springboot.wsdl.productos.GetProductosResponse;

public class ProductosClient extends WebServiceGatewaySupport {

	public GetProductosResponse getProducto(String productoNombre){
        GetProductosRequest request = new GetProductosRequest();
        request.setNombre(productoNombre);

        return (GetProductosResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
	
}
