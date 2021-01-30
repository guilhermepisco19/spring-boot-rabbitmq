package com.example.springconsumer.service;

import com.example.springproducer.dto.Message;

public interface ConsumerService {

	public void action(Message msg);
}
