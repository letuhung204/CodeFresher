package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface IStudentService {

	public Student themStudent(Student student);
	
	public Student updateStudent(long id,Student student);
	
	public List<Student> getAllStudent();
	
	public Student getById(Long id);
	
	public boolean deleteStudentById(long id);
	
	public List<Student> findByNameIsHung();
	
	public List<Student> findByKeySearch(String key);
	//fucntion search theo nhieu dk
	public List<Student> searchName(String firstname,String lastname);
	
	public int updateStudent(String firstName);
}
