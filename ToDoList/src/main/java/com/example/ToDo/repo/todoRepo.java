package com.example.ToDo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ToDo.entity.ToDo;

@Repository
public interface todoRepo extends JpaRepository<ToDo,Long>{
	@Query(value = "SELECT * FROM todos WHERE project_id=?1",nativeQuery = true)
	List<ToDo> findbyProjectId(long id);
}
