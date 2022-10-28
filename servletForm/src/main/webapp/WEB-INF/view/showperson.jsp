<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/servletForm/css/style.css" rel="stylesheet" type="text/css">
<link href="/servletForm/css/forms.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"/>	

	
	<form action="/servletForm/enter?action=AlterPerson"  method="post">
	<h1>Cliente: ${person.name}</h1>
	<div class="inputs-form">
	<label for="name">
	<span>Nome:</span> <input type="text" name="name" value="${person.name}"/>
	</label>
	<label for="age">
	<span>Idade:</span> <input type="text" name="age" value="${person.age}"/>
	</label>
	<label for="phone">
	<span>Telefone:</span> <input type="text" name="phone" value="${person.phone}"/>
	</label>
	<label for="email">
	<span>E-mail:</span> <input type="email" name="email" value="${person.email}"/>
	</label>
	</div>
	<input type="hidden" name="id" value="${person.id}"/>
	<input class="button" type="submit" value="Salvar"/> 
	<a class="button button-removed" href="enter?action=RemovePerson&id=${person.id}">Remover</a>
	</form>
</body>
</html>