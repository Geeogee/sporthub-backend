package com.sporthub.backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="RENTAL")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rental_id;
	
	@ManyToOne()
	@JoinColumn(name="playground_id")
	private Playground playground;
	
	@ManyToOne()
	@JoinColumn(name="voucher_id")
	private Voucher voucher;
	
	private Date date;
	
	private Integer tot_hour;
	
	private Integer places_reserved;
	
	private Character confirmed;
	
	@ManyToMany
	@JoinTable(
		name="user_rental",
		joinColumns = {@JoinColumn(name="user_id")},
		inverseJoinColumns = {@JoinColumn(name="rental_id")}
	)
	@JsonIgnoreProperties("rental")
	private Set<User> user_rental = new HashSet<User>();
	
	public Set<User> getUser_rental() {
		return user_rental;
	}

	public void setUser_rental(Set<User> user_rental) {
		this.user_rental = user_rental;
	}

	public Rental() {}

	public Integer getRental_id() {
		return rental_id;
	}

	public void setRental_id(Integer rental_id) {
		this.rental_id = rental_id;
	}

	public Playground getPlayground() {
		return playground;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTot_hour() {
		return tot_hour;
	}

	public void setTot_hour(Integer tot_hour) {
		this.tot_hour = tot_hour;
	}

	public Integer getPlaces_reserved() {
		return places_reserved;
	}

	public void setPlaces_reserved(Integer places_reserved) {
		this.places_reserved = places_reserved;
	}

	public Character getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Character confirmed) {
		this.confirmed = confirmed;
	}
	
}
