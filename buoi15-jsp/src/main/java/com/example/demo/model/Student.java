package com.example.demo.model;

public class Student {

	private int id;
	private String name;
	private String fullName;
	private int age;

	
	public Student(int id, String name, String fullName, int age) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
