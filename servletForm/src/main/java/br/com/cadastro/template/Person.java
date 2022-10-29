package br.com.cadastro.template;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "person")
public class Person {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String age;
	private String phone;
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "removed_by")
	private User removed_by = null;
	private int removedPerson = 0;
	private LocalDate date_remove = null;

	
	
	public Person() {
	}
	
	
	public Person (String name, String age, String phone, String email) {
		
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getId() {
		return this.id;
	}


	public int getRemovedPerson() {
		return removedPerson;
	}


	public void setRemovedPerson(int removedPerson) {
		this.removedPerson = removedPerson;
	}


	public LocalDate getDate_remove() {
		return date_remove;
	}


	public void setDate_remove(LocalDate localDate) {
		this.date_remove = localDate;
	}

	public User getRemoved_by() {
		return removed_by;
	}
	
	public void setRemoved_by(User removed_by) {
		this.removed_by = removed_by;
	}
	
	
}
