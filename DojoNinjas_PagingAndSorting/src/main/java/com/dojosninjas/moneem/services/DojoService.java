package com.dojosninjas.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosninjas.moneem.models.Dojo;
import com.dojosninjas.moneem.repositories.DojoRepository;

@Service
public class DojoService {

	// inject dojo repository
	@Autowired
	private DojoRepository dojoRepo;

	// create
	public Dojo addDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	// get one dojo
	public Dojo getDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		}
		return null;

	}
	
	
	// retrieve all dojos and ninjas that have 1:n relationship with specific dojos
	public List<Object[]> getNinjasDojos(){
		return this.dojoRepo.joinDojosAndNinjas2();
	}

	// get all dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
}
