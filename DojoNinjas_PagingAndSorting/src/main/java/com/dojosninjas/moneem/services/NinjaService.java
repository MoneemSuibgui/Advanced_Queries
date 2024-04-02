package com.dojosninjas.moneem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dojosninjas.moneem.models.Ninja;
import com.dojosninjas.moneem.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;

	// static variable to set the number of ninjas that we want per pag
	private static  int sizePage =5;

	public Page<Ninja> getNinjasPerPage(int numberOfPages) {
		 // get all the ninjas page and sort them in ascending order by the property name of dojo
		PageRequest requestPage=PageRequest.of(numberOfPages, sizePage, Sort.Direction.ASC, "dojo.name");
		// Page<T> findAll(Pageable pageable): Returns a Page of entities meeting the paging restriction provided in the Pageable object.
		Page<Ninja> ninjas= this.ninjaRepo.findAll(requestPage);
		return ninjas;

	}

	// add ninja
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

}
