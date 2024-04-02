package com.dojosninjas.moneem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dojosninjas.moneem.models.Ninja;



@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long> {

	// get all ninjas
	@Query("SELECT n FROM Ninja n")
	List<Ninja> findAll();
	
	// add ninja
	Ninja save(Ninja ninja);

	
	
	

}
