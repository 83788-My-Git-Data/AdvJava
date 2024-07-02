package com.education.Service;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.DTO.AddStudentDTO;
import com.education.DTO.ApiResponse;
import com.education.dao.CourseDao;
import com.education.dao.StudentDao;
import com.education.entity.Course;
import com.education.entity.Student;
import com.sunbeam.custom_exceptions.ApiException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ModelMapper mapper;
	
//	@Override
	public ApiResponse addStudent(AddStudentDTO DTO) {
		// TODO Auto-generated method stub
		Course course=courseDao.findById(DTO.getCid()).orElseThrow(()->new ApiException("invalid course id.."));
		Student student=mapper.map(DTO,Student.class);
		student.setCourse(course);
		studentDao.save(student);
		return new ApiResponse("student added");
	}

}
