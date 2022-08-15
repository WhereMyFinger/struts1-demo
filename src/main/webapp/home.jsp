<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<title>Home page</title>
</head>
<body>
<div class="container">
	
	<%
	String email = (String)session.getAttribute("email");
	if (email != null) {
		out.print("Hello " + email);
	}
	%>
	
	<h1><html:link action="/logout">Logout</html:link></h1>
	<button class="btn btn-primary" onclick="document.location='/struts1-demo/add-user.html'">Add user</button>
	<table class="table" border="1" cellpadding="2" cellspacing="2">
		<tr>
			<div class="col-span-2">
				<th >User name</th>
			</div>	
			<div class="col-span-2">
				<th >Age</th>
			</div>
			<div class="col-span-2">
				<th >Email</th>
			</div>
		</tr>
		<logic:iterate name="userList" id="user">
			<tr>
				<div class="col-span-2">
					<td><bean:write name="user" property="name"/></td>
				</div>
				<div class="col-span-2">
					<td><bean:write name="user" property="age" format="####"/></td>
				</div>
				<div class="col-span-2">
					<td><bean:write name="user" property="email"/></td>
				</div>
				<%-- <td>
					<html:link action="/edit-product.html" paramName="listId" paramId="idProd" paramProperty="id">Edit</html:link> | <html:link action="/delete-product.html" paramName="listId" paramId="idProd" paramProperty="id" onclick="return confirm('Are you sure?')">Delete</html:link> 
				</td> --%>
			</tr>
		</logic:iterate>
	</table>
</div>
</body>
</html>