package com.jsp.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.student_management_system.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
