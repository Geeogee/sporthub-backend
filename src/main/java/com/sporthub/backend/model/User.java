package com.sporthub.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String phone_number;
	private String city;
	private String address;
	
	private String zip_code;
	
	private String document_id;
	
	@OneToOne()
	@JoinColumn(name="voucher_id")
	private Voucher voucher;
	
	private Integer skill_rating;
	
	@ManyToOne()
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToMany(mappedBy="user_rental")
	private Set<Rental> rental = new HashSet<Rental>();

	@OneToMany(mappedBy="user_playground")
	@JsonIgnore
	private Set<Playground> playground = new HashSet<Playground>();
	
	@OneToMany(mappedBy="user_review")
	private Set<Review> review = new HashSet<Review>();
	
	public User() {}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getDocument_id() {
		return document_id;
	}

	public void setDocument_id(String document_id) {
		this.document_id = document_id;
	}

	public Voucher getVoucher_id() {
		return voucher;
	}

	public void setVoucher_id(Voucher voucher_id) {
		this.voucher = voucher_id;
	}

	public Integer getSkill_rating() {
		return skill_rating;
	}

	public void setSkill_rating(Integer skill_rating) {
		this.skill_rating = skill_rating;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public Set<Rental> getRental() {
		return rental;
	}

	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}

	public Set<Playground> getPlayground() {
		return playground;
	}

	public void setPlayground(Set<Playground> playground) {
		this.playground = playground;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	

}
