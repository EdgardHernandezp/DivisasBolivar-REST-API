package com.dreamseeker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dreamseeker.controller.errors.ErrorTasa;
import com.dreamseeker.controller.exceptions.TasaNotFoundException;
import com.dreamseeker.model.entities.Seller;
import com.dreamseeker.model.entities.Tasa;
import com.dreamseeker.model.services.DAOTasaService;

@RestController
public class APIController {

	@Autowired
	DAOTasaService repo;
	
	@GetMapping("/tasas")
	public Tasa getTasas() {
		Tasa tasa = repo.findTasas().get();
		if (tasa == null) throw new TasaNotFoundException();
		return tasa;
	}
	
	@ExceptionHandler(TasaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorTasa tasaNotFound(TasaNotFoundException e) {
		return new ErrorTasa(e.getMessage());
	}
	
	@PostMapping("/sellers/addNew")
	public Seller addNewSeller(@RequestBody Seller seller) {
		return repo.save(seller);
	}
}
