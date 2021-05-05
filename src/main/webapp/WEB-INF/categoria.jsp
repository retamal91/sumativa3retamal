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
        <a class="nav-link" href="/">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/categoria">Administrar Categorias</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="/producto">Administrar Productos</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="/producto/busqueda">Buscar Productos</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="/carrito">Ver Carrito</a>
      </li>

	
    </ul>
	</div>
	</nav>
	
  </div>


	<div>
	<h2>Crear Categoria</h2>
	<form action="/categoria/insertar" method="post">
		<label for="nombre">Nombre Categoria: </label>
		<input type="text" name="nombre" id="nombre">
		<input type="submit" value="agregar categoria">
	</form>
	
	<h2>Listado Categorias</h2>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
       <th scope="col">Eliminar</th>
       <th scope="col">Editar</th>
 
 
    </tr>
  </thead>
  <tbody>

  <c:forEach var = "categoria" items="${listadoCategorias}"> 
    <tr>
		<td>${categoria.id}</td>
		<td>${categoria.nombre}</td>
		<td><a href="http://localhost:8080/categoria/eliminar/${categoria.id}"><button type="button"  class="btn btn-primary">Eliminar</button></a>
		</td>
		<td><form action="/categoria/editar/${categoria.id}">
		<input type="text" placeholder="Ingresar nuevo nombre" id="newcat" name="newcat">
		<button type="submit" class="btn btn-primary">Editar</button>		
		</form>
		
		
		</td>
		
         
 </tr>
</c:forEach>

  </tbody>
</table>
	</div>
</body>
</html>