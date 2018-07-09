package com.ofw.group14.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idrole")
	private int idrole;
	@Column(name="role_name")
	private String rolename;
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
