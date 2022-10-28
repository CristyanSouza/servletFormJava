package br.com.cadastro.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.classes.Db;
import br.com.cadastro.classes.Person;
import br.com.cadastro.classes.RemovedPerson;


public class AllRemovedPerson implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<RemovedPerson> removedPerson = Db.getAllRemovedPerson();
		
		request.setAttribute("removedPerson", removedPerson);
		
		return "forward:removedperson.jsp";
		
		
	}

}
