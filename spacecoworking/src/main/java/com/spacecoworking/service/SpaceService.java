package com.spacecoworking.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import com.spacecoworking.exception.ResourceNotFoundException;
import com.spacecoworking.model.Space;
import com.spacecoworking.model.User;
import com.spacecoworking.repository.SpaceRepository;

@Service
public class SpaceService {
	
	private static final int LIMIT = 6;
	@Autowired

	public SpaceRepository spaceRepository;

	/* la méthode findByCity renvoi les éspaces appartenant à cette même ville */
	
	public List<Space> findByCity(String city) {

		return this.spaceRepository.findByCity(city);

	}

	/* la méthode findAll renvoie tous les éspaces  de table space*/
	
	public Page<Space> findAll(Pageable pageable) {

		return this.spaceRepository.findAll(pageable);
	}

	/* même méthode que findAll mais  limitation en 6 espaces*/
	public List<Space> getAllLimited() {

		Page<Space> page = spaceRepository.findAll(PageRequest.of(0, LIMIT));
		return page.getContent();

	}
	 
	public List<String> getCities(){
		return this.spaceRepository.getCities();
		
	}
	
	
	public Space findById(Integer space_id) throws ResourceNotFoundException{
		Space space = this.spaceRepository.findById(space_id)
				.orElseThrow(() -> new ResourceNotFoundException(" Sorry the space is not found for the id : " + space_id));
		return space;
	}
	
	
}
