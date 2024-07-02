package com.education.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
