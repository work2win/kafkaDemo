package com.work2win.kafka.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {
	
	@Autowired
	SampleService service;	
	
	@GetMapping("/sample")
	public void sampleMessage(@RequestParam("message") String message){		
		service.sampleMessage(message);
		
	}

}
