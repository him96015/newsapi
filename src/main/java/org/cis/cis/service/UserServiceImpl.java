package org.cis.cis.service;

import java.util.List;

import org.cis.cis.model.User1;
import org.cis.cis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public Object findByUsername(String username) {
		User1 user = null;
		List<User1> directory =(List<User1>) userRepository.findAll();
			for(User1 user1: directory)
			{
				if(user1.getUsername().equalsIgnoreCase(username)) 
				{
					user=user1;
				}
			}
			return user;
		} 
		
}	


