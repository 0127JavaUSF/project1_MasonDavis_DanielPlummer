package com.revature.driver;

/*Daniel Plummer
 * Project_1
 * Driver
 */

import java.sql.Connection;

import com.revature.dao.ReimbImpl;
import com.revature.service.ReimbService;
import com.revature.util.ConnectionUtil;

//Connection Driver
public class Driver {

	public static void main(String[] args) {
		Connection conn = ConnectionUtil.connect();
		System.out.println(ReimbService.getReimbs());
		
		ReimbImpl r = new ReimbImpl();
		
		r.getReimbsByUserId(10);
		
	}
}
