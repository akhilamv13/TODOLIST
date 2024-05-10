package com.example.ToDo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ToDo.entity.User;

@Repository
public interface userRepo extends JpaRepository<User,Long>{
	@Query(value = "SELECT * FROM user WHERE user_name=?1 AND password=?2",nativeQuery = true)
	Optional<User> findUser(String username,String password);
	
	@Query(value = "SELECT * FROM user WHERE user_name=?1",nativeQuery = true)
	Optional<User> findUserByUserName(String username);
}
