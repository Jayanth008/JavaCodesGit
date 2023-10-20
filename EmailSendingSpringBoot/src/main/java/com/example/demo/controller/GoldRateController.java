package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GoldModel;
import com.example.demo.repositry.GoldRepo;

@RestController
public class GoldRateController {
	@Autowired
	private GoldRepo goldRepo;

	@PostMapping("/addGoldRate")
	public GoldModel addGoldRate(@RequestBody GoldModel model) {
		return goldRepo.save(model);
	}

	@PostMapping("/addGoldRates")
    public List<GoldModel> addGoldRates(@RequestBody List<GoldModel> models) {
        return goldRepo.saveAll(models);
    }

	@GetMapping("/price")
	public void price() {
		LocalDate date=LocalDate.now();
		System.out.println(goldRepo.findByDate(date).getPrice());
	}
}
