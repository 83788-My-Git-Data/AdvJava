package com.education.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student extends BaseEntity{

	@Column( nullable =false )
	private String sname;
	@Column( nullable =false )
	private String email;
	@Column( nullable =false )
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Cid" ,nullable = false)
	private Course course;
}
