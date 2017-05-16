<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>

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
	
	if(pass.length==0)
		document.getElementById("span_pass").innerHTML="Password is Compulsory";
	
	else if(pass.length < 8)
		document.getElementById("span_pass").innerHTML="Password is Length less than 8 !";
	
	else if(pass.length >16)
		document.getElementById("span_pass").innerHTML="Password Length exceeds 16 !";
	 
	if(name.length==0)
		document.getElementById("span_name").innerHTML="Username is Compulsory";

	
		
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
		document.getElementById("about").innerHTML="You can learn more here................!!!!!:-)";
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
<body onload="display_ct();">

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
				<li class="current_page_item"><a href="welcome.jsp">Welcome Page</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		
	
	</td>
	
	
	<td>
	<table width="100%">
	<tr>
	<td align="center"><a href="Logout.jsp"><img src="https://lh5.googleusercontent.com/-XvU0uyh6lyA/VKI2I2CukkI/AAAAAAAAA9s/vaBQsJQYM-Y/w448-h512-no/logout-1-512.png" height="50" width="50" ></img></a>
	<tr>
	<td align="center"><font color=white>Logout</font>
	</table>
	</td>
	</tr>
	
	</table>
	
	</div>
	
<div class="banner" id="banner">
<div class="image">
</div>
<div style="height:75%;" id="out_wel">
<div id="in_wel" style="text-align:=center;">
<a href="login.jsp">
<img src="D:\\image.png" height="100" width="100" ></img>
</a>

</div>
</div>
</div>

</div>

</div>

<div id="copyright" class="container">
<div style="height:75%;" id="out_copy">
<div id="in_copy" style="text-align:=center;">
	<p>&copy;copyright cognizant 2011-2020
	<br><span id="time"></span><span id="date"></span></br>
	</p>
</div>
</div>
</div>

</body>
</html>




