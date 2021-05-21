package com.example.demo.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	//relationship 1:n
	@OneToMany(mappedBy ="project",cascade = CascadeType.ALL)  //thể hiện nó đang có quan hệ 1:n và ánh xạ với nhiều Task 
	List<Task> task;
	
	//get set and controctor
}
