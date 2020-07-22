package org.cis.cis.service;

import java.util.List;

import org.cis.cis.model.Customer;

public interface CustomerService {

	List<Customer> findByName(String name);
}
