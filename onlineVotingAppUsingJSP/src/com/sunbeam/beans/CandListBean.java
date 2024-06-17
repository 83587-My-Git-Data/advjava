package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandListBean {
	private List<Candidate> candlist;

	public CandListBean() {
		candlist = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandlist() {
		return candlist;
	}

	public void setCandlist(List<Candidate> candlist) {
		this.candlist = candlist;
	}

	public void provide() {
		try (CandidateDao cand = new CandidateDaoImpl()) {
			candlist = cand.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
