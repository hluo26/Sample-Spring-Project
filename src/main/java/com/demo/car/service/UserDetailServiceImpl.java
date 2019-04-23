package com.demo.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.car.cardatabase.User;
import com.demo.car.cardatabase.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	private UserRepository repository;
		
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load");
		 User currentUser = repository.findByUsername(username);
		 if(currentUser == null) {
			 System.out.println("mlgb");
			 throw new UsernameNotFoundException("User not authorized.");
		 }
		 System.out.println(currentUser.getUsername());
		 System.out.println(currentUser.getPassword());
	        UserDetails user = new org.springframework.security.core
	            .userdetails.User(currentUser.getUsername(), currentUser.getPassword(),
	            AuthorityUtils.createAuthorityList(currentUser.getRole()));
	        return user;
		 
	}
}
