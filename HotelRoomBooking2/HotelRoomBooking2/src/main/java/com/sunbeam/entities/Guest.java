package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "guests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Guest extends BaseEntity{
//	Guest ID  first name ,last name , dob
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="guest_id")
//	private Long guestId;
	@Column(name = "first_name", length = 25) // col name , varchar(25)
	private String firstName;
	@Column(name = "last_name", length = 25) // col name , varchar(25)
	private String lastName;
	@Column(name = "dob")
	private LocalDate dob;
	private String email;

	
}
