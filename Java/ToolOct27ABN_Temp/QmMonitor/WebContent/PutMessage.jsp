<%@page import="com.cts.dnb.Application2.QueueBrowser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Put Message</title>
</head>
<script type="text/javascript">
function getContent(){
	var div_val=document.getElementById("msgXML").innerHTML;
    document.getElementById("formtextarea").value =div_val;
    if(div_val==''){
		return false;
    	//empty form will not be submit. You can also alert this message like this. alert(blahblah);
    	}
	}
function changeMulti(){
	window.location="PutMessages.jsp";
}	
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<%
if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
%>
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Messaging Utility</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>

<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>
<div id="left">
<h1>Put Message</h1>
</div>
<div id="right"><div id="brokerInfo"><table><tr><td><a href="QueueManagerInfo.jsp">Configuration Details of Queue Managers</a></td></tr></table></div></div>
<div id="right2">
<div id="textbox"><strong>Queue Name         :</strong><%=(String)session.getAttribute("qName") %></div>
<div id="textbox"><strong>Queue-Manager Name :</strong><%=(String)session.getAttribute("qmName") %></div>
<input type="radio" name="single" id="changeID" value="single" checked="checked" >Single Message
<input type="radio" name="single" id="changeMul" value="single" onchange="changeMulti()">Multiple Messages<br><br>
<!-- <div class="scroll" id="msgXML" contenteditable="true"></div> -->
<form id="form" action="PutMessage" method="post"><!-- onsubmit="return getContent()"> style="display:none"-->
ReplyTo queue Name : <input type="text" name="replyTo"><br>
    <textarea name="inMsg" id="formtextarea" style="width:600px;height:250px;"></textarea><BR><BR>
<input type="file" id="fileinput"/>
<input type="submit" name="Put Message"/>
</form></div>
<script type="text/javascript">
  
  function readSingleFile(evt) {
    //Retrieve the first (and only!) File from the FileList object
    var f = evt.target.files[0]; 

    if (f) {
      var r = new FileReader();
      r.onload = function(e) { 
	      var contents = e.target.result;
	     // document.getElementById("msgXML").innerHTML = contents;
	      document.getElementById("formtextarea").innerHTML = contents;
      }
      r.readAsText(f);
    } else { 
      alert("Failed to load file");
    }
  }
  
  document.getElementById('fileinput').addEventListener('change', readSingleFile, false);
  
  
</script> 
</body>
</html>




