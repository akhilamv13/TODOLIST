package com.example.ToDo.service;

import java.util.Optional;

import com.example.ToDo.entity.User;

public interface UserService {

	public String postUser(User newuser) ;
	public Optional<User> getUser(String UserName, String Password);
}
