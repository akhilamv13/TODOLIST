package com.example.ToDo.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDo.entity.Project;
import com.example.ToDo.entity.User;
import com.example.ToDo.repo.projectRepo;
import com.example.ToDo.repo.userRepo;
import com.example.ToDo.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService{


	@Autowired
	projectRepo ProjectRepo;
	
	@Autowired
	userRepo UserRepo;

	@Override
	public String postProject(String Username,String title) {
		Project project = new Project();
		List<Project> projectList = new ArrayList<>();
		project.setTitle(title);
		project.setCreatedDate(new Date());
		project.setUpdatedDate(new Date());
		projectList.add(project);
		Optional<User> userOptional = UserRepo.findUserByUserName(Username);
		User user = new User();
		if(userOptional!=null && !userOptional.isEmpty()) {
			user = userOptional.get();
		}
		user.getProjects().add(project);
		UserRepo.save(user);
		return "Successfully Inserted project data";
	} 
	
//	@Override
//	public String postProject(Project project) {
//        ProjectRepo.save(project);
//        return "Successfully Inserted project data";
//    }
	
	@Override
	public Optional<Project> getProjectById(long id) {
		Optional<Project> project = ProjectRepo.findById(id);
		return project;
	} 
	
	@Override
	public List<Project> getProjectList(String Username) {
		List<Project> projects = ProjectRepo.findbyUsername(Username);
		return projects;
	} 
	
	@Override
	public String updateProject(long id,String title) {
		Optional<Project> updateproject = ProjectRepo.findById(id);
		String msg=null;
		if(updateproject!= null && !updateproject.isEmpty()) {
			Project project1 = updateproject.get();
			project1.setTitle(title);
			project1.setUpdatedDate(new Date());
			ProjectRepo.save(project1);
			msg= "Successfully updated project data";
		}else {
			msg= "project not found";
		}
		return msg;
	} 
	
	@Override
	public String deleteProjectList(long id) {
		Optional<Project> updateproject = ProjectRepo.findById(id);
		String msg=null;
		if(updateproject!= null && !updateproject.isEmpty()) {
			ProjectRepo.deleteById(id);
			msg= "Successfully deleted project data";
		}else {
			msg= "project not found";
		}
		return msg;
	}
}
