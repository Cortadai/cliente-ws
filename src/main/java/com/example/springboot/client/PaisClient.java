package com.example.springboot.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.springboot.wsdl.paises.GetPaisRequest;
import com.example.springboot.wsdl.paises.GetPaisResponse;

public class PaisClient extends WebServiceGatewaySupport {

	public GetPaisResponse getPais(String paisNombre){
        GetPaisRequest request = new GetPaisRequest();
        request.setNombre(paisNombre);

        return (GetPaisResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
	
}
