package com.revature.servlets;


/*Daniel Plummer
 * Project_1
 * DataServlet servlets class
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.RequestHelper;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"*.json"})

public class DataServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		RequestHelper.directProcess(req, resp);
	}

}