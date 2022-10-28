<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link href="/servletForm/css/style.css" rel="stylesheet" type="text/css">
<link href="/servletForm/css/forms.css" rel="stylesheet" type="text/css">


</head>

<body>
	<c:import url="header.jsp"/>	
	<form action="/servletForm/enter?action=AddPerson"  method="post">
	<h1>Cadastro de clientes</h1>
	<div class="inputs-form">
		<label for="name">
		<span>Nome:</span> <input type="text" name="name"/>
		</label>
		<label for="age">
		<span>Idade:</span> <input type="text" name="age"/>
		</label>
		<label for="phone">
		<span>Telefone:</span> <input type="text" name="phone"/>
		</label>
		<label for="email">
		<span>E-mail:</span> <input type="email" name="email"/>
		</label>
	</div>
	
	<input type="submit" class= "button"value="cadastrar"/>
	<a href="/servletForm/enter?action=AllPerson">Pessoas cadastradas</a>
	</form>
</body>
</html>