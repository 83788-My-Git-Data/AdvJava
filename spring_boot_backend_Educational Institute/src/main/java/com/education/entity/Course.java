package com.education.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Course extends BaseEntity{

//	1. ID (unique identifier for each Course, auto generated, starts from 1)
//	2. Name (Cannot be Blank, Example : JAVA01, JAVA02, WEBJAVA01, WEBJAVA02)
//	3. Category (Enum, Example: JAVA-BEGINER, JAVA-ADVANCED)
//	4. Start Date (Cannot be Blank)
//	5. End Date (Cannot be Blank)
//	6. Fee (Cannot be Blank)
//	7. Grade to Pass (Cannot be Blank)
	
	@Column(name = "name", nullable =false )
	private String name;
	private Category category;
	@Column(name="startDate" , nullable = false)
	private LocalDate startDate;
	@Column(name="endDate" , nullable = false)
	private LocalDate endDate;
	@Column(name = "fee", nullable = false)
	private double fee;
	@Column(nullable = false)
	private String grade;
	
	
	
	 
	
	
}
