package com.afro.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afro.customer.model.Customer;
import com.afro.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository ; 
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	
	@Override
	public List<Customer> getAllCutomer() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCutomer(Long pk) {
		
		return customerRepository.getByCustomerId(pk);
	}

	@Override
	public Customer saveCustomer(Customer model) {
		
		return customerRepository.save(model);
	}

	@Override
	public Customer updateCustomer(Customer model) {
		
		return customerRepository.save(model);
	}

}
