package com.jsp.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.jsp.student_management_system.dto.Student;
import com.jsp.student_management_system.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/")
	public String loadMain() {
		return "main.html";
	}
	
	//Getting The Add.html Page in the Browser.
	@GetMapping("/add")
	public String loadAdd() {
		return "add.html";
	}
	
	//To Save the Data into the Database.
	@PostMapping("/add")
	public String add(@ModelAttribute Student student, Model model) {
		studentRepository.save(student);
		model.addAttribute("msg","Data added Succesfull");
		return "main.html";	
	}
	
	//Fetch the Student Details.
	@GetMapping("/fetch")
	public String loadFetch(Model model) {
		List<Student> list=studentRepository.findAll();
		model.addAttribute("list",list);
		return "fetch.html";
	}
}
