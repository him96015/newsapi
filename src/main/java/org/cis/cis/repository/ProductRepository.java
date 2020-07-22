package org.cis.cis.repository;

import org.cis.cis.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "product", path = "product")

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
