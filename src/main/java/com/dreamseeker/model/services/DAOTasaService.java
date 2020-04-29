package com.dreamseeker.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamseeker.model.entities.Seller;
import com.dreamseeker.model.entities.Tasa;
import com.dreamseeker.model.repos.SellersRepository;
import com.dreamseeker.model.repos.TasasRepository;

@Service
public class DAOTasaService {
	
	@Autowired
	TasasRepository tasasRepo;
	
	@Autowired
	SellersRepository sellerRepo;

	public Optional<Tasa> findTasas() {
		return tasasRepo.findById(1L);
	}

	public Seller save(Seller seller) {
		return sellerRepo.save(seller);
	}
	
	public Optional<Seller> findById(Long id) {
		return sellerRepo.findById(id);
	}

	public void deleteSeller(Long id) {
		sellerRepo.deleteById(id);
	}
	
}
