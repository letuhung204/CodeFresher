package com.example.demo.oneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	//relationship n-1
	@ManyToOne
	@JoinColumn(name="id_project",referencedColumnName = "id")  // sinh ra id_projetc trong table task . join voi ddoosi tuowng project ben duoi
	private Project project;
	
	
	//get and set and contructor
	
}
