package com.example.demo.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	
	@PostMapping("/save/student")
	public RedirectView addStudent(RedirectAttributes redirectAttributes,@RequestParam(value="id",required = false)int id,Student studentNew) {
//			@RequestParam(value="avatar",required = false)MultipartFile avatar) {
		Student student;
		if(id != 0) {
			student = studentService.getById(id);
		}else {
			student = new Student();
		}
			
		try {
			student.setFirstName(studentNew.getFirstName());
			student.setAge(studentNew.getAge());
			student.setLastName(studentNew.getLastName());
			student.setLopHoc(studentNew.getLopHoc());
			
			//save file
//			String originNameFile = avatar.getOriginalFilename();
//			String fileName;
//			if(originNameFile != null && !originNameFile.equals("")) {
//				//lay ten anh
//				fileName = StringUtils.cleanPath(originNameFile);
//				//set ten anh cho thuopc tinh avatar
//				student.setAvatar(fileName);
//				
//				
//				//luu cai anh vao folder photo
//				String uploadDir = "photo/";
//				//luu anh
//				Path uploadPath = Paths.get(System.getProperty("user.dir") + uploadDir);
//				
//				//kiem tra upload path co ton tai ko
//				if(!Files.exists(uploadPath)) {
//					Files.createDirectories(uploadPath);
//				}
//				
//				InputStream inputStream = avatar.getInputStream();
//				Path photoPath = uploadPath.resolve(fileName);
//				Files.copy(inputStream, photoPath,StandardCopyOption.REPLACE_EXISTING);
		
//			}
			
			studentService.addStudent(student);
		} catch (Exception e) {
			String error = "oh. loi roi";
			//truyen một thuộc tính/đối tượng cho màn hình ridrect để màn hình ấy hiển thị thông tin (sử dụng RedirectAttributes)
		    redirectAttributes.addFlashAttribute("error",error);
			return new RedirectView("/form/student",true);
		}
		
		
		return new RedirectView("/getAll",true);
		
	}
	@GetMapping("deleted/student")
	public RedirectView deleteById(@RequestParam("id") int id) {
		
		studentService.deleteStudentById(id);
		return new RedirectView("/getAll",true);
	}
	
	@GetMapping("/update/student")
	public String updateStudentById(@RequestParam("id") int id,Model model) {
		Student student = studentService.getById(id);
		model.addAttribute("student",student);
		return "studentForm";
		
	}

}
