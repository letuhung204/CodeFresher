package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Student;
import com.example.demo.service.IstudentService;

@Controller
public class StudentController {
	
	@Autowired
	private IstudentService studentService;
	
	@GetMapping("/test")
	public String test() {
		return "index";
	}
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		model.addAttribute("listStudent",studentService.listAll());
		
		return "listStudent";
	}
	@GetMapping("/form/student")
	public String formStudent(Model model) {
		model.addAttribute("student",new Student());
		return "studentForm";
	}
	
	@PostMapping("/form/save/student")
	public RedirectView addStudent(@RequestParam("firstName") String firstName,@RequestParam("lastName")String lastName,@RequestParam("age")int age,@RequestParam("lopHoc")String lopHoc) {
		 Student student = new Student();
		student.setFirstName(firstName);
		student.setAge(age);
		student.setLastName(lastName);
		student.setLopHoc(lopHoc);
		
		studentService.addStudent(student);
		
		return new RedirectView("/getAll",true);
		
	}
	@GetMapping("deleted/student")
	public String deleteById(@RequestParam("id") int id) {
		
		studentService.deleteStudentById(id);
		return "listStudent";
	}

}
