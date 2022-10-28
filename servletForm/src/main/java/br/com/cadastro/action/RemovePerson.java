package br.com.cadastro.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastro.classes.Db;


public class RemovePerson implements Action {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		Integer id = Integer.valueOf(stringId);
				
		Db.remove(id);
		
		return "redirect:AllPerson";
		
		
	}

}
