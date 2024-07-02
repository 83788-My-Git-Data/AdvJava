package com.sunbeam.dto;

import com.sunbeam.entities.type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomReqDTO {

	private int roomNumber;
	private type roomType;
	private double price;
}
