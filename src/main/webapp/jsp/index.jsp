<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" import="com.axelor.model.Contact" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contactbook</title>
<style>
	table
		{
			border-collapse:collapse;
		}
	td
	{
		padding: 5px;
	}
	th
	{
		padding: 10px;
	}
</style>
</head>
<body>

	<div align="center">
	<h2 align="center">Enter Contact Details</h2>
	<form action="" method="post">
		<table align="center">
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
	<br/>
	<label>${creationResult}</label>
	<br/>
	</div>
	<br/>
	<div align="center">
	<form action="contact/search" method="get" >
		Enter name : <input type="text" name="name"><br/>
					<input type="submit" value="search">
	</form>
	</div>
	<br/>
	<table border="1" align="center">
	  <tr>
		<td>ContactID</td>
		<td>Contact Name</td>
		<td>Contact Number</td>
		<td colspan="2" align="center">Action</td>
	 </tr>
	 
	<c:forEach items="${contactList}" var="contact">
		<tr>
			<td>${contact.id}</td>
			<td>${contact.name}</td>
			<td>${contact.number}</td>
			<td><a href="/ContactsBook/jsp/contact/display/${contact.id}"><input type="button" value="Edit"></a></td>
			<td><a href="/ContactsBook/jsp/contact/delete/${contact.id}"><input type="button" Value="Delete"></a></td>
		</tr>	
	</c:forEach>	
	</table>	
</body>
</html>