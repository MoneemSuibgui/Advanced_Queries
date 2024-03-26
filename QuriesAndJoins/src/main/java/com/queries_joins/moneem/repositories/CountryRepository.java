package com.queries_joins.moneem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.queries_joins.moneem.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	// ******************************* USING native query***************//

	// Query 1 : What query would you run to get all the countries that speak
	// Slovene? Your
	// query should return the name of the country, language, and language
	// percentage. Your query should arrange the result by language percentage in
	// descending order.

	@Query(value = """
			SELECT countries.name,languages.language,languages.percentage FROM countries
			JOIN languages ON countries.id=languages.country_id
			WHERE languages.language="Slovene"
			ORDER BY languages.percentage  DESC;
			""", nativeQuery = true)
	List<Object[]> getCountriesSpeakSlovene();

	// Query 2 : What query would you run to display the total number of cities for
	// each country? Your query should return the name of the country and the total
	// number of cities. Your query should arrange the result by the number of
	// cities in descending order.

	@Query(value = """
			SELECT countries.name,count(cities.id)as 'sum' from countries
			JOIN cities ON cities.country_id=countries.id
			GROUP BY countries.id
			ORDER BY count(cities.id) DESC;
			""", nativeQuery = true)
	List<Object[]> getEachCountryAndCitiesNumbers();

	// Query 3 :What query would you run to get all the cities in Mexico with a
	// population of greater than 500,000? Your query should arrange the result by
	// population in descending order.
	@Query(value = """
			SELECT cities.name, cities.population FROM countries
			JOIN cities ON cities.country_id=countries.id
			WHERE countries.name="Mexico" AND cities.population>500000
			         ORDER BY cities.population DESC;
				""", nativeQuery = true)
	List<Object[]> getCitiesInMexicoWithPopoulation();

	// Qeury 4: What query would you run to get all languages in each country with a
	// percentage greater than 89%? Your query should arrange the result by
	// percentage in descending order.
	@Query(value = """
			SELECT languages.language,percentage FROM countries
			INNER JOIN languages ON languages.country_id=countries.id
			WHERE percentage>89
			ORDER BY percentage DESC;
				""", nativeQuery = true)
	List<Object[]> getAllLanguagesForEachCountry();

	// Query 5 : What query would you run to get all the countries with Surface Area
	// below 501 and Population greater than 100,000? order by population desc
	@Query(value = """
			SELECT name,surface_area,population FROM countries
			WHERE surface_area < 501 AND population > 100000
			ORDER BY population DESC;
				""", nativeQuery = true)
	List<Object[]> getAllCountriesWithPopulationAndSurfaceArea();
	// ******************************** Query 5 :USING JPQL ********************//
	// Query 5 : Other way to get all the countries with Surface Area
	// below 501 and Population greater than 100,000? order by population desc
	// using JPQL Query
		@Query(value = """
				SELECT c.name,c.surfaceArea,c.population FROM Country c
				WHERE c.surfaceArea < 501 AND c.population > 100000
				ORDER BY c.population DESC
					""")
		List<Object[]> getCountriesWithPopulationAndSurfaceArea();
	//**************************************************************************//

	// Query 6 :What query would you run to get countries with only Constitutional
	// Monarchy with a surface area of more than 200 and a life expectancy greater
	// than 75 years?
	@Query(value = """
			SELECT name, surface_area, life_expectancy FROM countries
			WHERE government_form = "Constitutional Monarchy"
			AND surface_area > 200 AND life_expectancy > 75;
				""", nativeQuery = true)
	List<Object[]> getCountriesWithConstitutionalMonarchy();

	// Query 8 : What query would you run to summarize the number of countries in
	// each region ? The query should display the name of the region and the number
	// of countries. Also, the query should arrange the result by the number of
	// countries in descending order.
	@Query(value = """
			SELECT region,count(countries.id) AS numberOfRegion FROM countries
			         GROUP BY countries.region
			ORDER BY numberOfRegion DESC;

			""", nativeQuery = true)
	List<Object[]> getNumberOfCountriesInEachRegion();

}
