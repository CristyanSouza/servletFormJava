package br.com.cadastro.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.dao.PersonDao;
import br.com.cadastro.template.Person;
import br.com.cadastro.util.JPAUtil;


public class AlterPerson implements Action{

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email= request.getParameter("email");
		String stringId = request.getParameter("id");
		Integer id = Integer.valueOf(stringId);
		
		EntityManager em = JPAUtil.getEntityManager();
		PersonDao dao = new PersonDao(em);
		Person person = dao.selectId(id);
		person.setName(name);
		person.setAge(age);
		person.setPhone(phone);
		person.setEmail(email);
		
		em.getTransaction().begin();
		dao.update(person);
		em.getTransaction().commit();
		return "redirect:AllPerson";
	}

}
