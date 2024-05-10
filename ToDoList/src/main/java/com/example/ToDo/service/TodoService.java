package com.example.ToDo.service;

import java.util.List;
import java.util.Optional;

import com.example.ToDo.entity.ToDo;

public interface TodoService {

	public String postTodo(long projectId,List<Object> todoDetails);
	public Optional<ToDo> getToDotById(long id);
	public List<ToDo> getToDoList(long id);
	public String updateToDo(long id,List<Object> todoDetails);
	public String deleteToDoList(long id);

}
