package com.example.springproducer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproducer.amqp.AmqpProducer;
import com.example.springproducer.dto.Message;
import com.example.springproducer.service.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService{

	@Autowired
	private AmqpProducer<Message> amqp;
	
	@Override
	public void sendToConsumer(Message msg) {
		amqp.producer(msg);
	}

}
