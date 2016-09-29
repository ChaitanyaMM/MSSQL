package com.mssql.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.mssql.Objects.User;

public interface UserService {

	public User add(User  user) ;

	public String sample();

	public User get(int id);

 
}
