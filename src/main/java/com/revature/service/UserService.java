package com.revature.service;

/*Daniel Plummer
 * Project_1
 * UserService service class
 */

import java.util.List;

import com.revature.dao.UserImpl;
import com.revature.model.User;

public class UserService {

	public static void submit(String username, String password, String firstName, String lastName, String email,
			int roleId) {
		new UserImpl().createUser(new User(0, username, password, firstName, lastName, email, roleId));
	}
	
	public static void register(String username, String password, String firstName, String lastName, String email, int roleId) {
		new UserImpl().createUser(new User(0, username, password, firstName, lastName, email, roleId));
	}

	public static List<User> getUsers() {
		return new UserImpl().getUsers();
	}

	public static User getUserById(int id) {
		return new UserImpl().getUserById(id);
	}

	public static User getUserByUsername(String username) {
		return new UserImpl().getUserByUsername(username);
	}

	public static boolean createUser(User u) {
		return new UserImpl().createUser(u);
	}

	public static boolean updateUser(User u) {
		return new UserImpl().updateUser(u);
	}

	public static boolean deleteUser(User u) {
		return new UserImpl().deleteUser(u);
	}

	public static boolean validateLogin(String username, String password) {
		return new UserImpl().validateLogin(username, password);
	}

	public static boolean validateUsername(String username) {
		return new UserImpl().validateUsername(username);
	}

}
