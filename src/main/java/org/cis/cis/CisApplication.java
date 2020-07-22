package org.cis.cis;

import org.cis.cis.model.Cart;
import org.cis.cis.model.Customer;
import org.cis.cis.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CisApplication.class, args);
	}

	@Component
	public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {
	  @Override
	  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	    config.exposeIdsFor(Customer.class);
	    config.exposeIdsFor(Product.class);
	    config.exposeIdsFor(Cart.class);
	  }
	}
}
