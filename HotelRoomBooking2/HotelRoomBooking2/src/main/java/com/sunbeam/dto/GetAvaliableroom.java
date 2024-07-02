package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAvaliableroom {

	
	private LocalDate check_in;
	private LocalDate check_out;
	
}
