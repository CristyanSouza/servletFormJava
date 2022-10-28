package br.com.cadastro.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastro.template.Db;
import br.com.cadastro.template.Person;


public class AllPerson implements Action{

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		List<Person> person = Db.getAll();
		
		request.setAttribute("person", person);
		
		return "forward:allperson.jsp";

	}

}
