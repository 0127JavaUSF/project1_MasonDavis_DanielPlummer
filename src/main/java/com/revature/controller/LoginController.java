package com.revature.controller;

/*Daniel Plummer
 * Project_11
 */


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.dao.UserImpl;
import com.revature.model.CurrentUser;
import com.revature.model.User;
import com.revature.service.UserService;

/* Creates controller for user to input username and password
 * and validate user
 */
@SuppressWarnings("serial")
public class LoginController extends HttpServlet {

	private static Logger log = Logger.getRootLogger();

	public static String login(HttpServletRequest req) {

 
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User u = UserService.getUserByUsername(username);
		int id = u.getUserId();

		
		if (UserService.validateLogin(username, password)) {
			CurrentUser.currentUser = u;
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", id);
//			System.out.println(id);
			
			if (u.getRoleId() == 1) {
				log.info("User logged in as an employee.");
				//enter actual  file
				return "employee.html";
			} else if (u.getRoleId() == 2) {
				log.info("User logged in as a manager.");
				//enter actual  file
				return "manager.html";
			}
		}

		else {
			log.info("Invalid login information.");
			//enter actual  file
			return "login.html";
		}
		//enter actual  file
		return "login.html";
	}
	
	public static String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		log.info("Successfully logged out.");
		System.out.println("Is this working?");
		
		//enter actual file
		return "login.html";
		
	}
}
