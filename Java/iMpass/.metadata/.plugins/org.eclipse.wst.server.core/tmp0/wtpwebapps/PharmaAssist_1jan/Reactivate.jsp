<%@page import="com.cts.pharma.dao.UserDAO"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="<%= request.getContextPath()%>/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

function display_c(){
	var refresh=1000; // Refresh rate in milli seconds
	setTimeout('display_ct()',refresh)
	}

function display_ct() {
	var strcount;
	var x = new Date();
	var hour=x.getHours();

	if(hour>=0 && hour<12)
	document.getElementById('time').innerHTML = hour + ":"+ x.getMinutes() + ":" +x.getSeconds() + " am     ";
	
	else if(hour==12)
		document.getElementById('time').innerHTML = hour + ":"+ x.getMinutes() + ":" +x.getSeconds() + " pm     ";
	else
	document.getElementById('time').innerHTML = (hour-12) + ":"+ x.getMinutes() + ":" +x.getSeconds() + " pm     ";	
	
	document.getElementById('date').innerHTML = x.getDate() + "-"+ (x.getMonth()+1) + "-" +x.getFullYear() ;
	display_c();
	 }
	

function validate()
{
	var ans=document.getElementById("answer").value;
	
	var flag=0;
	
	if(ans.length==0)
		{
		document.getElementById("span_answer").innerHTML="Enter an Answer !";
		flag=1;
		}
	

	if(flag==0)
		{
			return true;
		}	
	else
		{
		return false;
		}
}





</script>
</head>
<body onload=display_ct();>

<div id="wrapper">
	<div id="menu-wrapper">
		
		<table>
		<tr>
		<td>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1><a>Pharma Assist</a></h1>
				
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="login.jsp">Homepage</a></li>
				<li><a href="contact1.jsp">Contact</a></li>
			</ul>
		</div>
		
	
	</td>
	
	</tr>
	</table>
	
	</div>
	
<div id="banner">

<div style="height:75%;" id="out_re1">
<div id="in_re1" style="text-align:=center;">
<table>
<tr>
<td align="center" width="400px">

<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%
if(request.getParameter("login")==null && request.getParameter("reactivate")==null){
	response.sendRedirect("login.jsp");
}
int x=0,flag=0;
if(request.getParameter("reactivate")!=null)
{

x=Integer.parseInt(request.getAttribute("wrong_react").toString());

if(x==1)
{	flag=1;
	out.print("<font color=red> <span style=\"text-align:center;\">Security Answer Mismatch</span></font>");
}
}
if(flag==0){
	out.println("<font color=orange>Answer the security question to reactivate your account.</font>");
}
%>
</table>
</div>
</div>

<div style="height:75%;" id="out_re">
<div id="in_re" style="text-align:=center;">

<br></br>

 <form action=user_reactivation method=post onsubmit="return validate()">
 
 <table align=center>

<tr><td>USERNAME<td><%=request.getParameter("username") %>
<tr><td>SECURITY<br>QUESTION<td><%
UserDAO reactivateUser=new UserDAO();
String question=reactivateUser.GetQuestion(request.getParameter("username"));
out.print(question);
%>
<tr><td>ANSWER<td><input type=text name=secretanswer id="answer" placeholder="Enter Answer">
<td><font color=red><span id="span_answer"></span></font>
<tr>
<td>
<input type=hidden name=username value=<%=request.getParameter("username") %>>
<td><input type=submit name=reactivate value=REACTIVATE>
</table>
</form>

</div>
</div>

</td>

</div>

</div>

</div>

<div id="copyright" class="container">
<div style="height:75%;" id="out_copy">
<div id="in_copy" style="text-align:=center;">
	<table>
	<tr>
	<td>
	&copy;copyright cognizant 2011-2020
	<td>
	<img src="<%= request.getContextPath()%>/profile/cognizant.png" height="50" width="60" alt="Add New Batch"></img>
	<tr>
	<td>
	<span id="time"></span><span id="date"></span>
	</table>
	
</div>
</div>
</div>

</body>
</html>






