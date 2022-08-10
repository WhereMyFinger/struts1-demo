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
	<html:link action="/home.html">Return to home page</html:link>
	<html:form action="/pro-add-user.html" method="post">
		<br>
	<logic:present name="message">
		<bean:write name="message" />
	</logic:present>
	<br>
		<label>Name</label>
		<html:text property="name" name="userdto"></html:text>
		<label>Age</label>
		<html:text property="age" name="userdto"></html:text>
		<html:submit>Add user</html:submit>
	</html:form>
</div>
</body>
</html>