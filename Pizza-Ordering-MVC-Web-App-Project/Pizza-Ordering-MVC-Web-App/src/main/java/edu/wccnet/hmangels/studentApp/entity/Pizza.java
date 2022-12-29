package edu.wccnet.hmangels.studentApp.entity;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "pizza")
public class Pizza {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")	
private int id;
@Column(name = "size") // match column name in database
private String size;
@Column(name = "topping") // match column name in database
private String topping;

// private ArrayList<String> topping = new ArrayList<String>(); // I changed topping into an array

@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) // many pizzas to one pizzaorder
@JoinColumn(name = "order_id")
private PizzaOrder pizza_order;




public Pizza() {
	
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}
/*
 * public void add(String newTopping) { topping.add(newTopping);
 * 
 * } public void remove(String newTopping) { topping.remove(newTopping); }
 * 
 * 
 * public ArrayList<String> getTopping() { return topping; } public void
 * setTopping(ArrayList<String> topping) { this.topping = topping; }
 */
public PizzaOrder getPizza_order() {
	return pizza_order;
}
public void setPizza_order(PizzaOrder pizza_order) {
	this.pizza_order = pizza_order;
}
public PizzaOrder getPizzaOrder() {
	return pizza_order;
}

public void setPizzaOrder(PizzaOrder pizzaOrder) {
	this.pizza_order = pizzaOrder;
}
@Override
public String toString() {
	return "Pizza [id=" + id + ", size=" + size + ", topping=" + topping  + "]";
}
public String getTopping() {
	return topping;
}
public void setTopping(String topping) {
	this.topping = topping;
}
public Pizza(String size, String topping) {
	super();
	this.size = size;
	this.topping = topping;
}

}
