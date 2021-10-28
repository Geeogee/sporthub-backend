package com.sporthub.backend.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VOUCHER")
public class Voucher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer voucher_id;
	
	private Integer rentals_left;
	
	private LocalDate startDate;
	
	private LocalDate end_date;
	
	@OneToOne(mappedBy="voucher")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="playground_id")
	private Playground playground;
	
	@OneToMany(mappedBy="voucher")
	private Set<Rental> rental = new HashSet<Rental>();
	
	public Voucher() {}

	public Integer getVoucher_id() {
		return voucher_id;
	}

	public void setVoucher_id(Integer voucher_id) {
		this.voucher_id = voucher_id;
	}

	public Integer getRentals_left() {
		return rentals_left;
	}

	public void setRentals_left(Integer rentals_left) {
		this.rentals_left = rentals_left;
	}

	public LocalDate getStart_date() {
		return startDate;
	}

	public void setStartDate(LocalDate start_date) {
		this.startDate = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Playground getPlayground() {
		return playground;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	public Set<Rental> getRental() {
		return rental;
	}

	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}
}
