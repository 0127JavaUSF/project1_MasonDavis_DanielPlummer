package com.revature.dao;

/*Daniel Plummer
 * Project_1
 * ReimbImplDao
 */


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimb;
import com.revature.util.ConnectionUtil;


public class ReimbImpl implements ReimbDao {

	private static Logger log = Logger.getRootLogger();

	public List<Reimb> getReimbs() {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement";

		try {
			Connection conn = ConnectionUtil.connect();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public List<Reimb> getReimbById(int id) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where \"reimbId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static int stringToInt(String word) {
		switch (word) {
		case "LODGING":
			return 1;
		case "TRAVEL":
			return 2;
		case "FOOD":
			return 3;
		case "OTHER":
			return 4;
		case "pending":
			return 1;
		case "approved":
			return 2;
		case "denied":
			return 3;
		default:
			return 0;
		}
	}

	public List<Reimb> getReimbByAuthor(Reimb r) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where author = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, new UserImpl().getUserByUsername(r.getAuthor()).getUserId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public List<Reimb> getReimbsByUserId(int author) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where author = ?";

		try {

			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, author);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));

			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public List<Reimb> getReimbsByStatus(int status) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where \"statusId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, status);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public List<Reimb> getReimbByResolver(int resolver) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where resolver = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, resolver);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return null;
	}

	public boolean createReimb(Reimb r) {
		String sql = "insert into reimbursement (amount, submitted, description, author, \"statusId\", \"typeId\") values (?, 'now', ?, ?, ?, ?)";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, r.getAmount());
//			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setString(2, r.getDescription());
			ps.setInt(3, new UserImpl().getUserByUsername(r.getAuthor()).getUserId());
			ps.setInt(4, stringToInt(r.getStatusId()));
//			System.out.println(stringToInt(r.getTypeId()));
			ps.setInt(5, stringToInt(r.getTypeId()));
			ps.execute();

			return true;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean updateReimb(Reimb r) {
		String sql = "update reimbursement set resolved='now', \"statusId\" = ?, \"resolver\" = ? where \"reimbId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, stringToInt(r.getStatusId()));
			ps.setInt(2, Integer.parseInt(r.getResolver()));
			ps.setInt(3, r.getReimbId());

			System.out.println("This has been hit.");
			ps.executeUpdate();


			return true;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}
	
	public boolean update(Reimb r) {
		String sql = "update reimbursement set resolved='now', \"statusId\" = ?, \"resolver\" = ? where \"reimbId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, stringToInt(r.getStatusId()));
			ps.setInt(2, Integer.parseInt(r.getResolver()));
			ps.setInt(3, r.getReimbId());

			System.out.println("This has been hit.");
			ps.executeUpdate();


			return true;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean deleteReimb(Reimb r) {
//		String sql = "delete from reimbursement where \"reimbId = ?";
//
//		try {
//			Connection conn = ConnectionUtil.connect();
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setString(1, r.getStatusId());
//			ps.setString(2, r.getResolver());
//			ps.setInt(3, r.getReimbId());
//
//			ps.executeUpdate();
//
//			return true;
//
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		}
		return false;
	}

	@Override
	public boolean approveReimb(int id, int resolver) {
		String sql = "update reimbursement set resolver = ?, resolved = ?, \"statusId = ?\" where \"reimbId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, resolver);
			ps.setDate(2, Date.valueOf(LocalDate.now()));
			ps.setInt(3, 2);
			ps.setInt(4, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean denyReimb(int id, int resolver) {
		String sql = "update reimbursement set resolver = ?, resolved = ?, \"statusId\" = ? where \"reimbId\" = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, resolver);
			ps.setDate(2, Date.valueOf(LocalDate.now()));
			ps.setInt(3, 3);
			ps.setInt(4, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Reimb> getReimbByUsername(String username) {
		List<Reimb> rl = new ArrayList<>();
		String sql = "select * from reimbursement where author = ?";

		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				rl.add(new Reimb(rs.getInt("reimbId"), rs.getDouble("amount"), rs.getString("submitted"),
						rs.getString("resolved"), rs.getString("description"), rs.getString("author"),
						rs.getString("resolver"), rs.getString("statusId"), rs.getString("typeId")));
			}
			return rl;

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return null;
	}

}
