package org.cis.cis.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)  //owner is Customer : first Customer than cart
	@JoinColumn(name = "cart_id",referencedColumnName = "id" ) // n existence of cart without customer 
	private Cart cart=new Cart();
}
