package com.revature.dao;

/*Daniel Plummer
 * Project_1
 * UserDao
 */


/* Gives access to user Data Access Objects
 * 
 */
import java.util.List;

import com.revature.model.User;


public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public User getUserByUsername(String username);
	//public List<User> getUserByResolver(int id);
	
	public boolean createUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUser(User u);
	
	public boolean validateLogin(String username, String password);
	public boolean validateUsername(String username);
	

}
