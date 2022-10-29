package br.com.cadastro.action;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.dao.PersonDao;
import br.com.cadastro.template.Person;
import br.com.cadastro.util.JPAUtil;


public class AllRemovedPerson implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		PersonDao dao = new PersonDao(em);
		List<Person> removedPerson = dao.allRemovedPerson();
		
		request.setAttribute("removedPerson", removedPerson);
		
		return "forward:removedperson.jsp";
		
		
	}

}
