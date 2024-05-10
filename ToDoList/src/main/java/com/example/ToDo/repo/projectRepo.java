package com.example.ToDo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ToDo.entity.Project;

public interface projectRepo extends JpaRepository<Project,Long>{
	@Query(value = "SELECT * FROM projects WHERE user_name=?1",nativeQuery = true)
	List<Project> findbyUsername(String username);
}
