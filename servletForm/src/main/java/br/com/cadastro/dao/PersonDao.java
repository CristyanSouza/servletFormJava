package br.com.cadastro.dao;

import javax.persistence.EntityManager;

import br.com.cadastro.template.Person;
import br.com.cadastro.template.Teste;

public class PersonDao {

	private EntityManager em;

	public PersonDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void addPerson(Person person) {
		person = this.em.merge(person);
		this.em.persist(person);
	}
	

}
