package com.ofw.group14.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="brands")
public class Brands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brand_id")
	private int brand_id;
	private String  name;
	private String description;
	
	@OneToMany()
	@JoinColumn(name="brand_id")
	Set<Products> products;
	
	public Set<Products> getProducts() {
		return products;
	}
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
