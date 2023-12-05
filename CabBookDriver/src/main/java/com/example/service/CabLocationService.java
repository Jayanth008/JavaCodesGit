package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.config.KafkaConfig;

@Service
public class CabLocationService {
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		kafkaTemplate.send(KafkaConfig.CAB_LOCATION,location);
		return true;
	}
}
