<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar producto</title>
</head>
<body>

<h1>Editar producto</h1>

<form action="ProductoController" method="post">
<c:set var="producto" value="${producto}"></c:set>
<input type="hidden" name="option" value="editar">
<input type="hidden" name="idEditar" value="${producto.id}">
	<table border="1">
		<tr>
			<td>Nombre:</td>
			<td> <input type="text" name="nombreProductoE" size="30" value="${producto.nombre}"></td>
		</tr>
		<tr>
			<td>Cantidad:</td>
			<td> <input type="text" name="cantidadProductoE" size="30" value="${producto.cantidad}"></td>
		</tr>
		<tr>
			<td>Precio:</td>
			<td> <input type="text" name="precioProductoE" size="30" value="${producto.precio}"></td>
		</tr>
	</table>
	
	<button type="submit">Guardar</button>

</form>

</body>
</html>