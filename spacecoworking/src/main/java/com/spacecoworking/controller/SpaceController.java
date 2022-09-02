package com.spacecoworking.controller;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacecoworking.exception.ResourceNotFoundException;
import com.spacecoworking.model.Space;
import com.spacecoworking.service.SpaceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/space")
public class SpaceController {
	@Autowired
	private SpaceService spaceService;

	@GetMapping("/city/{city}")
	public List<Space> findByCity(@PathVariable("city") String city) {
		return this.spaceService.findByCity(city);
	}

	@GetMapping
	public Page<Space> findAll(Pageable pageable) {
		return this.spaceService.findAll(pageable);
	}

	@GetMapping("/limit")
	public List<Space> findTop6() {

		return this.spaceService.getAllLimited();

	}
	
	@GetMapping("/cities")
	public List<String> getCities() {
		return this.spaceService.getCities();

	}
	
	@GetMapping("/{id}")
	public Space getById(@PathVariable("id") Integer id) throws ResourceNotFoundException{
		return this.spaceService.findById(id);

	}
	
	
}
