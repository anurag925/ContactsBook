<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" import="com.axelor.model.Contact" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>

<div align="center">
	<table border="1">
	  <tr>
		<td>ContactID</td>
		<td>Contact Name</td>
		<td>Contact Number</td>
	 </tr>
	 
	<c:forEach items="${searchList}" var="contact">
		<tr>
			<td>${contact.id}</td>
			<td>${contact.name}</td>
			<td>${contact.number}</td>
		</tr>	
	</c:forEach>	
	</table>
	</div>

</body>
</html>