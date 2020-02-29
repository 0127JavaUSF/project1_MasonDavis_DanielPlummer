package com.revature.controller;

/*Daniel Plummer
 * Project_11
 */
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserImpl;
import com.revature.model.User;

public class UserController {
	
	private static Logger log = Logger.getRootLogger();

	public UserController() {
		super();
	}
	
	public static String getAllUsers() {
		UserDao ui = new UserImpl();
		ObjectMapper om =  new ObjectMapper();
		
		List<User> user = ui.getUsers();
		String users = "";
		
		try {
			users = om.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		
		return "{\"users\":" + users + "}";
	}
	
	public static String getUsersByUsername(String username) {
		UserDao ui = new UserImpl();
		ObjectMapper om =  new ObjectMapper();
		
		User u = ui.getUserByUsername(username);
		
		String user = "";
		
		try {
			user = om.writeValueAsString(u);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		
		return "{\"user\":" + user + "}";
	}

}

