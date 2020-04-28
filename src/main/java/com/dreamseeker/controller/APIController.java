package com.dreamseeker.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dreamseeker.controller.errors.ErrorTasa;
import com.dreamseeker.controller.exceptions.ResourceNotFoundException;
import com.dreamseeker.model.entities.Seller;
import com.dreamseeker.model.entities.Tasa;
import com.dreamseeker.model.services.DAOTasaService;

@RestController
public class APIController {

	@Autowired
	DAOTasaService repo;
	
	@GetMapping("/tasas")
	public Tasa getTasas() {
		return repo.findTasas().orElseThrow(ResourceNotFoundException::new);
	}
	
	
	@PostMapping("/sellers/addNew")
	public ResponseEntity<Seller> addNewSeller(@RequestBody Seller seller, UriComponentsBuilder uriBuilder) {
		seller = repo.save(seller);
		String id = Long.toString(seller.getId());
		
		URI uri = uriBuilder.path("/sellers/").path(id).build().toUri();
		
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uri);
		return new ResponseEntity<Seller>(seller,header,HttpStatus.CREATED);
	}
	
	@GetMapping("/sellers/{id}")
	public Seller getSeller(@PathVariable long id) {
		return repo.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	@PutMapping("/sellers/{id}")
	public Seller updateSeller(@PathVariable long id, @RequestBody Seller modifiedSeller) {
		System.out.println("ID: " + id);
		Seller currentSeller = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
		currentSeller.setName(modifiedSeller.getName());
		currentSeller.setTasa(modifiedSeller.getTasa());
		return repo.save(currentSeller);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorTasa tasaNotFound(ResourceNotFoundException e) {
		return new ErrorTasa(e.getMessage());
	}
}
