package br.com.cadastro.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.template.Db;
import br.com.cadastro.template.Person;


public class ShowPerson implements Action{

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		Integer id = Integer.valueOf(stringId);
		
		Person selectedPerson = Db.select(id);
		
		request.setAttribute("person", selectedPerson);
		return "forward:showperson.jsp";
	}

}
