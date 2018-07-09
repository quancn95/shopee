package com.ofw.group14.entity;

public class ShoppingCart {
	int product_id;
	String image;
	String productname;
	int price;
	String model;
	int available;
	int quanlity; 
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
	
}
