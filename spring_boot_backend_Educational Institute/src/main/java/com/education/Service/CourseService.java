package com.education.Service;

import com.education.DTO.AddCourseReqDTO;
import com.education.DTO.AddCourseRespDTO;
import com.education.DTO.ApiResponse;
import com.education.DTO.UpdateCourseDTO;
import com.education.entity.Course;


public interface CourseService {

	AddCourseRespDTO addCourse(AddCourseReqDTO addCourseDTO);
	
	ApiResponse updateCourse(Long courseId,UpdateCourseDTO updatedCourse);
}
