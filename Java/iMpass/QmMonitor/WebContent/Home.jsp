<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}
%>
<div id="outer">
<div id="header2"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  iMPAS : IBM Messaging Platform Access Simplified</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="left">
<table id="formTable1" align="center"><tr><td>
<a href="QueueBrowser.jsp">Check the queue Properties</a>
</td></tr><tr><td>
<a href="ChannelBrowser.jsp">Monitor Channel Status</a>
</td></tr><tr><td>
<a href="TopicBrowser.jsp">Check Topic Properties</a>
</td></tr><tr><td>
<a href="Welcome.jsp">Monitor the broker application status</a>
</td></tr>
</table>
</div>
</body>
</html>