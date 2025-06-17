package com.work2win.kafka.publish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.work2win.kafka.model.Product;

@Service
public class KafkaPublishService {
	
	@Autowired
	KafkaTemplate<String, ArrayList<String>> kafkaTemplateUser;
	
	public void userInfo(List<Product> products){
		
		ArrayList<String> message = new ArrayList<String>();
		for(Product product: products) {			
			message.add(product.getName());			
		}		
			
		try {
			kafkaTemplateUser.send("kafkaDemoTopic", message);
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
