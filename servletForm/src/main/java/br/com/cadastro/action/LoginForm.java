package br.com.cadastro.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.classes.Db;
import br.com.cadastro.classes.Person;


public class LoginForm implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "forward:loginForm.html";

}
}
