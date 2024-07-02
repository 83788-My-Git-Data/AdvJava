package com.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.DTO.AddStudentDTO;
import com.education.DTO.ApiResponse;
import com.education.Service.StudentService;

@RestController
@RequestMapping("/addstudent")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody AddStudentDTO DTO)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(DTO));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));	
		}
	}
}
