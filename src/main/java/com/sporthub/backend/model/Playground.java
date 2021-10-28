package com.sporthub.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PLAYGROUND")
public class Playground {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer playground_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_playground;
	
	private String sport_type;
	
	private Integer tot_players;
	
	private Boolean indoor;
	
	private String address;
	
	private String city;
	
	private Boolean availability;
	
	private Double price_hour;
	
	@OneToMany(mappedBy="playground")
	private Set<Voucher> voucher = new HashSet<Voucher>();
	
	@OneToMany(mappedBy="playground")
	private Set<Rental> rental = new HashSet<Rental>();
	
	@OneToMany(mappedBy="playground")
	private Set<Review> review = new HashSet<Review>();
	
	public Playground() {}

	public Integer getPlayground_id() {
		return playground_id;
	}

	public void setPlayground_id(Integer playground_id) {
		this.playground_id = playground_id;
	}

	public User getUser() {
		return user_playground;
	}

	public void setUser(User user) {
		this.user_playground = user;
	}

	public String getSport_type() {
		return sport_type;
	}

	public void setSport_type(String sport_type) {
		this.sport_type = sport_type;
	}

	public Integer getTot_players() {
		return tot_players;
	}

	public void setTot_players(Integer tot_players) {
		this.tot_players = tot_players;
	}

	public Boolean getIndoor() {
		return indoor;
	}

	public void setIndoor(Boolean indoor) {
		this.indoor = indoor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Double getPrice_hour() {
		return price_hour;
	}

	public void setPrice_hour(Double price_hour) {
		this.price_hour = price_hour;
	}
}
