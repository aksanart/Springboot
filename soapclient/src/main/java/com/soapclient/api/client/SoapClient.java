package com.soapclient.api.client;

import com.soapclient.api.domain.ClientRequest;
import com.soapclient.api.domain.ServerRespond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * SoapClient
 */
@Service
public class SoapClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public ServerRespond respond(ClientRequest request) {
        template = new WebServiceTemplate(marshaller);
        ServerRespond respond = (ServerRespond) template.marshalSendAndReceive("http://localhost:8080/ws", request);
        return respond;
    }

}