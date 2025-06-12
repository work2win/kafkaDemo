package com.work2win.kafka.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sampleMessage(String message){		
		
		try {
			kafkaTemplate.send("topicName", message);
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
	@KafkaListener(topics = "topicName", groupId = "topicGroupId")
	public void receiveMessage(String receivedMessage){
		
		System.out.println("Message received:" + receivedMessage);
	}

}
