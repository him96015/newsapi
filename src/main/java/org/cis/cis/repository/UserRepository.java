package org.cis.cis.repository;


import org.cis.cis.model.User1;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*",allowedHeaders = "*")

@RepositoryRestResource(collectionResourceRel = "user", path = "user")

public interface UserRepository extends PagingAndSortingRepository<User1, Long> {

}
