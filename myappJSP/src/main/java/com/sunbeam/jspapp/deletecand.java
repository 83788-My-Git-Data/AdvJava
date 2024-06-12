package com.sunbeam.jspapp;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class deletecand {

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private int id;
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public deletecand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public deletecand(int id) {
		super();
		this.id = id;
	}
	
	public void deleteCandidate()
	{
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			count= candDao.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
