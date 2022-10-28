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

import br.com.cadastro.template.Db;
import br.com.cadastro.template.Person;
import br.com.cadastro.template.RemovedPerson;
import br.com.cadastro.template.User;


@WebFilter("/enter")
public class RemovePersonAudith extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response =	(HttpServletResponse) servletResponse;	
		String action = request.getParameter("action");
		if(action.equals("RemovePerson")) {
			HttpSession session = request.getSession();
			String idString = request.getParameter("id");
			Integer id = Integer.valueOf(idString);
			User user = (User) session.getAttribute("user");
			Person person = Db.select(id);
			
			
			Db.addRemoved(new RemovedPerson(person, user));
		}

		chain.doFilter(request, response);
	}


}
