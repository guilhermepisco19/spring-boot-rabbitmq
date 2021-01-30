package com.example.springconsumer.service.implementation;

import org.springframework.stereotype.Service;

import com.example.springconsumer.service.ConsumerService;
import com.example.springproducer.dto.Message;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(Message msg) {
		System.out.println(msg.getText());
	}

}
