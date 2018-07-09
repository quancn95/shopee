package com.ofw.group14.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/*@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)*/

@Indexed
@Entity(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int product_id;
	@Column(name="name")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO) 
	private String name;
	@Column(name="description")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO) 
	private String description;
	@Column(name="desciption_detail")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO) 
	private String desciption_detail;
	private String image;
	@OneToOne()
	@JoinColumn(name="category_id")
	Categories categories;
	private int quantity;
	@OneToOne()
	@JoinColumn(name="brand_id")
	Brands brands;
	private String model;
	private String configuration;
	private int price;
	private int featured;
	@Column(name="created_at") 
	private int created_at;
	@Column(name="products_sold")
	private int products_sold;
	/*@Column(name="update_at")
	private Date update_at;*/
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	
	public String getDesciption_detail() {
		return desciption_detail;
	}
	public void setDesciption_detail(String desciption_detail) {
		this.desciption_detail = desciption_detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories caterories) {
		this.categories = caterories;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Brands getBrands() {
		return brands;
	}
	public void setBrands(Brands brands) {
		this.brands = brands;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFeatured() {
		return featured;
	}
	public void setFeatured(int featured) {
		this.featured = featured;
	}
	public int getCreated_at() {
		return created_at;
	}
	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}
	public int getProducts_sold() {
		return products_sold;
	}
	public void setProducts_sold(int products_sold) {
		this.products_sold = products_sold;
	}
	/*public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}*/
	
	
}
