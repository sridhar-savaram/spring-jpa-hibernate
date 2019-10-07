package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Person;
import com.example.demo.jdbc.PersonJdbcDao;
import com.example.demo.jpa.PersonJpaRepository;
import com.example.demo.repository.CourseRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Course 1 -> {}" + courseRepo.findById(10001L));
//		logger.info("Inserting -> {}", 
//				personJpaRepo.insert(new Person("Tara", "Berlin", new Date())));
//		
//		logger.info("Update 10003 -> {}", 
//				personJpaRepo.update(new Person(10003, "Pieter", "Utrecht", new Date())));
//		
//		personJpaRepo.deleteById(10002);
//		
//		logger.info("All users -> {}", personJpaRepo.findAll());
	}

	
}
