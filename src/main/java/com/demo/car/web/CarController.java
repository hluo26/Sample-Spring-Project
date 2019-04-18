package com.demo.car.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.car.cardatabase.Car;
import com.demo.car.cardatabase.CarRepository;
import com.demo.car.cardatabase.Owner;
import com.demo.car.cardatabase.OwnerRepository;

@RestController
public class CarController {
	@Autowired
	CarRepository repository;
	
	@Autowired
	OwnerRepository orepository;

	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
	
	@RequestMapping("/owners")
	public Iterable<Owner> getOwners(){
		return orepository.findAll();
	}
}
