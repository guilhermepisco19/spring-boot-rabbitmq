package com.example.springproducer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.springproducer.amqp.AmqpProducer;
import com.example.springproducer.dto.Message;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message>{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.exchange.producer}")
	private String exchange;
	
	@Override
	public void producer(Message msg) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
		
	}

}
