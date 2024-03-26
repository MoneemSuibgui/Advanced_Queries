package com.queries_joins.moneem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.queries_joins.moneem.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	// Query 7: What query would you run to get all the cities of Argentina inside the Buenos
	// Aires district and have the population greater than 500, 000? The query
	// should return the Country Name, City Name, District, and Population.
	@Query(value = """
			SELECT countries.name, cities.name, cities.population,cities.district AS district FROM cities
			INNER JOIN countries ON countries.id=cities.country_id
			WHERE cities.population > 500000 AND countries.name="Argentina"AND district="Buenos Aires";
				""", nativeQuery = true)
	List<Object[]> getAllCitiesOfArgentina();

}
