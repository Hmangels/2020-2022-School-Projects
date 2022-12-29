package edu.wccnet.hmangels.studentApp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.hmangels.studentApp.entity.Customer;
import edu.wccnet.hmangels.studentApp.entity.Pizza;
import edu.wccnet.hmangels.studentApp.entity.PizzaOrder;

@Repository
public class StudentDAOimpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getStudents() { // For Sort: pass parameter into the query in order to sort by that parameter instead of the hardcoded lastName;
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer order by lastName",
				Customer.class);
		return query.getResultList();
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.save(theStudent);	
		session.saveOrUpdate(theCustomer);
	}
	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Student where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	@Override
	public List<PizzaOrder> getOrders(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//Query<Customer> query = session.createQuery("from Customer C where id = :id ", Customer.class);
		Query query = session.createQuery("from PizzaOrder o JOIN FETCH o.pizzas where o.customer.id= :id");
		query.setParameter("id", id);
		//Customer customer = (Customer) query.getSingleResult();
		//return customer.getPizza_order();
		return query.getResultList();
	}
	@Override
	public void saveOrder(PizzaOrder order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}
	@Override
	public void savePizza(Pizza thePizza) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.save(theStudent);	
		session.saveOrUpdate(thePizza);
	}
	@Override
	public List<Pizza> getPizzas(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Pizza p where p.pizza_order.id= :id");
		query.setParameter("id", id);
		// TODO Auto-generated method stub
		return  query.getResultList();
	}
	@Override
	public PizzaOrder getOrder(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(PizzaOrder.class, id);
	}
	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		PizzaOrder order = session.get(PizzaOrder.class, id);
		session.remove(order);
	}

}
