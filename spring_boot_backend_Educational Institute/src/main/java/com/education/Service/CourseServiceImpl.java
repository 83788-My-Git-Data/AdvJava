package com.education.Service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.DTO.AddCourseReqDTO;
import com.education.DTO.AddCourseRespDTO;
import com.education.DTO.ApiResponse;
import com.education.DTO.UpdateCourseDTO;
import com.education.dao.CourseDao;
import com.education.entity.Category;
import com.education.entity.Course;
import com.sunbeam.custom_exceptions.ApiException;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AddCourseRespDTO addCourse(AddCourseReqDTO addCourseDTO) {
		// TODO Auto-generated method stub
		Course course=mapper.map(addCourseDTO,Course.class);
		System.out.println(course);
		Course persistentCourse=courseDao.save(course);
		System.out.println(persistentCourse);
		return mapper.map(course,AddCourseRespDTO.class);
	}

	@Override
	public ApiResponse updateCourse(Long courseId,UpdateCourseDTO updatedCourse) {
		
		 Course upCourse =  courseDao.findById(courseId).orElseThrow(()-> new ApiException("invalid id"));
		upCourse.setEndDate(updatedCourse.getEndDate());
		upCourse.setStartDate(updatedCourse.getStartDate());
		upCourse.setFee(updatedCourse.getFee());
		courseDao.save(upCourse);
		
		return new ApiResponse("course Updated Successfully");			
		
	}
	
	

}
