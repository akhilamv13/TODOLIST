package com.example.ToDo.service;

import java.util.List;
import java.util.Optional;

import com.example.ToDo.entity.Project;

public interface ProjectService {
	public String postProject(String Username,String title);
	public Optional<Project> getProjectById(long id);
	public List<Project> getProjectList(String Username);
	public String updateProject(long id,String title);
	public String deleteProjectList(long id);
	//public String postProject(Project project);

}
