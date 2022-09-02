package com.spacecoworking.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "space")
public class Space {
	
	@Id
	@Column(name="space_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int space_id;

	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "city")
	private String city;
	@Column(name = "web")
	private String web;
	@Column(name = "location")
	private String location;
	@Column(name = "epci")
	private String epci;
	@Column(name = "department")
	private String department;
	@Column(name = "region")
	private String region;
	public Space() {
		super();
	}
	public Space(int space_id, String name, String address, String zipcode, String city, String web, String location,
			String epci, String department, String region) {
		super();
		this.space_id = space_id;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.web = web;
		this.location = location;
		this.epci = epci;
		this.department = department;
		this.region = region;
	}
	public int getSpace_id() {
		return space_id;
	}
	public void setSpace_id(int space_id) {
		this.space_id = space_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEpci() {
		return epci;
	}
	public void setEpci(String epci) {
		this.epci = epci;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

    
}