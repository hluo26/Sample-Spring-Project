package com.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.car.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService; 
//	@Override
//	  protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll();
//	  }
	
//	 @Bean
//	  @Override
//	  public UserDetailsService userDetailsService() {
//	      UserDetails user =
//	           User.withDefaultPasswordEncoder()
//	              .username("user")
//	              .password("password")
//	              .roles("USER")
//	              .build();
//
//	      return new InMemoryUserDetailsManager(user);
//	  } 
	
	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
	

}
