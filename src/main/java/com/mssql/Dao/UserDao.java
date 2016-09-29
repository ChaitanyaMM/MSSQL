package com.mssql.Dao;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.mssql.Objects.User;

public interface UserDao {

	 public String sample();
	public User add(User user);
	public User get(int id);

}
