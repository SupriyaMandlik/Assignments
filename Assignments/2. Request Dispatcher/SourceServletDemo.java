package com.cts.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SourceServletDemo")
public class SourceServletDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		System.out.println("from doGet of SourceServlet");
		String custName = req.getParameter("customerName");
		int term = Integer.parseInt(req.getParameter("term"));
		int premium = Integer.parseInt(req.getParameter("premium"));

		// adding data to request object
		req.setAttribute("CustomerName", custName);
		req.setAttribute("noOfYears", term);
		req.setAttribute("ammount", premium);

		// System.out.println("You paid : " + (premium * term));
		pw.write("<h1>You paid : " + (premium * term) + "<h1>");
		
		//resp.sendRedirect("http://localhost:8080/Welcome_Project/EmployeeForm.html");
		//resp.sendRedirect("/TargetServlet");
		
		req.getRequestDispatcher("/TargetServlet").forward(req, resp);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/TargetServlet");
//		dispatcher.include(req, resp);

	}
}
