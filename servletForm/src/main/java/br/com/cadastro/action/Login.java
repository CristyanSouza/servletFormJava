package br.com.cadastro.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastro.dao.UserDao;
import br.com.cadastro.template.User;
import br.com.cadastro.util.JPAUtil;


public class Login implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		User user = dao.authenticate(login, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "forward:form.jsp";	
		}
		return "redirect:LoginForm";
		
}
}
