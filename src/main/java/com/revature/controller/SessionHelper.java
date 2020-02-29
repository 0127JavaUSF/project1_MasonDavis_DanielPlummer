package com.revature.controller;

/*Daniel Plummer
 * Project_11
 */

import java.util.List;

import com.revature.model.Reimb;
import com.revature.model.User;


public class SessionHelper {
	
	private User u;
	private List<Reimb> r;
	
	public SessionHelper() {
		super();
	}

	public SessionHelper(User u, List<Reimb> r) {
		super();
		this.u = u;
		this.r = r;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public List<Reimb> getR() {
		return r;
	}

	public void setR(List<Reimb> r) {
		this.r = r;
	}
}

