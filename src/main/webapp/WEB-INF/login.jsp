<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
<div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Pagina de Compra</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/index">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/categoria">Administrar Categorias</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="/producto/1">Administrar Productos</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="/producto/busqueda">Buscar Productos</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="/carrito">Ver Carrito</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>
       </li class="align-item-right">
                  <li class="nav-item">
        <a class="nav-link" href="/registro">Registro</a>
	
    </ul>
	</div>
	</nav>
	
  </div>
	<form action="/persona/login" method="post">
			<label for="email">Email: </label>
			<input type="text" name="email" id="email">
			<br>
			<label for="password">Password: </label>
			<input type="text" name="password" id="password">
			<br>
			<input type="submit" value="Login">
	</form>
	
	<!-- 
	<form action="/login/guardar" method="post">
			<label for="email">Email: </label>
			<input type="text" name="email" id="email">
			<br>
			<label for="password">Password: </label>
			<input type="text" name="password" id="password">
			<br>
			<input type="submit" value="guardar">
	</form>
	<br>
	<form action="/login/login" method="post">
			<label for="email">Email: </label>
			<input type="text" name="email" id="email">
			<br>
			<label for="password">Password: </label>
			<input type="text" name="password" id="password">
			<br>
			<input type="submit" value="Login">
	</form>
	 -->
	<c:out value="${mensaje}"></c:out>
	</div>
</body>
</html>