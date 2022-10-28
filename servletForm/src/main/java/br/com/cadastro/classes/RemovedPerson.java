package br.com.cadastro.classes;

public class RemovedPerson {

	private Person person;
	private User user;
	
	public RemovedPerson(Person person, User user) {
		this.person = person;
		this.user = user;
	}

	public Person getPerson() {
		return person;
	}

	public User getUser() {
		return user;
	}
	
	
	
	
	
}
