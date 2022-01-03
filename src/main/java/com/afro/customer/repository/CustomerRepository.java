package com.afro.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afro.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer getByCustomerId(Long customerId);

}
