package com.revature.dao;

/*Daniel Plummer
 * Project_1
 * Reimb Dao
 */

import java.util.List;

import com.revature.model.Reimb;

/* Creates access to reimbursement
 * Data Access Object
 */
public interface ReimbDao {
	
	public List<Reimb> getReimbs();
	public List<Reimb> getReimbById(int id);
	public List<Reimb> getReimbByAuthor(Reimb r);
	public List<Reimb> getReimbByUsername(String username);
	public List<Reimb> getReimbsByStatus(int status);
	public List<Reimb> getReimbByResolver(int resolver);

	public boolean createReimb(Reimb r);
	public boolean updateReimb(Reimb r);
	public boolean deleteReimb(Reimb r);
	
	public boolean approveReimb(int id, int resolver);
	public boolean denyReimb(int id, int resolver);

}
