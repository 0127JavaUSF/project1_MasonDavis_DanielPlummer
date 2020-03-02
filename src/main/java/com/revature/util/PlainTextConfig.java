package com.revature.util;


/*Daniel Plummer
 * Project_1
 * PlainTextConfig util class
 */

public class PlainTextConfig {
	private static final String url = "jdbc:postgresql://db-200117.ccidsggiz04l.us-east-2.rds.amazonaws.com:5432/Project11";
	private static final String username = "";
	private static final String password = "";

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

}
