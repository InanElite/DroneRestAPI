package com.restfulAPI.rest;

import com.restfulAPI.rest.Controller.MedicineController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);

		//MedicineController d = new MedicineController();
		//d.preload();
	}



}
