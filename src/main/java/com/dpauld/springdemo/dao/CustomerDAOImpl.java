package com.dpauld.springdemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dpauld.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	//Removed @Transactional // Bad Practice to put this annotation here, instead of Service layer
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession(); 
		List<Customer> customers = currentSession.createQuery("from Customer", Customer.class).getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession(); 
		//currentSession.save(theCustomer);// previous version
		currentSession.saveOrUpdate(theCustomer); //updated version for the use of update
	}

	@Override
	public Customer getCustomer(int theCustomerId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession(); 
		return currentSession.get(Customer.class, theCustomerId);
	}

	@Override
	public void deleteCustomer(int theCustomerId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession(); 

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=: customerId");
		theQuery.setParameter("customerId", theCustomerId);
		theQuery.executeUpdate();
		
		/* Option 2
		 * Customer tempCustomer = currentSession.get(Customer.class, theCustomerId);
		 * currentSession.delete(tempCustomer);
		 */
	}
}

