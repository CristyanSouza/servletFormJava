package br.com.cadastro.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.classes.Db;
import br.com.cadastro.classes.Person;
import br.com.cadastro.classes.User;


public class AddUser implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Db.addUser(new User(name, login, password));
		
		return "redirect:LoginForm";

}
}
