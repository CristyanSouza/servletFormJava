package br.com.cadastro.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.dao.PersonDao;
import br.com.cadastro.template.Person;
import br.com.cadastro.util.JPAUtil;


public class ShowPerson implements Action{

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		Integer id = Integer.valueOf(stringId);
		
		EntityManager em = JPAUtil.getEntityManager();
		PersonDao dao = new PersonDao(em);
		Person selectedPerson = dao.selectId(id);
		
		request.setAttribute("person", selectedPerson);
		return "forward:showperson.jsp";
	}

}
