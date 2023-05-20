package com.dpauld.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpauld.springdemo.dao.CustomerDAO;
import com.dpauld.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Transactional // good practice to move transaction annotation in service layer instead of using in DAO layer
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(theCustomer);
	}

	@Transactional
	@Override
	public Customer getCustomer(int theCustomerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theCustomerId);
	}

	@Transactional
	@Override
	public void deleteCustomer(int theCustomerId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(theCustomerId);
	}

}
