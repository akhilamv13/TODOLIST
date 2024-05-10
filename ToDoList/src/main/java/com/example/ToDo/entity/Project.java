package com.example.ToDo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class Project {

	 public Project() {
		// TODO Auto-generated constructor stub
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private  Long ProjectId;

	    @NonNull
	    private  String title;
	    private Date createdDate;
	    private Date updatedDate;

	    @OneToMany(targetEntity=ToDo.class,cascade=CascadeType.ALL)
	    @JoinColumn(name="ProjectId",referencedColumnName="ProjectId")
	    private List<ToDo> toDo =new ArrayList<>();

}
