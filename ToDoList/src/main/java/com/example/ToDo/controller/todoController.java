package com.example.ToDo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDo.entity.ToDo;
import com.example.ToDo.service.TodoService;

@RestController
public class todoController {

	@Autowired
	TodoService todoService;
	
	@PostMapping("/postTodo")
	public String postTodo(@RequestParam long projectId,@RequestBody List<Object> todoDetails) {
		return todoService.postTodo(projectId, todoDetails);
	}
	
	@GetMapping("/getToDotById")
	public Optional<ToDo> getToDotById(@RequestParam long todoId){
		return todoService.getToDotById(todoId);
	}
	
	@GetMapping("/getToDoList")
	public List<ToDo> getToDoList(@RequestParam long projetId){
		return todoService.getToDoList(projetId);
	}
	
	@PutMapping("/updateToDo")
	public String updateToDo(@RequestParam long todoId,@RequestBody List<Object> todoDetails) {
		return todoService.updateToDo(todoId, todoDetails);
	}
	
	@DeleteMapping("/deleteToDoList")
	public String deleteToDoList(@RequestParam long todoId) {
		return todoService.deleteToDoList(todoId);
	}

}
