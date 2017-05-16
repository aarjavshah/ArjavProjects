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
	var name=document.getElementById("username").value;
	var pass=document.getElementById("password").value;
	var flag=0;
	
	if(pass.length==0)
		{
		document.getElementById("span_pass").innerHTML="Password is Compulsory";
		flag=1;
		}
	else if(pass.length < 8)
		{
		document.getElementById("span_pass").innerHTML="Password is Length less than 8 !";
		flag=1;
		}
	else if(pass.length >16)
		{
		document.getElementById("span_pass").innerHTML="Password Length exceeds 16 !";
		flag=1;
		}
	 
	if(name.length==0)
		{
		document.getElementById("span_name").innerHTML="Username is Compulsory";
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
		document.getElementById("span_name").innerHTML="";
		document.getElementById("span_pass").innerHTML="";
		document.getElementById("username").value="";
		document.getElementById("password").value="";
		
}

function load()
{
		document.getElementById("about").innerHTML=
			" India’s leading online healthcare Pharma Assistant brings you a wide assortment of Over the Counter medicines online."+
			" You can search for medicine by name or by batch_no."+
			" Brands like Cipla, Bremed, Glaxo, Acti Patch and Ayush Medica are featured here at cost-effective prices."+
			" It gives you a faster service."+
			" It is user-friendly";
		document.getElementById("open").innerHTML="";		
		document.getElementById("close").innerHTML="...hide";
		
}

function unload()
{
		document.getElementById("about").innerHTML="";
		document.getElementById("open").innerHTML="...learn more";		
		document.getElementById("close").innerHTML="";
		
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

<table style="height:75%;">

<td>
<div id="define">
<p >Pharma Assist is an MFRP designed for Cognizant.<span id="about"></span>
<br style="text-align:justify;"><a href="javascript:load()" id="open">...learn more</a>
<a href="javascript:unload()" id="close"></a>
</br>
</p>
</div>
</td>

<td>

<div style="height:75%;" id="out_index">
<div id="in_index" style="text-align:=center;">

<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%
if(request.getParameter("login")!=null||request.getParameter("reactivate")!=null)
{
int x=0;
x=Integer.parseInt(request.getAttribute("wrong").toString());

if(x==1){
	out.print("<font color=red><span style=\"text-align:center;\">Invalid Userid or Passoword</span></font>");
}
else if(x==2){
	out.print("<font color=green> <span style=\"text-align:center;\">Account Reactivated!Login in with your credentials.</span></font>");
}
else if(x==3){
	out.print("<font color=orange> <span style=\"text-align:center;\">Last attempt remaining before deactivation.</span></font>");
}
}
%>
<form action=UserLogin method=post onsubmit="return validate();">



<table align=center>
<tr>
<td>
<table align=center style="width:150%">
<tr><th><i>USERNAME<sup><font color=red>*</font></sup></i></th><td><input type=text name=username id="username" size=28% placeholder="Enter Username"></td><td width="50%"><font color=red><span id="span_name"></span></font></td></tr>
<tr><th><i>PASSWORD<sup><font color=red>*</font></sup></i></th><td><input type=password name=password id="password" size=28% placeholder="Enter Password (8-16 Characters)"></td><td width="50%""><font color=red><span id="span_pass"></span></font></td></tr>
</table>
<table>
<tr>
<td width="92px"><input type="submit" name="login" value="LOGIN" ></td>
<td ><input type="reset" name="reset" value="RESET" onclick="clean()" ></td>
</tr>
</table>
</td>

</tr>
</table>


</form>
</div>
</div>

</td>
</table>
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


