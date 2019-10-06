package com.soapserveryt.api.endpoint;

import com.soapserveryt.api.service.DataSoapService;
import com.soapserveryt.api.soap.ClientRequest;
import com.soapserveryt.api.soap.ServerRespond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * DataSoapEndpoint
 */
@Endpoint
public class DataSoapEndpoint {

    @Autowired
    private DataSoapService dataSoapService;

    @PayloadRoot(namespace = "http://www.soapserveryt.com/api/soap", localPart = "ClientRequest")
    @ResponsePayload
    public ServerRespond getLoadstatus(@RequestPayload ClientRequest request) {
        return dataSoapService.checkData(request);
    }
}