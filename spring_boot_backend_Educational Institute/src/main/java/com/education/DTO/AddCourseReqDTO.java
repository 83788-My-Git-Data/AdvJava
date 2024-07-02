package com.education.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.education.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddCourseReqDTO {

//	Name, Category, Start Date, End Date, Fee
	@NotBlank
	private String name;
	@NotBlank
	private Category category;
	@NotBlank
	private LocalDate startDate;
	@NotBlank
	private LocalDate endDate;
	@NotBlank
	private double fee;
	@NotBlank
	private String grade;
}
