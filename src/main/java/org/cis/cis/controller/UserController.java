package org.cis.cis.controller;

import javax.validation.Valid;

import org.cis.cis.exception.UsernameNotFoundException;
import org.cis.cis.model.User1;
import org.cis.cis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")


public class UserController {
	
	@Autowired
	UserService userService;
	
	 @PostMapping("/users")
	    public ResponseEntity<String> addUser(@Valid @RequestBody User1 user) {
	        // persisting the user
	        return ResponseEntity.ok("User is valid");
	    }
	 
	//UserName not found exception 
	 @GetMapping("/findByUsername")
	 public ResponseEntity<?>findByUsername(@RequestBody String username) throws UsernameNotFoundException{
	 		User1 user=(User1) userService.findByUsername(username);
	 		if(user==null) {
	 			throw new UsernameNotFoundException("Username:  "+ username+ " not found");
	 		}
	 		return new ResponseEntity<User1>((User1) userService.findByUsername(username),HttpStatus.OK);

	 }
	
//	UserRepository userRepository; 
//	@PostMapping("/createUser")
//	public ResponseEntity<?> createUser(@RequestBody User user){
//		user=userRepository.save(user);
//		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
//	}
}
