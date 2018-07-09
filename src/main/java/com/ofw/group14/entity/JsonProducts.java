package com.ofw.group14.entity;

public class JsonProducts {
	private int product_id;
	private String name;
	private String description;
	private String desciption_detail;
	private String image;
	Categories categories;
	private int quantity;
	Brands brands;
	private String model;
	private String configuration;
	private int price;
	private int featured;
	private int created_at;
	private int products_sold;
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
	public void setCategories(Categories categories) {
		this.categories = categories;
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
}
