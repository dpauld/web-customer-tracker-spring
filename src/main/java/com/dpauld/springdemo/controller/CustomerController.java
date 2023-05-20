package com.dpauld.springdemo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui. Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpauld.springdemo.dao.CustomerDAO;
import com.dpauld.springdemo.entity.Customer;
import com.dpauld.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	@Autowired
//	CustomerDAO customerDAO; // bad practice, was part of initial setup
	
	@Autowired 
	CustomerService customerService;
	
	//@RequestMapping("/list") // was part of initial setup
	@GetMapping("/list") // Refactored, try PostMapping, you will get an error
	public String listCustomers (Model theModel) {
		
		//get the customers from dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		System.out.println(theCustomers);
		
		return "list-customers";
	}
	
	/* Controllers for Add */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		
		//create customer object to add as a model attribute to bind the form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer, Model theModel) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	/* Controllers for Update */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theCustomerId,Model theModel) {
		
		//get the customer from db
		Customer theCustomer = customerService.getCustomer(theCustomerId);
				
		//set this customer as a model attribute to re-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send the control over to the form
		return "customer-form";
	}
	
	/* Controllers for Delete */
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theCustomerId, Model theModel) {
		customerService.deleteCustomer(theCustomerId);
		return "redirect:/customer/list";
	}
}

