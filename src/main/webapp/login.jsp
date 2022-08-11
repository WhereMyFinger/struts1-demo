<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<!-- <link rel="stylesheet" type="text/css" href="@{/webjars/bootstrap/4.2.1/css/bootstrap.min.css}"/> -->
  	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
    <title>Login</title>
</head>
<body>
    <div class="container">
        <div>
            <div>
                <h3 class="text-center">Login page</h3>
            </div>
        </div>

       	<form action="/struts1-demo/process-login.html" method="post">
       	<fieldset>
            <div class="form-group">
                <label for="email">Email address:</label>
                <br>
                <input type="email" class="form-control" name="email">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <br>
                <input type="password" class="form-control" name="password">
            </div>
			<br>
			<logic:present name="message">
				<bean:write name="message" />
			</logic:present>
			<br>
            <div style="text-align:center">
                <input type="submit" class="btn btn-default" value="login"/>
            </div>
        </form>
        <!-- <div>
            <div style="text-align:center">
                <a href="/HomeJobMarketplace/visitor/register">Register</a> &nbsp;&nbsp;&nbsp
                <a href="/HomeJobMarketplace/visitor/reset-password">Reset Password</a>
            </div>
        </div> -->
    </div>
    </fieldset>
</body>
</html>