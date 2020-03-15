package com.cts.training;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connection
 */


public class ConnectionServlet extends HttpServlet {
	String user, password, url, driver;
	Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		user = config.getInitParameter("userName");
		password = config.getInitParameter("password");
		url = config.getInitParameter("url");
		driver = config.getInitParameter("driver");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn + " from connection servlet 1");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equals("GET")) {
			doGet(req, resp);
		} else {
			doPost(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		String emp_name = req.getParameter("name");
		String dept_id = req.getParameter("dept_id");
		String emp_salary = req.getParameter("salary");

		String insert_query = "insert into employee(name,dept_id,salary) values(?,?,?)";

		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(insert_query);
			ps.setString(1, emp_name);
			ps.setString(2, dept_id);
			ps.setString(3, emp_salary);

			int insert_result = ps.executeUpdate();
			if (insert_result > 0) {
				pw.write("<h1>Employee details saved succesfully</h1>");
			} else {
				pw.write("<h1>Something went wrong</h1>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
