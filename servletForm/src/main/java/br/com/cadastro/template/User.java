package br.com.cadastro.template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String login;
	
	public User () {}
	
	public User(String name, String login, String password) {
		this.login = login;
		this.password = password;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String senha) {
		this.password = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
    public boolean isEqual(String login, String password) {
        if(!this.login.equals(login)) {
            return false;
        }

        if(!this.password.equals(password)) {
            return false;
        }

        return true;
    }

}
