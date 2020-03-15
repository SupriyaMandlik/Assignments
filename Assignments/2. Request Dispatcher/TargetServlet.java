package com.cts.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();

		System.out.println("from doGet of TargetServlet");

		System.out.println("Customer Name : " + req.getAttribute("CustomerName"));
		System.out.println("No of Years : " + req.getAttribute("noOfYears"));
		System.out.println("Premium ammount : " + req.getAttribute("ammount"));

		String name = (String) req.getAttribute("CustomerName");
		Integer term = (Integer) req.getAttribute("noOfYears");
		Integer ammount = (Integer) req.getAttribute("ammount");

		double sumAssured = (ammount * term) + (ammount * term) * 20 / 100;

		pw.write("<h1>Customer Name : " + name + "<h1>");
		pw.write("<h1>No of Years : " + term + "<h1>");
		pw.write("<h1>Premium ammount : " + ammount + "<h1>");
		pw.write("<h1>Ammount after maturity : " + sumAssured + "<h1>");

//		System.out.println("Customer Name : " + name);
//		System.out.println("No of Years : " + term);
//		System.out.println("Premium ammount : " + ammount);
//		System.out.println("Ammount after maturity : " + sumAssured);
	}
}
