package br.com.cadastro.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.dao.UserDao;
import br.com.cadastro.template.User;
import br.com.cadastro.util.JPAUtil;


public class AddUser implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		
		em.getTransaction().begin();
		dao.addUser(new User(name, login, password));
		em.getTransaction().commit();
		return "redirect:LoginForm";

}
}
