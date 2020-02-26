package com.revature.servlets;

/*Daniel Plummer
 * Project_1
 * SubmitServlet servlets class
 */


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.RequestHelper;

@WebServlet(urlPatterns = {"*.submit"})
public class SubmitServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(RequestHelper.reimbProcess(req)).forward(req, resp);
	}

}
