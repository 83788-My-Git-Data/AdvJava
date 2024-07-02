package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ReservationResp extends BaseDTO{

	public ReservationResp() {
		// TODO Auto-generated constructor stub
	}
	private Long id;
	
	private double price;
//	private String message;
//	private String ReservationStatus;
}
