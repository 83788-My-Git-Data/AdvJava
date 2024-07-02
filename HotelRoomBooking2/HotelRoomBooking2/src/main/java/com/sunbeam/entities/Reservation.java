package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Reservation extends BaseEntity{

//	guest id, check-in date, check-out date, room ID, total price.

//	  @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  @Column(name = "res_id")
//	    private Long reservationId;
	@ManyToOne
@JoinColumn(name="guest_id",nullable = false)
	private Guest guest;
	private LocalDate checkin;
	private LocalDate checkout;
	
	@ManyToOne
	@JoinColumn(name="room_id" ,nullable = false)
	private Room room;
	private double totalPrice;
	
}
