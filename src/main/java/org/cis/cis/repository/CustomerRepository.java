package org.cis.cis.repository;

import java.util.List;

import org.cis.cis.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "customer",path = "customer")

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long > {

	List<Customer> findByName(String name);
	
}
