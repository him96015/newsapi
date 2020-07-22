package org.cis.cis.repository;

import org.cis.cis.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "cart",path = "cart")

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

}
