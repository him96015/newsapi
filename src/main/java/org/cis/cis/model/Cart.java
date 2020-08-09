package org.cis.cis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "cart") // here owner is Customer, so cart is mapped.
	private Customer customer;
	
	@ManyToMany		// owner is cart. First cart is created and then products will be added 
	@JoinTable(		// join table will come in owner part.
			name="cart_product",
			joinColumns = @JoinColumn(name="cart_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="product_id",referencedColumnName = "id")
			)
	private List<Product> products;
	
}
