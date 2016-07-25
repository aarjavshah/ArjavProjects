<%@page import="com.cts.pharma.dao.UserDAO"%>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="<%= request.getContextPath()%>/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
<!--  
 * CSS and Java Script
 * 
 * @version 1
 * @author 455185(Somasri Kar)
 * */ -->
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
	var pass1=document.getElementById("password1").value;
	var pass2=document.getElementById("password2").value;
	var flag=0;
	
	clean();
	if(pass1.length==0)
		{
		document.getElementById("span_mismatch1").innerHTML="Password is Compulsory";
		flag=1;
		}
	else if(pass1.length < 8)
		{
		document.getElementById("span_mismatch1").innerHTML="Password is Length less than 8 !";
		flag=1;
		}
	else if(pass1.length >16)
		{
		document.getElementById("span_mismatch1").innerHTML="Password Length exceeds 16 !";
		flag=1;
		}
	 
	if(pass1!=pass2)
		{
		document.getElementById("span_mismatch2").innerHTML="Password should match";
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



function clean()
{
		document.getElementById("span_mismatch1").innerHTML="";
		document.getElementById("span_mismatch2").innerHTML="";
		
		
}

</script>




</head>

<!--  
 * Contact JSP page
 * 
 * @version 1
 * @author 454591(Dev Gaba)
 * */ -->
 
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
<%if(request.getAttribute("wrongUser")!=null){
	if(request.getAttribute("wrongUser").toString().equals("x")){
		out.print("<font color=red> <span style=\"text-align:center;\">User Does not exist.Try again!</span></font>");
	}
}
	%>

</table>
</div>
</div>

<div style="height:75%;" id="out_re">
<div id="in_re" style="text-align:=center;">

<br></br>

 <form action="Reactivate.jsp" method=post id="myform">
 
<!-- <label for="username">Required, minimum length 8, maximum length 26: </label> -->


 <table align=center style="width:150%">
<tr><td>Username<td><input class="left" type=text name="username"  id="username" placeholder="Enter username"></input>

</table>
<table align=center style="width:150%">
<tr><td><input type=submit name=forgotPassword value="FORGOT PASSWORD"></input>
</table>
</form>

</div>
</div>

</div>

</div>


<div id="copyright" class="container">
<div id="out_copy">
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






