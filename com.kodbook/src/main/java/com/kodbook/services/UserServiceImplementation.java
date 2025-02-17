package com.kodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.User;
import com.kodbook.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository repo;

	@Override
	public boolean userExists(String username, String email) {
		User user1=repo.findByUsername(username);
		User user2=repo.findByEmail(email);
		if(user1!=null || user2!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void addUser(User user) {
		repo.save(user);
		
	}

	@Override
	public boolean validateUser(String username, String password) {
		//getting password and checking
		String dbpass=repo.findByUsername(username).getPassword();	
		if(password.equals(dbpass))
		{
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

}
