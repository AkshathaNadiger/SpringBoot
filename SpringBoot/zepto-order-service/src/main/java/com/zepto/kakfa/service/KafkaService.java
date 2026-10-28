package com.zepto.kakfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	KafkaTemplate<String, String> kakfaTemplate;
	
	
	public void sendMessage(String _topic, String _message) {
		
		
		System.out.println("KafkaService.sendMessage()::::Sending Message to Kafka");
		String key = "ORD123";
		kakfaTemplate.send(_topic,"key", _message);
		
		
	}

}
