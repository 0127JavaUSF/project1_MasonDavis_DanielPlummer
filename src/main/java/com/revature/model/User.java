package com.revature.model;

/*Daniel Plummer
 * Project_1
 * User model class
 */

/* Creates all attributes for user*/
public class User {

	private int userId, roleId;
	private String username, password, firstName, lastName, email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(int userId, String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	

}
