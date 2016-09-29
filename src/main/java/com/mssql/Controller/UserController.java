package com.mssql.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mssql.Objects.User;
import com.mssql.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	public static final String APPLICATION_JSON = "application/json";
	@Autowired(required =false)
	private UserService userservice;
	
	
	@RequestMapping (value ="/sample",method = RequestMethod.GET)
	public String sample(){
		
		logger.info("Sample is Calling ");
		return "HI";
	 	
	}
	@RequestMapping (value ="/sample1",method = RequestMethod.GET)
	public String sample1(){
		
		logger.info("Sample1 is Calling ");
		return userservice.sample();
	 	
	}
	@RequestMapping (value ="/add",method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>>  Create(@RequestBody String data){
		System.out.println("data "+data);

		System.out.println("Add Service is Calling ");
		  User user=null;
		      try {
				user = new ObjectMapper().readValue(data, User.class);
			} catch (IOException e) {
 				e.printStackTrace();
			}
		      System.out.println("user is Checking "+user);
		      System.out.println("Hai Creating User In SQL Sever");
		 User object = userservice.add(user);
		 System.out.println("userservice...................<><"+ userservice);

		 System.out.println("object<><"+ object);
		 Map<String,Object> response = new HashMap<String,Object>();
		 response.put("User Added.", user);
 
		 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
 	 	
 	}
	@RequestMapping (value ="/get",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>>  get(@RequestParam int id){
		System.out.println("id "+id);

		System.out.println("get Service is Calling ");
		   
		 User object = userservice.get(id);
	 

		 System.out.println("object<><"+ object);
		 Map<String,Object> response = new HashMap<String,Object>();
		 response.put("Succesfully Fetched", object);
 
		 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
 	 	
 	}
	
	

}
