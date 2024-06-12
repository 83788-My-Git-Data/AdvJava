package com.sunbeam.jspapp;

import java.sql.Date;


import com.sunbeam.daos.UserDao;

//import java.sql.Date;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean {

	private String firstName;
	private String lastName;
	private String email;
	private String passwd;
	private String birth;
	private String role;
	private int status;
	private int count;


	
	//Date date=String.valueOf(dob); java.sql.date
	//uderDaoImp
	//User user=new User(.......)
	//userDao.save(user,date)
	
	public void registeruser() {

		Date dob=Date.valueOf(birth);
		
		User user1=new User(0,firstName, lastName, email, passwd, dob, status, role);
		
		try(UserDao userDao= new UserDaoImpl())
		{
			count=userDao.save(user1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}
}
