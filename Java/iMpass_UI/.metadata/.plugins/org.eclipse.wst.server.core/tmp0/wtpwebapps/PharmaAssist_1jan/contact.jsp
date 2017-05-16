<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : GrassyGreen 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140310

-->
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
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
				<h1><a href="#">Pharma Assist</a></h1>
				
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li ><a href="welcome.jsp">Welcome Page</a></li>
				<li class="current_page_item"><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		<!-- end #menu --> 
	
	</td>
	<td>
	<table width="100%">
	<tr>
	<td align="center"><a href="Logout.jsp"><img src="<%= request.getContextPath()%>/img/logout-1.png" height="40" width="40" alt="Add New Batch"></img></a>
	<tr>
	<td align="center"><font color=white>Logout</font>
	</table>
	</td>
	</tr>
	
	</tr>
	</table>
	
	</div>
	
	<div id="banner" align=center>
	
	<div style="height:15%;" id="out_contact">
	<div id="in_contact" style="text-align:=center;">
	<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>
	<table align=center>
	
	<tr>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Arjav Shah</b></td></tr>
				<tr><td align=center>454582</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center>ArjavDhirendra.Shah</td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Dev gaba</b></td></tr>
				<tr><td align=center>454591</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center>Dev.Gaba</td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Fenil Tailor</b></td></tr>
				<tr><td align=center>454579</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center>FenilShaileshkumar.Tailor</td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Shivang Trivedi</b></td></tr>
				<tr><td align=center>4545980</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center>ShivangSanjay.Trivedi</td></tr>
			</table>
	</td>
	
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Somasri Kar</b></td></tr>
				<tr><td align=center>455185</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center>SOMASRI.KAR</td></tr>
			</table>
	</td>
	</tr>
	
	</table>
	
		
	</div>
	</div>
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
