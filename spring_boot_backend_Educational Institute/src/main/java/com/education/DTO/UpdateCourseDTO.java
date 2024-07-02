package com.education.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UpdateCourseDTO {

	private Double fee;
	private LocalDate startDate ;
	private LocalDate endDate ;
	
}
