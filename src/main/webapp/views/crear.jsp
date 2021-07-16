<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Producto</title>
</head>
<body>

<h1>Crear Producto</h1>

<form action="ProductoController" method="post">
<input type="hidden" name="option" value="guardar">
	<table border="1">
		<tr>
			<td>Nombre:</td>
			<td> <input type="text" name="nombreProducto" size="30"></td>
		</tr>
		<tr>
			<td>Cantidad:</td>
			<td> <input type="text" name="cantidadProducto" size="30"></td>
		</tr>
		<tr>
			<td>Precio:</td>
			<td> <input type="text" name="precioProducto" size="30"></td>
		</tr>
	</table>
	
	<button type="submit">Guardar</button>

</form>

</body>
</html>