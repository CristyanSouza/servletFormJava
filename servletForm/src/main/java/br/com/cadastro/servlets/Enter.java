package br.com.cadastro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastro.action.Action;
import br.com.cadastro.classes.User;


@WebServlet("/enter")
public class Enter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getParameter("action");	

		String ClassName = "br.com.cadastro.action." + action;
		String run;
		
		
		try {
			Class<?> classAction = Class.forName(ClassName);
			Action acaoInstance = (Action) classAction.newInstance();
			run = acaoInstance.run(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		String[] adress = run.split(":");
		

		if(adress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + adress[1]);
			rd.forward(request, response);
		}
		if (adress[0].equals("redirect")){
			response.sendRedirect("enter?action=" + adress[1]);
		}
		
		
	}

}
