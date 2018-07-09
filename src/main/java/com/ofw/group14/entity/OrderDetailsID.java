package com.ofw.group14.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailsID implements Serializable{
	private int order_id;
	private int product_id;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}
