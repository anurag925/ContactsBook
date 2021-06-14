<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" import="com.axelor.model.Contact" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
</head>
<body>
hey

<div align="center">
	<form action="contact/edit?id=<%= request.getParameter("id") %>" method="post">
	<table>
			<tr>
			<td>Enter Name : </td>
			<td><input type="text" name="name" id="name" required></td>
			</tr>
			<tr>
			<td>Enter Number : </td>
			<td><input type="text" name="number" id="number" required></td>
			</tr>	
			<tr>
			<td><input type="submit" value="Save"></td>
			</tr>	
		</table>	
	</form>
	
	</div>


</body>
</html>