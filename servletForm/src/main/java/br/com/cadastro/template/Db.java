package br.com.cadastro.template;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Db {
	static List<Person> db = new ArrayList<>();
	static Integer pk = 1;
	static List<User> users = new ArrayList<>();
	static List<RemovedPerson> removedPerson = new ArrayList<>();

	
	
	public static void addPerson(Person p){
		db.add(p);
		pk++;
	}
	
	public static void addUser(User u){
		users.add(u);
	}	
	
	

	public static List<Person> getAll() {
		return db;
	}

	public static Person select(Integer id) {
		Iterator <Person> ip = db.iterator();
		
		while (ip.hasNext()) {
			Person person = ip.next();
			
			if (person.getId() == id) {
				return person;
			}
		}
		return null;
	}

	public static void remove(Integer id) {
		Iterator <Person> ip = db.iterator();
		
		while (ip.hasNext()) {
			Person person = ip.next();
			
			if (person.getId() == id) {
				ip.remove();
			}
		}
	}
	
	public static void addRemoved(RemovedPerson rp) {
		removedPerson.add(rp);
	}
	
	
	public static User authenticate (String login, String password) {
		for (User u : users) {
			if(u.isEqual(login, password)) {
				return u;
			}
		};
		return null;
	}

	public static List<RemovedPerson> getAllRemovedPerson() {
		return removedPerson;
	}
	
	
	
}
