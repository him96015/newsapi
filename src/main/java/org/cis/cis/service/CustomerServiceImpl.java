package org.cis.cis.service;

import java.util.ArrayList;
import java.util.List;

import org.cis.cis.model.Customer;
import org.cis.cis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> findByName(String name) {
	
		List<Customer> result=new ArrayList<Customer>();
		List<Customer> customerList =(List<Customer>) customerRepository.findAll();
		for(Customer customer :customerList) {
			if(customer.getName().equalsIgnoreCase(name)) {
				result.add(customer);
			}
		}
		return result;
		
	}

	
}
