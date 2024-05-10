package com.example.ToDo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.JoinColumn;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String firstName;

	    private String lastName;

	    private String email;

	    @Column(unique = true)
	    private String userName;

	    private String password;

	    @OneToMany(targetEntity=Project.class,cascade=CascadeType.ALL)
	    @JoinColumn(name="userName",referencedColumnName="userName")
	    private List<Project> projects =new ArrayList<>();


}
