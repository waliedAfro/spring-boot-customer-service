package com.afro.customer.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.afro.customer.DTO.ResponseTemplateDTO;
import com.afro.customer.DTO.Vehicle;
import com.afro.customer.model.Customer;
import com.afro.customer.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/customers")

public class CustomerController {

	@Autowired
	private RestTemplate restTemplate ; 
	private CustomerService customerService ;
	private static final Logger logger= LoggerFactory.getLogger(CustomerController.class);
	
	
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	} 

	// save Customer service 
	@PostMapping("/")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		logger.info("Entering into method saveCustomer()");
		return customerService.saveCustomer(customer);
	}
	
	// get Customer service 
	@GetMapping("/{id}")
	@CircuitBreaker(name = "CUSTOM_SERVICE_FALLBACK" ,fallbackMethod = "customerServiceFallBackCircutBreaker")
	public ResponseTemplateDTO getCutomer(@PathVariable Long id) throws Exception
	{
		logger.info("Entering into method getCutomer()");
		Customer customer = customerService.getCutomer(id);
		System.out.println("customer :"+customer);
		
		
		ResponseEntity<Vehicle[]> response = restTemplate
				.getForEntity("http://VEHICLE-SERVICE/vehicles/customer/" + customer.getCustomerId(), Vehicle[].class);

		Vehicle[] vehicleArray = response.getBody();
		
		ResponseTemplateDTO resposnseTemplateDTO = new  ResponseTemplateDTO();
		resposnseTemplateDTO.setMessage("Success");
		resposnseTemplateDTO.setCustomer(customer);
		resposnseTemplateDTO.setVehicleList(vehicleArray);
				
		return resposnseTemplateDTO ;
		//return "hello";
	}
	
	public ResponseTemplateDTO customerServiceFallBackCircutBreaker(Long param1, Exception e) {
		ResponseTemplateDTO obj = new ResponseTemplateDTO();
		obj.setMessage("Service un available - please try again later");
		  return obj;
		}
	
	
}
