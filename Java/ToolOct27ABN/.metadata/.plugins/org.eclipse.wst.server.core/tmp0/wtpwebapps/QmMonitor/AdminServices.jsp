<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<script type="text/javascript">
function confimation(){
	return confirm("This Will Start an automated update cycle!\nAre you sure?");
}
</script>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Home.jsp");
	}
	
}	%>
<div id="outer">
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<div id="ErrS2">
<table id="formTable2"><tr><td>
<ol class="tree1">
	<li>
		<label for="Broker Operation"> Broker Operation</label><input type="checkbox" id="Broker Operation">
		<ol>
			<li class="file"><a class="admin" href="AddBroker.jsp">Add a new Broker</a></li>
			<li class="file"><a class="admin" href="RemoveBroker.jsp">Remove an existing Broker</a></li>
			<li class="file"><a class="admin" href="BrokerList.jsp">See the existing broker List</a></li>
			<li class="file"><a class="admin" href="<%=request.getContextPath()%>/BrokerUpdate" onclick="return confimation()">Update Application status</a></li>
		</ol>
	</li>
</ol>
</td></tr><tr><td>
<ol class="tree1">
	<li>
		<label for="Queue-Manager Operation"> Queue-Manager Operation</label><input type="checkbox" id="Queue-Manager Operation">
		<ol>
			<li class="file"><a class="admin" href="AddQManager.jsp">Add a new Queue-Manager</a></li>
			<li class="file"><a class="admin" href="<%=request.getContextPath()%>/QMSetup" onclick="return confimation()">Update All available Queue-Managers</a></li>
			
		</ol>
	</li>
</ol>
</td></tr><tr><td>
<ol class="tree1">
	<li>
		<label for="User-Access Operation"> User-Access Operation</label><input type="checkbox" id="User-Access Operation">
		<ol>
			<li class="file"><a class="admin" href="AddUser.jsp">Add a new User</a></li>
			<li class="file"><a class="admin" href="RemoveUser.jsp">Remove an existing User</a></li>
			<li class="file"><a class="admin" href="UserList.jsp">See the existing User List</a></li>
		</ol>
	</li>
</ol>
</td></tr><tr><td><div class="conf">
<a href="ConfigureProperties.jsp">Configure Properties</a></div></td></tr>
<tr><td><div class="conf">
<a href="TrackRequest.jsp">Track Request</a></div></td></tr>
<tr><td><div class="conf">
<a href="Home.jsp">User Home Page</a></div></td></tr>
</table>
</div>
</body>
</html>