package edu.wccnet.hmangels.studentApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name") // match column name in database
	private String firstName;
	@Column(name = "last_name") // match column name in database
	private String lastName;
	@Column(name = "street") // match column name in database
	private String street;
	@Column(name = "city") // match column name in database
	private String city;
	@Column(name = "state") // match column name in database
	private String state;
	@Column(name = "zip") // match column name in database
	private String zip;
	
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.PERSIST) // I changed this to persist so I could use persist in createdemo.java
	private List<PizzaOrder> pizza_order = new ArrayList<PizzaOrder>(); // One Customer to many orders
	
	

	
	public void add(PizzaOrder newPizzaOrder) {
		pizza_order.add(newPizzaOrder);
		newPizzaOrder.setCustomer(this);
	}
	public void remove(PizzaOrder pizzaOrder) {
		pizza_order.remove(pizzaOrder);
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public List<PizzaOrder> getPizza_order() {
		return pizza_order;
	}
	public void setPizza_order(List<PizzaOrder> pizza_order) {
		this.pizza_order = pizza_order;
	}
	public Customer() {
		
	}
	public Customer(String firstName, String lastName, String street, String city, String state, String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
	
	
	
}
