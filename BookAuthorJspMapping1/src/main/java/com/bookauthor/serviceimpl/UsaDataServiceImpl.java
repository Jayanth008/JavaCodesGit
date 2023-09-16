package com.bookauthor.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookauthor.service.UsaDataService;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class UsaDataServiceImpl implements UsaDataService {

	@Autowired
	private RestTemplate rtemplate;

	@Value("${spring.usa.data}")
	private String resourceUrlUsaData;

	@Override
	public JsonNode getUsaData() {
		// TODO Auto-generated method stub
//		RestTemplate template=new RestTemplate();
		JsonNode usadata = rtemplate.getForObject(resourceUrlUsaData, JsonNode.class);
		JsonNode usa = usadata.get("data");
//		System.err.println(usa);
		/*
		 * for (JsonNode n : usa) { System.err.println(n.get("ID State") + " " +
		 * n.get("State") + " " + n.get("ID Year") + " " + n.get("Year") + " " +
		 * n.get("Population") + " " + n.get("Slug State")); }
		 */

//		System.out.println(usadata);
//		System.out.println("sevice calling ");
		return usa;
	}

}
