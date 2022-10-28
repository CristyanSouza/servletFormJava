package br.com.cadastro.template;


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
	
	private int removedPerson = 0;
	private Date date_remove = new Date();

	
	
	public Person() {
	}
	
	
	public Person (String name, String age, String phone, String email) {
		
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.id = Db.pk;
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


	
	
}
