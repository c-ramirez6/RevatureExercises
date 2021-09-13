package com.revature.Spring.jpa.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.Spring.jpa.demo.entity.Guardian;
import com.revature.Spring.jpa.demo.entity.Student;
import com.revature.Spring.jpa.demo.repository.StudentRepository;

@SpringBootTest
class SpringJpaDemoApplicationTests {

	@Autowired
	StudentRepository repo;
	
//	@Test
//	public void saveStudent()	{
//		Guardian guardian = Guardian.builder()
//				.name("Watson")
//				.email("w@gmail.com")
//				.mobile("7777")
//				.build();
//		
//		Student student = Student.builder()
//				.firstName("Stacy")
//				.lastName("Kormak")
//				.emailAddress("s@gmail.com")
//				.guardian(guardian)
//				.build();
//		repo.save(student);
//	}
	
	@Test
	public void displayStudentByFirstName()	{
		List<Student> list = repo.findByFirstName("Stacy");
		System.out.println(list);
	}
	
	@Test
	public void displayStudentByFirstNameContaining()	{
		List<Student> list = repo.findByFirstNameContaining("a");
		System.out.println(list);
	}
	
	@Test
	public void TestFor_getStudentByEmailAddress()	{
		Student student = repo.getStudentByEmailAddress("s@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void TestFor_getStudentFirstNameByEmailAddress()	{
		String firstName = repo.getStudentFirstNameByEmailAddress("m@gmail.com");
		System.out.println(firstName);
	}
	
	@Test
	public void TestFor_getStudentByFirstNameNative()	{
		Student student = repo.getStudentByFirstNameNative("Mark");
		System.out.println(student);
	}
}
