package com.revature.dao;

/*Daniel Plummer
 * Project-One
 * UserImpl
 */

/* Implements the user DAO and allows processing
 * of input from user to stored and updated.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;


public class UserImpl implements UserDao {

	private static Logger log = Logger.getRootLogger();

	public List<User> getUsers() {
		List<User> ul = new ArrayList<>();
		String sql = "select * from users";

		try {
			Connection conn = ConnectionUtil.connect();

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				ul.add(new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("email"), rs.getInt("roleId")));
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return ul;
	}

	public User getUserById(int id) {
		String sql = "select * from users where \"userId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return (new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public User getUserByUsername(String username) {
		String sql = "select * from users where username = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return (new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public boolean createUser(User u) {
		String sql = "insert into users (username, password, \"firstName\", \"lastName\", email, \"roleId\") values (?,?,?,?,?,?)";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRoleId());

			return ps.execute();

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean updateUser(User u) {
		String sql = "update users set username = ?, password = ?, \"firstName\" = ?, \"lastName\" = ? where \"userId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setInt(5, u.getUserId());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return false;
	}

	public boolean deleteUser(User u) {
		String sql= "delete from users where username = ?";
		
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			log.info(e.getMessage());
		}
		return false;
	}
	
	public boolean validateLogin(String username, String password) {

		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "{ ? = call validate (?,?) }";
			CallableStatement cs = conn.prepareCall(sql);

			cs.registerOutParameter(1, Types.BOOLEAN);
			cs.setString(2, username);
			cs.setString(3, password);
			
			cs.execute();

			boolean result = cs.getBoolean(1);
			cs.close();
			conn.close();
			return result;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean validateUsername(String username) {
		String sql = "select * from users where username = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return false;
	}

}
