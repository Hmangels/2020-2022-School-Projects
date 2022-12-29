package edu.wccnet.hmangels.studentApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.hmangels.studentApp.Service.StudentService;
import edu.wccnet.hmangels.studentApp.entity.Customer;
import edu.wccnet.hmangels.studentApp.entity.Pizza;
import edu.wccnet.hmangels.studentApp.entity.PizzaOrder;


@Controller
@RequestMapping("/student") // change to customer
public class MainController {
	private PizzaOrder order;
	@Autowired
	private StudentService studentService; // customerService
	//private StudentDAO studentDAO;
	@GetMapping("/list")
	public String listStudents(Model model) {// For Sort: Pass parameter from column link
		model.addAttribute("customers", studentService.getStudents());
		
		return "list-students";
	}
	@PostMapping("/addStudent") 
	public String addStudent(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-student";		
	}
	@PostMapping("/processStudent")
	public String processStudent(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println(theCustomer);
		studentService.saveCustomer(theCustomer);
		
		return "redirect:/student/list";
	}
	@RequestMapping("/updateCustomer")
	public String updateStudent(Model model, @RequestParam("customerId") int id) {
		Customer customer = studentService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-student";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent( @RequestParam("studentId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/student/list";	
	}
	@RequestMapping("/orderHistory")
	public String listOrderHistory(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("orders", studentService.getOrders(id));
		Customer customer = studentService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() +" "+customer.getLastName());
		model.addAttribute("customerId",customer.getId());
		
		
		return "list-orders";	
	}
	@PostMapping("/addToOrder") 
	public String addOrder(Model model) { // not sure if pizza or pizzaorder
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		return "add-to-order";		
	}
	@PostMapping("/processOrder")
	public String processOrder(@ModelAttribute("pizza") Pizza thePizza) {
		System.out.println(thePizza);
		studentService.savePizza(thePizza);
		
		return "redirect:/student/cart";
	}
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("toppingsList", studentService.populateToppings());
		
	}
	@GetMapping("/cart")// DELETE THIS
	public String listPizza(Model model, @RequestParam("pizzaId") int id) {// For Sort: Pass parameter from column link
		model.addAttribute("pizzas", studentService.getPizzas(id));
		
		return "list-pizzas";
	}
	@RequestMapping("/orderPizza")
	public ModelAndView orderPizza(Model model, @RequestParam("customerId") int id ) {
		Customer customer = studentService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " "+ customer.getLastName());
		if(order == null) {
			order = new PizzaOrder(customer);
		}
		
		return new ModelAndView("add-to-order", "newPizza", new Pizza());
	}
	@RequestMapping("/addPizza")
	public String addPizza(Model model, @ModelAttribute("newPizza") Pizza pizza) {
		System.out.println(pizza.getSize());
		order.add(pizza);
		System.out.println(order.getCustomer());
		for(Pizza eachPizza : order.getPizzas()) {
			System.out.println(eachPizza);
		}
		model.addAttribute("order", order);
		return "list-pizzas";
	}
	@PostMapping("/deletePizza")
	public String deletePizza(@RequestParam("pizzaId") int id, Model model) {
		order.getPizzas().remove(id-1);
		model.addAttribute("order", order);
		return "list-pizzas";
	
	}
	@RequestMapping("/placeOrder")
	public String placeOrder(@RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		studentService.saveOrder(order);
		order = null;
		redirectAttributes.addAttribute("customerId",id);
		return "redirect:/student/orderHistory";
	}
	@PostMapping("/deleteOrder") 
	public String deleteOrder(@RequestParam("orderId") int id, RedirectAttributes redirectAttributes) {
		int customerId = studentService.getOrder(id).getCustomer().getId();
		studentService.deleteOrder(id);
		redirectAttributes.addAttribute("customerId",customerId);
		return "redirect:/student/orderHistory";
	}
	
	
	
}
