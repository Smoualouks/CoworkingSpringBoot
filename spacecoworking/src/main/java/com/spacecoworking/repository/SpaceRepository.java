package com.spacecoworking.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spacecoworking.model.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space,Integer> {
	
	public List<Space> findByCity(String city);
	
	Page<Space> findAll(Pageable pageable);
	/*
	 * la méthode getCities affiche la liste des villes sans doublant abritant un espace Coworking. 
	 */
	@Query(value="SELECT DISTINCT s.city FROM space s ORDER BY s.city ASC", nativeQuery = true)
	public List<String> getCities();
	
	
}
