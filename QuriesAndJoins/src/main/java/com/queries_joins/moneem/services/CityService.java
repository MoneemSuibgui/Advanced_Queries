package com.queries_joins.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queries_joins.moneem.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	public CityRepository repository;

	// get all the cities of Argentina inside the Buenos
	// Aires district and have the population greater than 500, 000
	public List<Object[]> getCitiesOfArgentinaInsideBuenosAiresDistrict(){
		return this.repository.getAllCitiesOfArgentina();
	}

}
