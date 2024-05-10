package com.example.ToDo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDo.entity.User;
import com.example.ToDo.service.UserService;


@RestController
public class userController {

	@Autowired
	UserService userService;
	
	@PostMapping("/postUser")
	public String  postUser(@RequestBody User user) {
		return userService.postUser(user);
	}
	
	@GetMapping("/getUser")
	public Optional<User>  getUser(@RequestParam String userName,@RequestParam String password) {
		return userService.getUser(userName, password);
	}

}
