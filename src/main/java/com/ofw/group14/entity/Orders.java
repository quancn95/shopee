package com.ofw.group14.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	User user;*/
	private String customer_name;
	private String address; 
	private boolean status;
	private Date created_at;
	private int phone; 
	private String type_shipping;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="order_id")
	Set<OrderDetails> oderDetails;
	
	public Set<OrderDetails> getOderDetails() {
		return oderDetails;
	}
	public void setOderDetails(Set<OrderDetails> oderDetails) {
		this.oderDetails = oderDetails;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getType_shipping() {
		return type_shipping;
	}
	public void setType_shipping(String type_shipping) {
		this.type_shipping = type_shipping;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	 
}
