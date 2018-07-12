
package com.ssm.pojo;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	/**
	 * 购物项
	 */
	Map<String,CartItem> items=new HashMap<String, CartItem>();
	
	/**
	 * 合计
	 */
	private double total;

	public Map<String, CartItem> getItems() {
	
		return items;
	}

	public void setItems(Map<String, CartItem> items) {
	
		this.items = items;
	}

	public double getTotal() {
	
		return total;
	}

	public void setTotal(double total) {
	
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", total=" + total + "]";
	}

	public Cart(Map<String, CartItem> items, double total) {
		super();
		this.items = items;
		this.total = total;
	}

	public Cart() {
		
		super();
		//TODO 
			
	}


	
	
	

}

	