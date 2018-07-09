package com.ofw.group14.entity;

 

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="verification")
public class Verification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idverification;
	     
	private String token;
	   
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "iduser")
	private User user;
	     
	private Timestamp expiryDate;

	public Verification() {
		super();
	}

	public int getIdverification() {
		return idverification;
	}

	public void setIdverification(int idverification) {
		this.idverification = idverification;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
