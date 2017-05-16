<%@page import="com.cts.dnb.Application1.UserAuth"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test AdminLogin</title>
</head>
<body>
<h1>This is Test Page</h1>
<br><br>
<h3>Test1</h3>
<%out.println(UserAuth.AuthenticateAdmin("454582", "admin123")); %>
<br>
<br>
<h3>Test2</h3>
<%out.println(UserAuth.AuthenticateAdmin("admin", "start123")); %>

</body>
</html>