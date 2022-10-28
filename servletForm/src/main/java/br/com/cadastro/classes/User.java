package br.com.cadastro.classes;

public class User {
	private String name;
	private String password;
	private String login;
	
	public User(String name, String login, String password) {
		this.login = login;
		this.password = password;
		this.name = name;
	}

	public String getName() {
		return name;
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
