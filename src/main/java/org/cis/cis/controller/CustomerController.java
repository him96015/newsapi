package org.cis.cis.controller;


import java.util.ArrayList;
import java.util.List;

import org.cis.cis.model.Customer;
import org.cis.cis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/cis")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
//	@GetMapping("/get")
//	public Customer get() {
//		
//		List<Customer> customerList= new ArrayList<>;
//				customerRepo.findAll();
//		return new Customer();
//		
//	}
	@GetMapping("/get")
	public List<Customer> getAll() {
	    System.out.println("Get all Customers...");
	 
	    List<Customer> customers = new ArrayList<>();
	    customerRepo.findAll().forEach(customers::add);
	 
	    return customers;
	  }
	
	@PostMapping("/create")
	public ResponseEntity<Customer> creatingCustomer (@RequestBody Customer customerDetails){
		
		log.info("creating Customer:{}",customerDetails);
		customerDetails =customerRepo.save(customerDetails);
		log.info("Customer Created:{}",customerDetails);
		
		return new ResponseEntity<Customer>(customerDetails,HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatingCustomer(@PathVariable("id") Long id, @RequestBody Customer customerToBeUpdated){
		if(customerRepo.findById(id).isPresent())
		{			
			customerToBeUpdated.setId(id);
			customerRepo.save(customerToBeUpdated);
			return new ResponseEntity<Customer>(customerRepo.findById(id).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Customer with id "+ id +" does not exist",HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/age/{id}")
	public ResponseEntity<?> updateAge(@PathVariable("id") Long id,@RequestBody int age){
		if(customerRepo.findById(id).isPresent()) {
			
			Customer customer=customerRepo.findById(id).get();
			customer.setAge(age);
			customerRepo.save(customer);
			
			return new ResponseEntity<Customer>(customerRepo.findById(id).get(),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Customer with id "+id +"does not exixt",HttpStatus.NOT_FOUND);
		}
	}
		@PatchMapping("/name/{id}")
		public ResponseEntity<?> updateName(@PathVariable("id") Long id,@RequestBody String name)
		{
			if(customerRepo.findById(id).isPresent()) {
				
				Customer customer=customerRepo.findById(id).get();
				customer.setName(name);;
				customerRepo.save(customer);
				
				return new ResponseEntity<Customer>(customerRepo.findById(id).get(),HttpStatus.OK);
				
			}
			else
			{
				return new ResponseEntity<String>("Customer with id "+id +"does not exixt",HttpStatus.NOT_FOUND);
			}
		
		
		}	
//	@GetMapping("/age/{id}/{age}")
//	public ResponseEntity<?> updateAge (@PathVariable ("id") Long id,@PathVariable ("age") int age) {
//		
//		if(customerRepo.findById(id).isPresent()) 
//		{
//		
//			Customer customer =customerRepo.findById(id).get();
//			customer.setAge(age);
//			customerRepo.save(customer);
//			return new ResponseEntity<Customer>(customerRepo.findById(id).get(),HttpStatus.OK);
//		}
//		else
//		{
//			return new ResponseEntity<String>("This id "+id+" does not exist",HttpStatus.NOT_FOUND);
//		}
	
	
	@PostMapping("/createlist")
	public ResponseEntity<List<Customer>> creatingCustomerList (@RequestBody List<Customer> customerDetails){
		
		log.info("creating Customer List:{}",customerDetails);
		
		customerRepo.saveAll(customerDetails);
		log.info("Customer Created List:{}",customerDetails);
		
		return new ResponseEntity<List<Customer>>(customerDetails,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAllCustomers(){
		customerRepo.deleteAll();
		
		return new ResponseEntity<String>("All Customer details have been deleted",HttpStatus.OK);
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletingCustomer(@PathVariable("id") Long id){
		if(customerRepo.findById(id).isPresent())
		{customerRepo.deleteById(id);
		
		return new ResponseEntity<String>("Customer with id "+id+" has been deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No such Customer with id "+ id+" exists",HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping("/read/{id}")
	public ResponseEntity<?> readingStudent(@PathVariable("id") Long id){
		if(customerRepo.findById(id).isPresent()) {
			
			return new ResponseEntity<Customer>(customerRepo.findById(id).get(),HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<String>("This id does not exist "+ id,HttpStatus.NOT_FOUND);
		}
	}
	
}
