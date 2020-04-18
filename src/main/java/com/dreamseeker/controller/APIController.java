package com.dreamseeker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamseeker.model.entities.Seller;
import com.dreamseeker.model.entities.Tasa;
import com.dreamseeker.model.services.DAOTasaService;

@RestController
public class APIController {

	@Autowired
	DAOTasaService repo;
	
	@GetMapping("/tasas")
	public Tasa getTasas() {
		return repo.findTasas().get();
	}
	
	@PostMapping("/sellers/addNew")
	public Seller addNewSeller(@RequestBody Seller seller) {
		return repo.save(seller);
	}
}
