package com.dpauld.springdemo.dao;

import java.util.List;

import com.dpauld.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);

	public void deleteCustomer(int theCustomerId);
}


