package br.com.cadastro.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastro.classes.Db;
import br.com.cadastro.classes.Person;
import br.com.cadastro.classes.User;


public class Login implements Action {
	
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = Db.authenticate(login, password);
		
		

		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "forward:form.jsp";	
		}
		return "redirect:LoginForm";
		
}
}
