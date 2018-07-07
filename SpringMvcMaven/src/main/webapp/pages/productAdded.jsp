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
 
 <form action="newProduct.action" method="post">
	    <input type="submit" value="Add new product:">
</form> 
<form action="search.action" method="post">
	Search the product:<br>
	ID:<input type="text" name="idProduct" value="${idProduct}"/>
	   <input type="submit" value="OK">
</form>
	<table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<c:if test="${empty NoAdded}">
			<c:forEach items="${ListProducts}" var="prod">
				<tr>
				<td>${prod.id}</td>
				<td>${prod.name}</td>
				<td>${prod.description}</td>
				<td>${prod.price}</td>
				<td><a href="deleteProd.action?id=${prod.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:out value="${Added}"></c:out>
</body>
</html>