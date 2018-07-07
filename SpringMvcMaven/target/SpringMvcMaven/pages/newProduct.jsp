<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Example</title>
</head>
<body>	
<h2>Spring MVC Example</h2>

Add new product:<br>
<form action="addProduct.action" method="post" name="product">
	<table border="0" width="25">
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description"/></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price"/></td>
		</tr>
		<tr><td><input type="submit" value="Add Product"/></td></tr>
	</table>
</form>
</body>
</html>