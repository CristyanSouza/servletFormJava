package br.com.cadastro.action;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastro.dao.PersonDao;
import br.com.cadastro.template.Person;
import br.com.cadastro.template.User;
import br.com.cadastro.util.JPAUtil;


public class RemovePerson implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		Integer id = Integer.valueOf(stringId);
		HttpSession session = request.getSession();		
		EntityManager em = JPAUtil.getEntityManager();
		PersonDao dao = new PersonDao(em);
		Person person = dao.selectId(id);
		person.setRemovedPerson(1);
		person.setDate_remove(LocalDate.now());
		person.setRemoved_by((User) session.getAttribute("user"));

		
		em.getTransaction().begin();
		dao.update(person);
		em.getTransaction().commit();
		
		return "redirect:AllPerson";
		
		
	}

}
