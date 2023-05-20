package com.dpauld.springdemo.service;

import java.util.List;

import com.dpauld.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);

	public void deleteCustomer(int theCustomerId);
}
