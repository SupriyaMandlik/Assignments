package com.cts.training;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter("/RequestHandlerServlet")
public class FirstFilter implements Filter {

	public FirstFilter() {

	}

	public void destroy() {
		System.out.println("from destroy of FirstFilter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userName = request.getParameter("un");
		String userNameInUpperCase = userName.toUpperCase();
		if(userName.equals(userNameInUpperCase)) {
			
			chain.doFilter(request, response);
		}else {
			response.getWriter().write("<h1>Please write user name in upper case only</h1>");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("from init of FirstFilter");
	}

}
