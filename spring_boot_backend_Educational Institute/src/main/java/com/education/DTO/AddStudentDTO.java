package com.education.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddStudentDTO {

	private Long sId;

	private String sName;

	private String email;

	private String password;

	private Long cid;
}
