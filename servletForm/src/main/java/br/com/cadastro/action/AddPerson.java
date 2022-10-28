package br.com.cadastro.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.dao.PersonDao;
import br.com.cadastro.template.Db;
import br.com.cadastro.template.Person;
import br.com.cadastro.template.Teste;
import br.com.cadastro.util.JPAUtil;


public class AddPerson implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email= request.getParameter("email");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		PersonDao dao = new PersonDao(em);
		em.getTransaction().begin();
		dao.addPerson(new Person(name, age, phone, email));
		em.getTransaction().commit();

		
		return "redirect:AllPerson";

}
}
