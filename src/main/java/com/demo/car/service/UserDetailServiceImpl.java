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
		 User currentUser = repository.findByUsername(username);
		 if(currentUser == null) {
			 throw new UsernameNotFoundException("User not authorized.");
		 }else {
	        UserDetails user = new org.springframework.security.core
	            .userdetails.User(username, currentUser.getPassword()
	            , true, true, true, true, 
	            AuthorityUtils.createAuthorityList(currentUser.getRole()));
	        return user;
		 }
	}
}
