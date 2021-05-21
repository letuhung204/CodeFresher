package com.example.demo.manyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="task2")
public class Task2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	//relationship n-n
	@ManyToMany
	@JoinTable(name = "member_task", //taoj ra table phu co ten member_task 
	joinColumns = @JoinColumn(name="task_id"),  // tạo ra 1 cột member_id, member_id asnh xaj vowsi cot id Member
	inverseJoinColumns = @JoinColumn(name="member_id")) //tao ra 1 cot task_id, task_id anh xa voi khoa chinh cua object ben duoi Task2
	private List<Member> listMember;
	
	//get set and contructor
	
}
