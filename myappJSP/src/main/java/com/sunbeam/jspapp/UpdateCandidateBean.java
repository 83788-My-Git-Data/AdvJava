package com.sunbeam.jspapp;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
	
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	public UpdateCandidateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UpdateCandidateBean(int id, String name, String party, int votes, int count) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
		this.count = count;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	public void	updateCandidate()
	{
		Candidate c=new Candidate(id,name,party,votes);
		try (CandidateDao candDao=new CandidateDaoImpl()){
			count=candDao.update(c);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
