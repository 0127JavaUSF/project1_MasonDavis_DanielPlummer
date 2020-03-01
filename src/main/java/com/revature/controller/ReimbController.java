package com.revature.controller;

/*Daniel Plummer
 * Project_11
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimb;
import com.revature.service.ReimbService;

/* Creates controller for reimbursement page*/

public class ReimbController {

	
	private static Logger log = Logger.getRootLogger();
	static Date date = new Date();
	
	public static String submitReimb(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String author = (String) session.getAttribute("username");
		double amount = Double.parseDouble(req.getParameter("amount"));
		String description = req.getParameter("description");
		String statusId = "pending";
		String typeId = req.getParameter("typeId");
		ReimbService.submit(amount, description, author, statusId, typeId);
		return "employee.html";
	}

	public static String getReimbs(HttpServletRequest req, HttpServletResponse resp) {
		List<Reimb> rl = new ArrayList<Reimb>();
		rl = ReimbService.getReimbs();
		try {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(rl));
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return "manager.html";
	}
	
	public ReimbController() {
		super();
	}
	
	public static String updateReimb(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		int reimbId = Integer.parseInt(req.getParameter("reimburseselect"));
		String resolver = (String) session.getAttribute("userId").toString();
		String statusId = req.getParameter("statusId");
		System.out.println("This one is getting hit.");
		ReimbService.update(reimbId, resolver, statusId);
		return "manager.html";

	}


}
