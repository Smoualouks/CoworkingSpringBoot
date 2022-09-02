package com.spacecoworking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id;
	@Column(name = "reservation_duration"  )
	private int reservationDuration;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "amount")
	private float amount;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "space_id",nullable=false)
    private Space space;

	public Reservation() {
		super();
	}

	public Reservation(int reservation_id, int reservationDuration, Date startDate, Date endDate, float amount,
			User user, Space space) {
		super();
		this.reservation_id = reservation_id;
		this.reservationDuration = reservationDuration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.user = user;
		this.space = space;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getReservationDuration() {
		return reservationDuration;
	}

	public void setReservationDuration(int reservationDuration) {
		this.reservationDuration = reservationDuration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	

	
   
    

}