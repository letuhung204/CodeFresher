package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;

@Controller
public class TestController {

	//cach 1
	// trả thẳng xuống tầng view thông qua file name (.jsp)
	@GetMapping("/test")
	public String test(Model model) {
		String hello ="cuoc song cua lap trinh vien";
		//cách truyền đối tượng ở BE xuống tầng view
		model.addAttribute("name_map_view",hello);
		
		//them object vao cho view jsp
		Student student = new Student(1, "Chien", "Dam Duc Chien", 20);
		model.addAttribute("student_map",student);
		
		//show list object (list Student)
		Student student2 = new Student(2, "Tung", "Hoang Tho Tung", 21);
		Student student3 = new Student(3, "Tuan", "Hoang Van Tuan", 22);
		List<Student> listStudent = new ArrayList<>();
		listStudent.add(student);
		listStudent.add(student2);
		listStudent.add(student3);
		
		
		// add list object for view page jsp
		model.addAttribute("list_student",listStudent);
		
		return "test";
	}
	
	
	//cách thư 2 ; sử dụng đối tượng modelAndView 
	@GetMapping("/hello")
	public ModelAndView hello() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		return model;
	}
	
}
