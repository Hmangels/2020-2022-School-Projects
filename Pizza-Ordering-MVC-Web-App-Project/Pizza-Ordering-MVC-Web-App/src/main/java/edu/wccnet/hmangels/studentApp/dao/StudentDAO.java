package edu.wccnet.hmangels.studentApp.dao;

import java.util.List;

import edu.wccnet.hmangels.studentApp.entity.Customer;
import edu.wccnet.hmangels.studentApp.entity.Pizza;
import edu.wccnet.hmangels.studentApp.entity.PizzaOrder;
import edu.wccnet.hmangels.studentApp.entity.Student;

public interface StudentDAO {
	public List<Customer> getStudents();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteStudent(int id);

	public List<PizzaOrder> getOrders(int id);

	public void savePizza(Pizza thePizza);

	public List<Pizza> getPizzas(int id);

	void saveOrder(PizzaOrder order);

	public PizzaOrder getOrder(int id);

	public void deleteOrder(int id);

	
}
