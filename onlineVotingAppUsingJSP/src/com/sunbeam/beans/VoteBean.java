package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	private int candId; // id of candidate
	private int userId;
	private User user;

	public VoteBean() {
	}

	public VoteBean(int candId, int userId, User user) {
		this.candId = candId;
		this.userId = userId;
		this.user = user;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void vote() {
		try (UserDao userDao = new UserDaoImpl()) {
			user = userDao.findById(userId);
			System.out.println("user " + user);
			try (CandidateDao candidateDao = new CandidateDaoImpl()) {
				if (user.getStatus() == 0) {
					candidateDao.incrementVote(candId);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			userDao.updateStatus(userId, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
