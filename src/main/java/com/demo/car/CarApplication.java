package com.demo.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.car.cardatabase.Car;
import com.demo.car.cardatabase.CarRepository;
import com.demo.car.cardatabase.Owner;
import com.demo.car.cardatabase.OwnerRepository;
import com.demo.car.cardatabase.User;
import com.demo.car.cardatabase.UserRepository;

@SpringBootApplication
public class CarApplication {
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired 
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
		System.out.println("encoded username is " +new BCryptPasswordEncoder().encode("user"));
		System.out.println("encoded password is " +new BCryptPasswordEncoder().encode("123456"));
	}
	
	@Bean
	CommandLineRunner runner(){
        return args -> {
          // Place your code here
        	Owner o1 = new Owner("hao","luo");
        	Owner o2 = new Owner("wei","luo");
        	orepository.save(o1);
        	orepository.save(o2);
        	
        	Car c1 = new Car("Ford", "Mustang", "Red","ADF-1121", 2017, 59000,o1);
        	repository.save(c1);
        	c1 = new Car("Nissan", "Leaf", "White","SSJ-3002", 2014, 29000,o1);
        	repository.save(c1); 
        	c1 = new Car("Toyota", "Prius", "Silver","KKO-0212", 2018, 39000,o2);
        	repository.save(c1);
        	
        	// username: user password: user
            urepository.save(new User("user",
            "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
            "USER"));
            // username: admin password: admin
            urepository.save(new User("admin",
            "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", 
            "ADMIN"));
        };
      } 

}
