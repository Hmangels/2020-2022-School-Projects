package edu.wccnet.hmangels.studentApp.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.hmangels.studentApp.dao.StudentDAO;
import edu.wccnet.hmangels.studentApp.entity.Customer;
import edu.wccnet.hmangels.studentApp.entity.Pizza;
import edu.wccnet.hmangels.studentApp.entity.PizzaOrder;
import edu.wccnet.hmangels.studentApp.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	@Override
	@Transactional
	public List<Customer> getStudents() {
		// TODO Auto-generated method stub
		
		return studentDAO.getStudents();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		studentDAO.saveCustomer(theCustomer);
		
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getCustomer(id);
		
	}
	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
		
	}
	@Override
	@Transactional
	public List<PizzaOrder> getOrders(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getOrders(id);
	}
	@Override
	@Transactional
	public void savePizza(Pizza thePizza) {
		// TODO Auto-generated method stub
		studentDAO.savePizza(thePizza);
	}
	@Override
	public Map<String, String> populateToppings(){
			Map<String,String> toppingsList = new LinkedHashMap<String,String>();
			toppingsList.put(" Pepperoni", "Pepperoni");
			toppingsList.put(" Mushroom", "mushroom");
			toppingsList.put(" Sausag", "Sausage");
			toppingsList.put(" Bacon", "Bacon");
			toppingsList.put(" Onion", "Onion");
			return toppingsList;
		}
	@Override
	@Transactional
	public List<Pizza> getPizzas(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getPizzas(id);
	}
	@Override
	@Transactional
	public void saveOrder(PizzaOrder order) {
		// TODO Auto-generated method stub
		studentDAO.saveOrder(order);
		
	}
	@Override
	@Transactional
	public PizzaOrder getOrder(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getOrder(id);
		
	}
	@Override
	@Transactional
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteOrder(id);
		
	}
	

}
          