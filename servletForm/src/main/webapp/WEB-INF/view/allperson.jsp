<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import = "java.util.ArrayList, br.com.cadastro.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="/servletForm/css/style.css" rel="stylesheet" type="text/css">
<link href="/servletForm/css/allperson.css" rel="stylesheet" type="text/css">


<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
<c:import url="header.jsp"/>	
<ul>
	<c:forEach items="${person}" var="p">
		<li> <a class="person" href="enter?action=ShowPerson&id=${p.id}">${p.name} </a> 
	</c:forEach>
</ul>
<a class="button" href="enter?action=NewPerson">Novo cadastro</a>
<a class="button button-removed" href="enter?action=AllRemovedPerson">Pessoas removidas</a>

</body>
</html>