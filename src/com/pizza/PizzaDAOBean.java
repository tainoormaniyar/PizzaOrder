package com.pizza;

public class PizzaDAOBean {
	int pizza_id;
	String crust;
	String toppingstype;
	int price;
	int quantity;
	public PizzaDAOBean(){
		
	}
	public PizzaDAOBean(int pizza_id, String crust, String toppingstype, int price, int quantity) {
		super();
		this.pizza_id = pizza_id;
		this.crust = crust;
		this.toppingstype = toppingstype;
		this.price = price;
		this.quantity = quantity;
	}
	public int getPizza_id() {
		return pizza_id;
	}
	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public String getToppingstype() {
		return toppingstype;
	}
	public void setToppingstype(String toppingstype) {
		this.toppingstype = toppingstype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "PizzaDAOBean [pizza_id=" + pizza_id + ", crust=" + crust + ", toppingstype=" + toppingstype + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
}
