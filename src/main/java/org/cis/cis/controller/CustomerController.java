package org.cis.cis.controller;



import java.util.List;

import org.cis.cis.model.Customer;
import org.cis.cis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/customer")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
@Api(value="book api", description="Operations pertaining to fetch Fuel Data")


public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "fetch fuel,nox,co2 consumption per engine based on imo startReportDate and EndReportDate ordered By VesselEngine", response = String.class)

	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden or Your token is expired"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	
	
	@GetMapping("/findByName")
	public ResponseEntity <?> findByName (@RequestBody String name){
		try {
			return new ResponseEntity <List<Customer>>(customerService.findByName(name),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception Occured "+ e,HttpStatus.OK ); 
		}
		
	}
	
	
}
