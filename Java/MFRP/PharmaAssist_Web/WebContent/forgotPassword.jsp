<%@page import="com.cts.pharma.dao.UserDAO"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

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
 * @author 454580(Shivang Trivedi)
 * */ -->
<script type="text/javascript">

function display_c(){
	var refresh=1000; // Refresh rate in milli seconds
	setTimeout('display_ct()',refresh);
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
		//document.getElementById("span_mismatch1").innerHTML="Password is Compulsory";
		flag=1;
		}
	else if(pass1.length < 8)
		{
		//document.getElementById("span_mismatch1").innerHTML="Password is Length less than 8 !";
		flag=1;
		}
	else if(pass1.length >16)
		{
		//document.getElementById("span_mismatch1").innerHTML="Password Length exceeds 16 !";
		flag=1;
		}
	 
	if(pass1!=pass2)
		{
		//document.getElementById("span_mismatch2").innerHTML="Password should match";
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




function chk(){
	
	var pass1=document.getElementById("password1").value;
	var len=0;
	
	if(pass1.length==0)
		{
		len=6;
		set(len);
		}
	else if(pass1.length<8)
		{
		len=1;
		set(len);
		}
	else if(pass1.length>=8 && pass1.length<=10)
		{
		len=2;
		set(len);
		}
	else if(pass1.length>10 && pass1.length<=14)
		{
		len=3;
		set(len);
		}
	else if(pass1.length>14 && pass1.length<=16)
	{
		
		len=4;
		set(len);
	}
		else{
		len=5;
		set(len);
		
		}
		
	}

function set(len){
	
	
	if(len==1)
		{
	document.getElementById("span_mismatch1").innerHTML="Too Short !";
	document.getElementById("span_mismatch12").innerHTML="";
	document.getElementById("span_mismatch13").innerHTML="";
	document.getElementById("span_mismatch2").innerHTML="";
		}
	else if(len==2)
	{	document.getElementById("span_mismatch1").innerHTML="Weak";
	document.getElementById("span_mismatch12").innerHTML="";
	document.getElementById("span_mismatch13").innerHTML="";
	document.getElementById("span_mismatch2").innerHTML="";
	
	}
	
	else if(len==3)
	{	document.getElementById("span_mismatch12").innerHTML="Moderate";
	document.getElementById("span_mismatch1").innerHTML="";
	document.getElementById("span_mismatch13").innerHTML="";
	document.getElementById("span_mismatch2").innerHTML="";
	}
	
	else if(len==4)
		{document.getElementById("span_mismatch13").innerHTML="Strong";
		document.getElementById("span_mismatch12").innerHTML="";
		document.getElementById("span_mismatch1").innerHTML="";
		document.getElementById("span_mismatch2").innerHTML="";
		}
	
	else if(len==5)
		{document.getElementById("span_mismatch1").innerHTML="Out of Bound";
		document.getElementById("span_mismatch12").innerHTML="";
		document.getElementById("span_mismatch13").innerHTML="";
		document.getElementById("span_mismatch2").innerHTML="";
		}
	
	if(len==6)
	{
document.getElementById("span_mismatch1").innerHTML="Cannot be Empty !";
document.getElementById("span_mismatch12").innerHTML="";
document.getElementById("span_mismatch13").innerHTML="";
document.getElementById("span_mismatch2").innerHTML="";
	}
	
	var pass1=document.getElementById("password1").value;
	var pass2=document.getElementById("password2").value;
	
	if(pass2.length==0)
		{
		document.getElementById("span_mismatch2").innerHTML="Cannot be Empty !";
		document.getElementById("span_mismatch21").innerHTML="";
		}
	else if(pass2.length>=8 && pass2.length<=16)
	{
		if(pass1==pass2){
		document.getElementById("span_mismatch21").innerHTML="Match !";
		document.getElementById("span_mismatch2").innerHTML="";
		document.getElementById("span_mismatch13").innerHTML="Match !";
		document.getElementById("span_mismatch1").innerHTML="";
		document.getElementById("span_mismatch12").innerHTML="";
		}
		else
			{
			document.getElementById("span_mismatch2").innerHTML="Mismatch !";
			document.getElementById("span_mismatch21").innerHTML="";
			}
	}
	
	var refresh=50; // Refresh rate in milli seconds
	setTimeout('chk()',refresh);
}

</script>


<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script>
jQuery.validator.setDefaults({
	  debug: true,
	  success: "valid"
	});


	$( "#myform" ).validate({
	  rules: {
	    field: {
	      required: true,
	      rangelength: [8, 16]
	    }
	  }
	});

</script>

</head>

<!--  
 * Contact JSP page
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */ -->

<body onload="display_ct(),chk();">

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
				<li class="current_page_item"><a href="forgotPassword.jsp">Password Page</a></li>
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
<%! String username=""; %>
<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%

int x=0,flag=0;
//String username="";
if(request.getParameter("passwordChange")!=null)
{
	//SXZystem.out.print("wefdefwe");
	username=(String)request.getAttribute("reset");
	out.print("<font color=red> <span style=\"text-align:center;\">Password Reset Failed</span></font>");
}
else if(request.getParameter("reactivate")!=null){
	username=request.getAttribute("username_react").toString();
}
else{
	response.sendRedirect("login.jsp");
}
%>
</table>
</div>
</div>

<div style="height:75%;" id="out_re">
<div id="in_re" style="text-align:=center;">

<br></br>

 <form action=PasswordReset method=post onsubmit="return validate();" id="myform">
 
<!--  <label for="field">Required, minimum length 8, maximum length 16: </label> -->
 
 <table align=center style="width:150%">
 <input type=hidden name=username1 value=<%=username%>>
<tr><td>Username<td><%=username %>
 <!-- <tr><td>Username
 <td>-->
<tr><td>New Password<td><input type="password" id="password1" size=33% name="passwordNew" placeholder="Enter New Password (8-16 Characters)"></input>
<td><font color=red><span id="span_mismatch1"></span></font>
<font color=orange><span id="span_mismatch12"></span></font>
<font color=green><span id="span_mismatch13"></span></font>
<tr><td>Confirm Password<td><input type="password" id="password2" size=33% placeholder="Confirm Password"></input>
<td><font color=red><span id="span_mismatch2"></span></font>
<font color=green><span id="span_mismatch21"></span></font>
<tr><td>
<td><input type=submit name=passwordChange value="RESET PASSWORD">
</table>
</form>

</div>
</div>

</td>

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






