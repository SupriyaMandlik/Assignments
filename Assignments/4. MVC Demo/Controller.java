package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.bean.LoginBean;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginBean ref = new LoginBean();

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		req.setAttribute("userName", userName);
		req.setAttribute("password", password);
		req.getRequestDispatcher("View.jsp").forward(req, resp);

	}
}
