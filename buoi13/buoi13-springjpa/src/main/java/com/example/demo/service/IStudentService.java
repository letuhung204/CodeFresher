package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface IStudentService {

	public Student themStudent(Student student);
	
	public Student updateStudent(long id,Student student);
	
	public List<Student> getAllStudent();
	
	public Student getById(Long id);
	
	public boolean deleteStudentById(long id);
	
}
