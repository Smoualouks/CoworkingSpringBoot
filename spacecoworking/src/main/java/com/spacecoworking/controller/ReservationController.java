package com.spacecoworking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacecoworking.model.Reservation;
import com.spacecoworking.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping
	public Reservation createReservation(@RequestBody @Valid Reservation reservationToCreate) {
		return this.reservationService.create(reservationToCreate);
	}
	
	@GetMapping("/{id}")
	public Iterable<Reservation> findAllReservationByUserId(@PathVariable("id") Integer user_id) {
	
	 return this.reservationService.findAllReservationByUserId(user_id); 
	 
	}
	@DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer reservation_id) {
        this.reservationService.delete(reservation_id);
    }

}
