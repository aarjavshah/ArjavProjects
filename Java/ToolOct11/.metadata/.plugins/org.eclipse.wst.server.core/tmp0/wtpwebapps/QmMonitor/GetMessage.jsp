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
<title>Browse Queue</title>
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
%>
<div id="left">
<h1>Browse Message</h1>
</div>
<div id="right"><div id="brokerInfo"><table><tr><td><a href="QueueManagerInfo.jsp">Configuration Details of Queue Managers</a></td></tr></table></div></div>
<div id="right2">
<div id="textbox"><strong>Queue Name         :</strong><%=(String)session.getAttribute("qName") %></div>
<div id="textbox"><strong>Queue-Manager Name :</strong><%=(String)session.getAttribute("qmName") %></div>
<div id="textbox"><strong>Reading First Message :</strong></div>
<%GetMessageVO dsp = QueueMessenger.SeparateHeader(QueueMessenger.BrowseMessage((String)session.getAttribute("qmName"), (String)session.getAttribute("qName"))); %>
<textarea name="inMsg" id="formtextarea"rows="10" cols="50" disabled><%=StringEscapeUtils.escapeHtml4(dsp.getHeader())%></textarea>
<textarea name="inMsg" id="formtextarea"rows="10" cols="80" disabled><%=StringEscapeUtils.escapeHtml4(dsp.getData())%></textarea>
</div>
</body>
</html>




