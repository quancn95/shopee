package com.ofw.group14.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

@Entity(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iduser")
	private int idUser;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String passWord;
	@Column(name="email")
	private String email;
	@Column(name="phone",nullable=true) 
	private Integer phoneNumber;
	@Column(name="avatar")
	private String avatar;
	@Column(name="gender")
	private boolean gender;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="address")
	private String address;
	@Column(name="active")
	private int active;
	@Column(name="access")
	private int access;
	@Column(name="joindate")
	private Timestamp joindDate;
	private boolean enabled;
	
	public User() {
		super();
		this.enabled = false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	 
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public Timestamp getJoindDate() {
		return joindDate;
	}
	public void setJoindDate(Timestamp joindDate) {
		this.joindDate = joindDate;
	}
	
	
}
