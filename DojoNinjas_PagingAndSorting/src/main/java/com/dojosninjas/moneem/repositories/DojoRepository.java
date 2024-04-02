package com.dojosninjas.moneem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dojosninjas.moneem.models.Dojo;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Long> {

	// get all dojos using JPQL
	// JPQL is object oriented version of SQL in JPA
	// The query strings may look a little different but they have a lot of
	// similarities with plain SQL
	@Query(value = "SELECT d FROM Dojo d")
	List<Dojo> findAll();

	// ************ This extra queries exemples for advanced queries using JPQL **********
	// get all the names of the dojos with id. If we want to select specific
	// columns, we will get a list of Object arrays because they are no longer Dojo
	// objects. Each index of the array will be the column selected respectively.
	// Therefore 0 = id column, 1 = name column
//	@Query(value = "SELECT id, name FROM dojos", nativeQuery = true)
//	List<Object[]> findAllDojosNamesWithId2();

	// get one dojo
//    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
//    Dojo getDojoWhereId(Long id);
//    

	// get name of dojos and ninja belons to each dojo :Join the tow tables
	// retrieves the information about all the dojos
	// that have a relationship with a ninja.
	// We avoid doing N+1 queries by getting all the dojo and ninja information all
	// at once (1 query).
	@Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
	List<Object[]> joinDojosAndNinjas2();

}
