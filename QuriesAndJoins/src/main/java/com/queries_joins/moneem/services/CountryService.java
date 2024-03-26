package com.queries_joins.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queries_joins.moneem.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repository;
	
	// get all countries that speak slovene
	public List<Object[]> getCountriesSpeakSolvene(){
		return this.repository.getCountriesSpeakSlovene();
	}
	
	// get all countries name and the number of cities for each country
	public List<Object[]> getEachCountryNumberOfCities(){
		return this.repository.getEachCountryAndCitiesNumbers();
	}
	
	// get all cities and population in Mexico with popoulation grater than 500000
	public List<Object[]> getMexicoCitiesWithPopulation(){
		return this.repository.getCitiesInMexicoWithPopoulation();
	}
	
	// get all languages of each country and percentage of language grater than 89%
	public List<Object[]>getLanguageAndPercentageForEachCountry(){
		return this.repository.getAllLanguagesForEachCountry();
	}
	
	// get all the countries with Surface Area below 501 and Population greater than 100,000
	public List<Object[]> getAllCountriesWithPopulationAndSurfaceArea(){
		return this.repository.getCountriesWithPopulationAndSurfaceArea();
	}
	
	// Get all get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
	public List<Object[]> getAllCountriesWithConstitutionalMonarchy(){
		return this.repository.getCountriesWithConstitutionalMonarchy();
	}
	
	// Summarize the number of countries in each region
	public List<Object[]> getRegionAndNumberOfCountriesBelongs(){
		return this.repository.getNumberOfCountriesInEachRegion();
	}
}
