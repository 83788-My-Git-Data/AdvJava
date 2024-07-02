package com.education.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddCourseRespDTO {

	private Long Id;
	private LocalDate startDate;
	private LocalDate endDate;
	
}
