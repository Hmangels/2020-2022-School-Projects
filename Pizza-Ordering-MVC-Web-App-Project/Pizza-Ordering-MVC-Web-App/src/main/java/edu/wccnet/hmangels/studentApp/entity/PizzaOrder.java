package edu.wccnet.hmangels.studentApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; 
	
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="pizza_order",cascade = CascadeType.ALL)
	private List<Pizza> pizzas = new ArrayList<Pizza>(); // One PizzaOrder to many Pizzas
	
	public void add(Pizza newPizza) {
		pizzas.add(newPizza);
		newPizza.setPizzaOrder(this);
	}
	public void remove(Pizza pizza) {
		pizzas.remove(pizza);
	}
	
	
	@Override
	public String toString() {
		return "PizzaOrder [id=" + id + ", pizzas=" + pizzas + "]";
	}
	public PizzaOrder() {
		
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public PizzaOrder(Customer customer ) {
		this.customer = customer;
	}

	
	


	


	
	
	
	
	
	
	
}
