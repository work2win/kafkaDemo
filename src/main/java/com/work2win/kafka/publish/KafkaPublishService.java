package com.work2win.kafka.publish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.work2win.kafka.model.Product;

@Service
public class KafkaPublishService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplateUser;
	
	public void userInfo(List<Product> products){
		
		String message = products.toString();
		
		try {
			kafkaTemplateUser.send("topicName", message);
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
