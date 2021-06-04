package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends 	JpaRepository<Student, Long>{
	
	@Query(value = "select s from Student as s where s.firstName like 'hung'")
	public List<Student> findByNameIsHung();
	
	@Query(value = "select * from student where first_name like '%hung%'",nativeQuery = true)
	public List<Student> findByNameIsHungC2();
	
	//viet query truyen param
	@Query(value = "select * from student where first_name like concat('%',?1,'%')",nativeQuery = true)
	public List<Student> findByFirstNameByKey(String keySearch );
	
	//viet query truyen 2 or nhieu param
	@Query(value="select * from student where first_name like concat('%',?1,'%') and last_name like concat('%',?2,'%')",nativeQuery = true)
	public List<Student> searchByName(String firstName,String lastname );
	
	@Modifying
	@Transactional
	@Query(value="update student stu set stu.first_name=:firstName where stu.id=1",nativeQuery = true)
	public int updateStudenByid(@Param("firstName")String firstName);
	
}
