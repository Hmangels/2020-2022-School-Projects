package edu.wccnet.hmangels.studentApp.Service;

import java.util.List;
import java.util.Map;

import edu.wccnet.hmangels.studentApp.entity.Customer;
import edu.wccnet.hmangels.studentApp.entity.Pizza;
import edu.wccnet.hmangels.studentApp.entity.PizzaOrder;
import edu.wccnet.hmangels.studentApp.entity.Student;

public interface StudentService {
	public List<Customer> getStudents();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteStudent(int id);

	public List<PizzaOrder> getOrders(int id);

	public void savePizza(Pizza thePizza);

	public Map<String, String> populateToppings();

	public Object getPizzas(int id);
	
	public void saveOrder(PizzaOrder order);

	PizzaOrder getOrder(int id);

	void deleteOrder(int id);

}
