<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.testing.TestRun"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@page import="com.cts.dnb.Application2.GetMessageVO"%>
<%@page import="com.cts.dnb.Application2.QueueMessenger"%>
<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read Queue</title>
</head>
<script type="text/javascript">
function getContent(){
	var div_val=document.getElementById("editablediv").innerHTML;
    document.getElementById("formtextarea").value =div_val;
    if(div_val==''){
		return false;
    	//empty form will not be submit. You can also alert this message like this. alert(blahblah);
    	}
	}
function enableChange(){
	document.getElementById("msgNum").removeAttribute("disabled");
}
function disableChange(){
	document.getElementById("msgNum").setAttribute("disabled", true);
}

</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>

<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server
String qName= (String)session.getAttribute("qName") ;
String qmName= (String)session.getAttribute("qmName") ;
int curDepth = QueueMessenger.GetQueueDepth(qmName, qName);
%>
<div id="left">
<h1>Get Message</h1>
</div>
<div id="right"><div id="brokerInfo"><table><tr><td><a href="QueueManagerInfo.jsp">Configuration Details of Queue Managers</a></td></tr></table></div></div>
<div id="right2">
<div id="textbox"><strong>Queue Name         :</strong><%=qName %></div>
<div id="textbox"><strong>Queue-Manager Name :</strong><%=qmName %></div>
<div id="textbox"><strong>Read Messages :</strong> Available Messages are <strong><%=curDepth %></strong></div>
<form action="ReadMessage" method="post">
<div id="textbox"><br></div>
<div id="textbox"><input type="radio" name="GMO" id ="fst" value="First" checked="checked" onchange="disableChange()">First Message</div>
<br><div id="textbox"><input type="radio" name="GMO" id ="mny" value="Multiple" onchange="enableChange()">First <input type="number" id="msgNum" name="msgNum" value=1 min=1 max=<%=curDepth %> disabled="true"> Messages</div>
<br><div id="textbox"><input type="radio" name="GMO" id="all" value="All" onchange="disableChange()">All Messages</div>
<br><div id="textbox"><%if(curDepth>0){ %><input type="submit" name="readMsg" value="Get Messages">
<%}else{ %><input type="submit" name="readMsg" value="Get Messages" disabled="disabled"><%} %></div>
</form>
</div>
</body>
</html>




