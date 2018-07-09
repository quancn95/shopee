package com.ofw.group14.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="orderdetails") 
public class OrderDetails {
	@EmbeddedId OrderDetailsID oderDetailsID; 
	private int quantity;
	private int payments;
	public OrderDetailsID getOderDetailsID() {
		return oderDetailsID;
	}
	public void setOderDetailsID(OrderDetailsID oderDetailsID) {
		this.oderDetailsID = oderDetailsID;
	} 
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPayments() {
		return payments;
	}
	public void setPayments(int payments) {
		this.payments = payments;
	}
}
