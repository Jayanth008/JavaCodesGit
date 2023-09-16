package com.bookauthor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookauthor.service.UsaDataService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.bookauthor.service.UsaDataService;

//@RestController
@Controller
public class UsaDataController {
	@Autowired
	private UsaDataService usaDataService;

	@GetMapping("/usaData")
	public String getUsaData(Model model) {
//		return usaDataService.getUsaData();
		JsonNode jsonData = usaDataService.getUsaData();
//		ObjectMapper om = new ObjectMapper();
//		List<Object> list = om.convertValue(jsonData, new TypeReference<List<Object>>() {});
		List<Object> list = Arrays.asList(new ObjectMapper().convertValue(jsonData, Object[].class));
		System.out.println(jsonData);
		System.err.println(list);
//		ArrayNode jsonData = (ArrayNode)jsonData1;
//		System.out.println("controller ");
//		return usaDataService.getUsaData();
//		System.err.println("controller"+jsonData);
//		model.addAttribute("usa", data);
		model.addAttribute("jsondata", list);
		return "allUsaPopulation";

	}

	@GetMapping("/check")
	@ResponseBody
	public JsonNode n() {
		return usaDataService.getUsaData();
	}
}
