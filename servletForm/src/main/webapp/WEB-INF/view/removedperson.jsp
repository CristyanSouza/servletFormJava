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
	<c:forEach items="${removedPerson}" var="rp">
		<li> ${rp.person.name} - Removido pelo usuário: ${rp.user.name}
	</c:forEach>
</ul>

<a href="enter?action=AllPerson" class="button">Voltar</a>
</body>
</html>