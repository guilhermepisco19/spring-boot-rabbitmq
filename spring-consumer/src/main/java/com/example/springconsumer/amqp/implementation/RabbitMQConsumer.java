package com.example.springconsumer.amqp.implementation;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springconsumer.amqp.AmqpConsumer;
import com.example.springconsumer.service.ConsumerService;
import com.example.springproducer.dto.Message;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message>{

	@Autowired
	private ConsumerService consumerService;
	
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.routing-key.producer}")
	public void consumer(Message msg) {
		consumerService.action(msg);
	}

}
