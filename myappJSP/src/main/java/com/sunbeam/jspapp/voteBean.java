package com.sunbeam.jspapp;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

public class voteBean {

	private int id;
	private int count;
	private int userid;
	private int c;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public void votetocandidate()
	{
		try(UserDao userDao = new UserDaoImpl()) {
				c=userDao.updateStatus(userid,true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		try(CandidateDao candidate = new CandidateDaoImpl()) {
			count = candidate.incrementVote(id);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
}
