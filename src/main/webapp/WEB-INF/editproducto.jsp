<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

	<div>
		<h2>Editar Producto</h2>
		<form:form action="/producto/update" method="post" modelAttribute="producto">
			<form:hidden path="id"/>
			<form:label path="nombre">Nombre Producto: </form:label>
			<form:input path="nombre" />
			<br>
			<form:label path="descripcion">Desc Producto: </form:label>
			<form:input path="descripcion"  />
				<br>
			<form:label path="precio">Precio Producto: </form:label>
			<form:input path="precio" />
			<br>
			
			<form:label path="categorias">Categoria: </form:label>
			
			<form:select path="categorias">
				<option value="0">Seleccione curso...</option>
				<c:forEach var="categoria" items="${listaCategorias}">
					<option value="<c:out value="${categoria.id}"></c:out>"><c:out value="${categoria.nombre}"></c:out> </option>
				</c:forEach>
			</form:select>
			<input type="submit" value="Modificar">
		</form:form>
		<br>

	</div>
</body>
</html>