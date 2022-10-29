package br.com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.cadastro.template.User;

public class UserDao {

	private EntityManager em;

	public UserDao(EntityManager em) {
		this.em = em;
	}

	public void addUser(User user) {
		this.em.persist(user);
		
	}
	
	
	public  User authenticate (String login, String password) {
		String jpql = "SELECT u FROM user u";
		List <User> users = this.em.createQuery(jpql, User.class).getResultList();
		
		
		for (User u : users) {
			if(u.isEqual(login, password)) {
				return u;
			}
		};
		return null;
	}

}
