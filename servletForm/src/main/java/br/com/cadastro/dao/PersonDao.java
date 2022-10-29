package br.com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.template.Person;

public class PersonDao {

	private EntityManager em;

	public PersonDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void addPerson(Person person) {
		person = this.em.merge(person);
		this.em.persist(person);
	}
	
	public List<Person> allPerson() {
		String jpql = "SELECT p FROM person p WHERE p.removedPerson = 0";
		return em.createQuery(jpql, Person.class).getResultList();
	}
	
	public List<Person> allRemovedPerson() {
		String jpql = "SELECT p FROM person p WHERE p.removedPerson = 1";
		return em.createQuery(jpql, Person.class).getResultList();
	}


	public Person selectId(Integer id) {
		String jpql = "SELECT p FROM person p WHERE p.id = :id";
		return em.createQuery(jpql, Person.class).setParameter("id", id).getSingleResult();
	}


	public void update(Person person) {	
		person = em.merge(person);
		this.em.persist(person);
	}
	

}
