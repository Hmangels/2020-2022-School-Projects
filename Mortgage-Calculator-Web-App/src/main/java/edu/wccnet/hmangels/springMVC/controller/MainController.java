package edu.wccnet.hmangels.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wccnet.hmangels.springMVC.domain.Mortgage;
import edu.wccnet.hmangels.springMVC.domain.mortgageService;


@Controller
public class MainController {
	
	@Autowired
	private mortgageService Service;
	@RequestMapping("/")
	public String showForm(Model model) {
		Mortgage mortgage = new Mortgage();
		model.addAttribute("mortgage", mortgage);
		
		return "info-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("mortgage") Mortgage mortgage, Model model) {
		model.addAttribute("amorList", Service.AmorTable(mortgage.getPrincipal(),mortgage.getInterest(),mortgage.getLoanTerm(),mortgage.getDownPayment()));
		
		
		return "confirmation";
	}
	/*
	 * @ModelAttribute public void populateFormWithData(Model model,Mortgage
	 * mortgage) {
	 * 
	 * }
	 */
		
	
}
