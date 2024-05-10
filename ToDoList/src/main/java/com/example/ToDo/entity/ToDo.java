package com.example.ToDo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "todos")
public class ToDo {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long todoId;
	 private  String description;
	 private  Boolean status;
	 private Date createdDate;
	 private Date updatedDate;
}
