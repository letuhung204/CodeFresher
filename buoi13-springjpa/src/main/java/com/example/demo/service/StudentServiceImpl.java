package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository ;
	
	//them sinh vien
	@Override
	public Student themStudent(Student student) {
		// TODO Auto-generated method stub
		if(null != student) {
			return studentRepository.save(student);
		}
		return null;
	}

	//update data cua mot sinh vien hien co
	@Override
	public Student updateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		
		Student studentCurrent = getById(id); 
		
		studentCurrent.setAge(student.getAge());
		studentCurrent.setFirstName(student.getFirstName());
		studentCurrent.setLastName(student.getLastName());
		studentCurrent.setLop(student.getLop());
		
		return studentRepository.save(studentCurrent);
	}

	//lay ra tat ca sinh vien
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	//lay ra sinh vien theo ID
	@Override
	public Student getById(Long id) {
		// TODO Auto-generated method stub
	
		return studentRepository.getOne(id);
	}

	//delete sinh vien
	@Override
	public boolean deleteStudentById(long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.getById(id);
		
		if(null != student) {
			studentRepository.delete(student);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Student> findByNameIsHung() {
		// TODO Auto-generated method stub
		System.out.println("logic xuwr ly o day");
		return studentRepository.findByNameIsHungC2();
	}

	@Override
	public List<Student> findByKeySearch(String key) {
		// TODO Auto-generated method stub
		System.out.println("search by key");
		return studentRepository.findByFirstNameByKey(key);
	}

	@Override
	public List<Student> searchName(String firstname, String lastname) {
		// TODO Auto-generated method stub
		
		
		return studentRepository.searchByName(firstname,lastname);
	}

	@Override
	public int updateStudent(String firstName) {
		// TODO Auto-generated method stub
		
		
		return studentRepository.updateStudenByid(firstName);
	}

}
