package com.afro.customer.DTO;

import com.afro.customer.model.Customer;

public class ResponseTemplateDTO {
	String message ; 
	private Customer customer ; 
	private Vehicle[] vehicleList ;
	
	
	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Vehicle[] getVehicleList() {
		return vehicleList;
	}


	public void setVehicleList(Vehicle[] vehicleList) {
		this.vehicleList = vehicleList;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	
	
	
	

}
