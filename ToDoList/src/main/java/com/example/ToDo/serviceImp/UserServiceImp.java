package com.example.ToDo.serviceImp;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDo.entity.User;
import com.example.ToDo.repo.userRepo;
import com.example.ToDo.service.UserService;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	userRepo UserRepo;
	
	User user=new User();

	@Override
	public String postUser(User newuser) {
		this.user=newuser;
		UserRepo.save(user);
		return "Successfully Inserted user data";
	} 
	
	@Override
	public Optional<User> getUser(String UserName, String Password) {
		Optional<User> user = UserRepo.findUser(UserName, Password);
		return user;
	} 

}
