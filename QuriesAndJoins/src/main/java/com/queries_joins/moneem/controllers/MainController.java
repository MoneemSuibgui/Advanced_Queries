package com.queries_joins.moneem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.queries_joins.moneem.services.CityService;
import com.queries_joins.moneem.services.CountryService;

@Controller
public class MainController {

	// inject services in MainController
	@Autowired
	private CountryService apiCountryService;

	@Autowired
	private CityService apiCityService;

	@GetMapping("/")
	public String index(Model model) {

		// get list of objects and passing through the model to display them into to the jsp file
		List<Object[]> countriesSpeaksSlovene = this.apiCountryService.getCountriesSpeakSolvene();
		model.addAttribute("countriesSpeaksSlovene", countriesSpeaksSlovene);

		List<Object[]> getEachCountryAndNbrOfCities = this.apiCountryService.getEachCountryNumberOfCities();
		model.addAttribute("getEachCountryAndNbrOfCities", getEachCountryAndNbrOfCities);

		List<Object[]> getMexicoCitiesAndPopulation = this.apiCountryService.getMexicoCitiesWithPopulation();
		model.addAttribute("getMexicoCitiesAndPopulation", getMexicoCitiesAndPopulation);

		List<Object[]> getLanguageAndPercentageForEachCountry = this.apiCountryService
				.getLanguageAndPercentageForEachCountry();
		model.addAttribute("getLanguageAndPercentageForEachCountry", getLanguageAndPercentageForEachCountry);

		List<Object[]> getCountriesWithPopulationAndSurfaceArea = this.apiCountryService
				.getAllCountriesWithPopulationAndSurfaceArea();
		model.addAttribute("getCountriesWithPopulationAndSurfaceArea", getCountriesWithPopulationAndSurfaceArea);

		List<Object[]> getCountriesWithConstitutionalMonarchy = this.apiCountryService
				.getAllCountriesWithConstitutionalMonarchy();
		model.addAttribute("getCountriesWithConstitutionalMonarchy", getCountriesWithConstitutionalMonarchy);

		List<Object[]> getAllCitiesOfArgentinaInsideBuenosAiresDistrict = this.apiCityService
				.getCitiesOfArgentinaInsideBuenosAiresDistrict();
		model.addAttribute("getCitiesOfArgentinaInsideBuenosAiresDistrict",
				getAllCitiesOfArgentinaInsideBuenosAiresDistrict);

		List<Object[]> getNumberOfCountriesBelongsToEachRegion = this.apiCountryService
				.getRegionAndNumberOfCountriesBelongs();
		model.addAttribute("getNumberOfCountriesBelongsToEachRegion", getNumberOfCountriesBelongsToEachRegion);
		return "index.jsp";
	}
}
