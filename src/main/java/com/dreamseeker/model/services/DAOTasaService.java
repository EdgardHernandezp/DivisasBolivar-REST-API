package com.dreamseeker.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamseeker.model.entities.Tasa;
import com.dreamseeker.model.repos.TasasRepository;

@Service
public class DAOTasaService {
	
	@Autowired
	TasasRepository tasasRepo;

	public Optional<Tasa> findTasas() {
		return tasasRepo.findById(1L);
	}
	
}
