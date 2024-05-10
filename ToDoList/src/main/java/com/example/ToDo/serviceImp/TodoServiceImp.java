package com.example.ToDo.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDo.entity.Project;
import com.example.ToDo.entity.ToDo;
import com.example.ToDo.entity.User;
import com.example.ToDo.repo.projectRepo;
import com.example.ToDo.repo.todoRepo;
import com.example.ToDo.service.TodoService;

@Service
public class TodoServiceImp implements TodoService{

	@Autowired
	todoRepo ToDoRepo;
	
	@Autowired
	projectRepo ProjectRepo;

	@Override
	public String postTodo(long projectId,List<Object> todoDetails) {
		ToDo todo = new ToDo();
		List<ToDo> todoList = new ArrayList<>();
		todo.setDescription(todoDetails.get(0).toString());
		todo.setStatus((boolean)todoDetails.get(1));
		todo.setCreatedDate(new Date());
		todo.setUpdatedDate(new Date());
		todoList.add(todo);
		Optional<Project> projectOptional = ProjectRepo.findById(projectId);
		Project project = new Project();
		if(projectOptional!=null && !projectOptional.isEmpty()) {
			project = projectOptional.get();
		}
		project.getToDo().add(todo);
		ProjectRepo.save(project);
		return "Successfully Inserted ToDO data";
	} 
	
	@Override
	public Optional<ToDo> getToDotById(long id) {
		Optional<ToDo> todo = ToDoRepo.findById(id);
		return todo;
	} 
	
	@Override
	public List<ToDo> getToDoList(long id) {
		List<ToDo> projects = ToDoRepo.findbyProjectId(id);
		return projects;
	} 
	
	@Override
	public String updateToDo(long id,List<Object> todoDetails) {
		Optional<ToDo> updateToDo = ToDoRepo.findById(id);
		String msg=null;
		if(updateToDo!= null && !updateToDo.isEmpty()) {
			ToDo todo1 = updateToDo.get();
			todo1.setDescription(todoDetails.get(0).toString());
			todo1.setStatus((boolean)todoDetails.get(1));
			todo1.setUpdatedDate(new Date());
			ToDoRepo.save(todo1);
			msg= "Successfully updated ToDo data";
		}else {
			msg= "ToDo not found";
		}
		return msg;
	} 
	
	@Override
	public String deleteToDoList(long id) {
		Optional<ToDo> updateToDo = ToDoRepo.findById(id);
		String msg=null;
		if(updateToDo!= null && !updateToDo.isEmpty()) {
			ToDoRepo.deleteById(id);
			msg= "Successfully deleted ToDo data";
		}else {
			msg= "ToDo not found";
		}
		return msg;
	}

}
