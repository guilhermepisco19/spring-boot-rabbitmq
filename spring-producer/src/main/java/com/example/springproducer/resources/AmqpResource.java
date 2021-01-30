package com.example.springproducer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproducer.dto.Message;
import com.example.springproducer.service.AmqpService;

@RestController
public class AmqpResource {

	@Autowired
	private AmqpService service;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/send")
	public void sendToConsumer(@RequestBody Message msg) {
		service.sendToConsumer(msg);
	}
	
}
