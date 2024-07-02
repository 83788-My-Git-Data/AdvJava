package com.education.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Super;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {

	private String msg;
	private LocalDate timeStamp;
	
	public ApiResponse(String message) {
		this.msg=message;
	}
}
