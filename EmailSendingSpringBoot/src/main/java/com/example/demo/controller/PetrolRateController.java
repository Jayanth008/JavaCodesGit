package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PetrolModel;
import com.example.demo.repositry.PetrolRepo;

@RestController
public class PetrolRateController {
	@Autowired
	private PetrolRepo petrolRepo;

	@PostMapping("/addPetrolRates")
	public List<PetrolModel> addGoldRates(@RequestBody List<PetrolModel> models) {
		return petrolRepo.saveAll(models);
	}
}
