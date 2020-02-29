package com.revature.controller;

/*Daniel Plummer
 * Project_11
 * Register Controller
 */


import javax.servlet.http.HttpServletRequest;


import com.revature.service.UserService;

public class RegisterController {
	
	public static String register(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		int roleId = Integer.parseInt(req.getParameter("role_id"));
		UserService.register(username, password, firstName, lastName, email, roleId);
		//enter actual html file
		return "login.html";
	}


}
