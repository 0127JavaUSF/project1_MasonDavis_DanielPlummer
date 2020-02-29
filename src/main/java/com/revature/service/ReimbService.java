package com.revature.service;

/*Daniel Plummer
 * Project_1
 * ReimbService service class
 */

import java.util.List;

import com.revature.dao.ReimbImpl;
import com.revature.model.Reimb;


public class ReimbService {

	public static List<Reimb> getReimbs() {
		return new ReimbImpl().getReimbs();
	}

	public static List<Reimb> getReimbById(int id) {
		return new ReimbImpl().getReimbById(id);
	}

	public static List<Reimb> getReimbByAuthor(Reimb r) {
		return new ReimbImpl().getReimbByAuthor(r);
	}

	public static List<Reimb> getReimbsByStatus(int status) {
		return new ReimbImpl().getReimbsByStatus(status);
	}

	public static List<Reimb> getReimbByResolver(int resolver) {
		return new ReimbImpl().getReimbByResolver(resolver);
	}

	public static boolean createReimb(Reimb r) {
		return new ReimbImpl().createReimb(r);
	}

	public static boolean updateReimb(Reimb r) {
		return new ReimbImpl().updateReimb(r);
	}

	public static boolean deleteReimb(Reimb r) {
		return new ReimbImpl().deleteReimb(r);
	}

	public static boolean approveReimb(int id, int resolver) {
		return new ReimbImpl().approveReimb(id, resolver);
	}

	public static boolean denyReimb(int id, int resolver) {
		return new ReimbImpl().denyReimb(id, resolver);
	}

	public static void submit(double amount, String description, String author, String statusId, String typeId) {
		boolean result = new ReimbImpl().createReimb(new Reimb(amount, description, author, statusId, typeId));

	}
	
	public static List<Reimb> getReimbByUsername(String username) {
		return new ReimbImpl().getReimbByUsername(username);
	}
	
	public static List<Reimb> getReimbsByUserId(int author) {
		return new ReimbImpl().getReimbsByUserId(author);
	}
	
	public static void update(int reimbId, String resolver, String statusId) {
		boolean result = new ReimbImpl().updateReimb(new Reimb(reimbId, resolver, statusId));
	}

}
