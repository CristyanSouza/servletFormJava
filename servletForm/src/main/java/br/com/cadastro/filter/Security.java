package br.com.cadastro.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/enter")
public class Security extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response =	(HttpServletResponse) servletResponse;	
		
		String action = request.getParameter("action");	
		HttpSession session = request.getSession();
		boolean privateAction = !(action.equals("LoginForm") || action.equals("Login") || action.equals("AddUser"));
		boolean invalidUser = (session.getAttribute("user") == null);
		
		if(invalidUser && privateAction) {
			response.sendRedirect("enter?action=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}


}
