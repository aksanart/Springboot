package com.soapclient;

import com.soapclient.api.client.SoapClient;
import com.soapclient.api.domain.ClientRequest;
import com.soapclient.api.domain.ServerRespond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	@Autowired
	private SoapClient client;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostMapping("/api")
	public ServerRespond respond(@RequestBody ClientRequest request) {
		return client.respond(request);
	}

	@GetMapping("/tes")
	public String test() {
		return "test";
	}

}
