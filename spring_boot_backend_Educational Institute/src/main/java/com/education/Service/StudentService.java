package com.education.Service;

import com.education.DTO.AddStudentDTO;
import com.education.DTO.ApiResponse;

public interface StudentService{

	public ApiResponse addStudent(AddStudentDTO DTO);
}
