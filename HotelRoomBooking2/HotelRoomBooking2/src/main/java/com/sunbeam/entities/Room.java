package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Room extends BaseEntity{

//	Room ID, room number, type (single, double, suite), price, availability(boolean)

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="room_id")
//	private Long roomId;
	@Column(name = "room_no", unique = true)
	private int roomNumber;
	@Column(name = "room_type")
	@Enumerated(EnumType.STRING)
	private type roomType;

	private double price;

	
	
}
