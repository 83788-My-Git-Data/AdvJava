package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationReq extends BaseDTO{

//	guest name, check-in date, check-out date, room ID
//	private String firstName;
//	private String lastName;
	private Long guestid;
	private LocalDate check_in;
	private LocalDate check_out;
	private Long roomid;
//	private LocalDate checkAvaliableRoom;
}
