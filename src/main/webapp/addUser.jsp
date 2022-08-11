<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%
	String email = (String)session.getAttribute("email");
	if (email == null) {
		response.sendRedirect("/struts1-demo/login.html"); 
	}
	else {
		out.print("Hello " + email); 
	}
	%>
	
	<button class="btn btn-primary" onclick="document.location='/struts1-demo/home.html'">Return to home page</button>
	<html:form action="/pro-add-user.html" method="post">
		<br>
		<logic:present name="message">
			<bean:write name="message" />
		</logic:present>
		<br>
		<div class="form-group">
    		<label for="name">Name:</label>
    		<input type="text" name="name" class="form-control">
 	 	</div>
  		<div class="form-group">
    		<label for="age">Age:</label>
   			<input type="text" name="age" class="form-control">
  		</div>
  		<div class="form-group">
    		<label for="email">Email:</label>
   			<input type="text" name="email" class="form-control">
  		</div>
  		<div class="form-group">
    		<label for="password">Password:</label>
   			<input type="password" name="password" class="form-control">
  		</div>
		<%-- <html:submit>Add user</html:submit> --%>
		<button type="submit" class="btn btn-primary">Add user</button>
	</html:form>
</div>
</body>
</html>