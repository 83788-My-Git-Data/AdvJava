package com.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.DTO.AddCourseReqDTO;
import com.education.DTO.AddCourseRespDTO;
import com.education.DTO.ApiResponse;
import com.education.DTO.UpdateCourseDTO;
import com.education.Service.CourseService;
import com.education.entity.Course;


@RestController
@RequestMapping("/addCourse")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody AddCourseReqDTO reqDTO)
	{
		System.out.println(reqDTO);
		try {
			AddCourseRespDTO respDTO=courseService.addCourse(reqDTO);
			System.out.println("in try block"+respDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(respDTO);
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("in catch block"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable Long courseId,@RequestBody UpdateCourseDTO course)
	{
		try {
		return ResponseEntity.ok(courseService.updateCourse(courseId, course));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse("course not updated successfully!!!"));
		}
		
	}
}
