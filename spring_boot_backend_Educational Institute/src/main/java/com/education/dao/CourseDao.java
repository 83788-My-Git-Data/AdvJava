package com.education.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
