package org.cis.cis.repository;

import org.cis.cis.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long > {
	
}
