package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService iStudentService;	

	
	//viet mot api test
	@GetMapping(value="/hello")
	public String testHello() {
		return "SPRING DATA JPA";
	}
	
	//api theem student
	@PostMapping(value="/add")
	public Student themStudent(@RequestBody Student student) {
		
		return iStudentService.themStudent(student);
	}
	
	//api get all
	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return iStudentService.getAllStudent();
	}
	
	//get by id
	@GetMapping("/getById")
	public Student getById(@RequestParam("id")Long id) {
		
		return iStudentService.getById(id);
	}
	
	//update by Id
	@PutMapping("/updateById")
	public Student updateStudent(@RequestParam("id") long id,@RequestBody Student student){
		return iStudentService.updateStudent(id, student);
	}
	
	//deleted by id
	@DeleteMapping("/deleteById/{id}")
	public boolean deleteById(@PathVariable("id") long id) {
		
		return iStudentService.deleteStudentById(id);
	}
	//can viet 1 api lay ra tat cac nhung sinh vien co ten la hung
	@GetMapping("/select/isHung")
	public List<Student> getListByFirstNameIsHung(){
		
		return iStudentService.findByNameIsHung();
	}
	
	// can viet 1 api lay ra tat cac nhung sinh vien co ten them tham so truyen vao
	@GetMapping("/select/byKeySearch")
	public List<Student> listStudentByKey(@RequestParam("key") String key){
		//goi den tang service
		return iStudentService.findByKeySearch(key);
	}
	
	// can viet 1 api lay ra tat cac nhung sinh vien co ten them tham so truyen vao
	@GetMapping("/select/byKeySearch2")
	public List<Student> listStudent(@RequestParam("firstname") String firstname,@RequestParam("lastname")String lastName){
		//goi den tang service
		return iStudentService.searchName(firstname, lastName);
	}
	
	//update api @query
	@PutMapping("/update")
	public int updateStudent(@RequestParam("name")String firstName) {
		return iStudentService.updateStudent(firstName);
	}
	
	
	
}
