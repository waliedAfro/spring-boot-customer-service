package com.afro.customer.service;
import java.util.List;

import com.afro.customer.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCutomer(); 
	public Customer getCutomer(Long pk);
	public Customer saveCustomer(Customer model);
	public Customer updateCustomer(Customer model);

}
