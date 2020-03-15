package com.cts.training;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter("/RequestHandlerServlet")
public class SecondFilter implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("from init of SecondFilter");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userName = request.getParameter("un");
		if (request.getParameter("pwd").equals("123")) {
			response.getWriter().write("<h1>Welcome " + userName + "</h1>");
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("<h1>Invalid Password</h1>");
		}

	}

	@Override
	public void destroy() {
		System.out.println("from destroy of SecondFilter");

	}
}
