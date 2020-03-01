package com.revature.controller;

/*Daniel Plummer 
 * Project_11
 * Request Helper
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/* Updates the login, manager, and employee html
 * pages from specific input.
 */
public class RequestHelper {
	
	private static Logger log = Logger.getRootLogger();

	public static HttpSession session;

	public static String process(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/Project11/HTML/register.go":
			log.info("Successfully registered.");
			return RegisterController.register(req);
		case "/Project11/HTML/login.go":
			return LoginController.login(req);
		case "/Project11/HTML/logout.go":
			log.info("Successfully logged out.");
			session = req.getSession(true);
			session.invalidate();
			session = req.getSession();
			return "login.html";
		case "/Project11/HTML/approved.go":
			return "manager.html";
		case "/Project11/HTML/denied.go":
			return "manager.html";
		default:
			return "login.html";
		}
	}

	public static String reimbProcess(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/Project11/HTML/reimb.submit":
			log.info("Reimbursement submitted.");
			return ReimbController.submitReimb(req);
		case "/Project11/HTML/updatereimb.submit":
			log.info("Reimbursement updated.");
			return ReimbController.updateReimb(req);
		default:
			return "employee.html";
		}
	}

	public static void directProcess(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/Project11/reimb.json":
			JacksonController.viewEmpReimbursement(req, resp);
			break;
		case "/Project11/employee.json":
			JacksonController.getUserByUsername(req, resp);
			break;
		case "/Project11/viewemployees.json":
			JacksonController.getUsers(req, resp);
			break;
		case "/Project11/allreimbs.json":
			JacksonController.getReimbs(req, resp);
		}
	}

}

