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

import com.example.ToDo.entity.Project;
import com.example.ToDo.service.ProjectService;

@RestController
public class projectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping("/postProject")
	public String postProject(@RequestParam String Username,@RequestBody String title) {
		return projectService.postProject(Username, title);
	}
	
	@GetMapping("/getProjectById")
	public Optional<Project> getProjectById(@RequestParam long projectId){
		return projectService.getProjectById(projectId);
	}
	
	@GetMapping("/getProjectList")
	public List<Project> getProjectList(@RequestParam String Username){
		return projectService.getProjectList(Username);
	}
	
	@PutMapping("/updateProject")
	public String updateProject(@RequestParam long projectId,@RequestBody String title) {
		return projectService.updateProject(projectId, title);
	}
	
	@DeleteMapping("/deleteProjectList")
	public String deleteProjectList(@RequestParam long projectId) {
		return projectService.deleteProjectList(projectId);
	}

}
