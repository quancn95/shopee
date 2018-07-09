package com.ofw.group14.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="user_role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iduser_role")
	private int idUserRole;
	
	@ManyToOne
	@JoinColumn(name="iduser")
	private User id_user;
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role id_role;
	public int getIdUserRole() {
		return idUserRole;
	}
	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}
	public User getId_user() {
		return id_user;
	}
	public void setId_user(User id_user) {
		this.id_user = id_user;
	}
	public Role getId_role() {
		return id_role;
	}
	public void setId_role(Role id_role) {
		this.id_role = id_role;
	}
	
	
}
