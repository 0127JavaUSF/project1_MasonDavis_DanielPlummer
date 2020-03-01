package com.revature.controller;

/*Daniel Plummer
 * Project_11
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimb;
import com.revature.model.User;
import com.revature.service.ReimbService;
import com.revature.service.UserService;

//Creates user array for input into user table
public class JacksonController {

	private static Logger log = Logger.getRootLogger();

	public static void getUsers(HttpServletRequest req, HttpServletResponse resp) {

		ObjectMapper om = new ObjectMapper();
		List<User> users = UserService.getUsers();

		String user = "";

		try {
			user = om.writeValueAsString(users);
			resp.getWriter().write("{\"list\":" + user + "}");
			System.out.println(user);

		} catch (JsonProcessingException e1) {
			log.error(e1.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public static void viewEmpReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		//Retrieves author of reimbursement reques
		int author = (Integer) session.getAttribute("userId");
		System.out.println((Integer) session.getAttribute("userId"));
		ObjectMapper om = new ObjectMapper();

		List<Reimb> rl = ReimbService.getReimbsByUserId(author);

		try {
			String reimbs = om.writeValueAsString(rl);
			resp.getWriter().write(reimbs);

		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public static void getReimbs(HttpServletRequest req, HttpServletResponse resp) {

		ObjectMapper om = new ObjectMapper();

		List<Reimb> rl = ReimbService.getReimbs();

		try {
			String reimbs = om.writeValueAsString(rl);
			resp.getWriter().write("{\"list\":" + reimbs + "}");
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

	public static void getUserByUsername(HttpServletRequest req, HttpServletResponse resp) {

		ObjectMapper om = new ObjectMapper();
		HttpSession session = req.getSession(true);
		int author = (int) session.getAttribute("userId");

		User u = UserService.getUserById(author);

		String user = "";

		try {
			user = om.writeValueAsString(u);
			resp.getWriter().write("{\"list\":" + user + "}");
//			System.out.println(user);
		} catch (JsonProcessingException e1) {
			log.error(e1.getMessage());

		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public static String getReimbByResolver(int resolver) {

		ObjectMapper om = new ObjectMapper();

		List<Reimb> reimb = ReimbService.getReimbByResolver(resolver);
		String reimbs = "";

		try {
			reimbs = om.writeValueAsString(reimb);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return "{\"reimbursements\":" + reimbs + "}";
	}

}

