package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {
	
	@Autowired
	private CabLocationService cabLocationService;
	
	@PostMapping
	public void updateLocation() throws InterruptedException  {
		int range=100;
		while(range>0) {
			
			cabLocationService.updateLocation(Math.random()+","+Math.random());
			System.err.println(Math.random()+","+Math.random());
			Thread.sleep(1000);
			range--;
		}
		
	}

}
