<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
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


</script>
</head>
<!--  
 * Contact1 JSP page
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
				<h1><a href="#">Pharma Assist</a></h1>
				
			</div>
		</div>
	</div>
	</td>
		<td>
		<div id="menu" class="container">
			<ul>
				<li ><a href="login.jsp">Homepage</a></li>
				<li class="current_page_item"><a href="welcome.jsp">Contact</a></li>
			</ul>
		</div>
		<!-- end #menu --> 
	
	</td>
	
	</tr>
	
	</tr>
	</table>
	
	</div>
	
	<div id="banner" >
	
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
				<tr><td align=center><abbr title="ArjavDhirendra.Shah@cognizant.com">ArjavDhirendra.Shah</abbr></td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Dev gaba</b></td></tr>
				<tr><td align=center>454591</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center><abbr title="Dev.Gaba@cognizant.com">Dev.Gaba</abbr></td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Fenil Tailor</b></td></tr>
				<tr><td align=center>454579</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center><abbr title="FenilShaileshkumar.Tailor@cognizant.com">FenilShaileshkumar.Tailor</abbr></td></tr>
			</table>
	</td>
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Shivang Trivedi</b></td></tr>
				<tr><td align=center>4545980</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center><abbr title="ShivangSanjay.Trivedi@cognizant.com">ShivangSanjay.Trivedi</abbr></td></tr>
			</table>
	</td>
	
	
	<td>
			<table width="150px">
				<tr><td align=center><b>Somasri Kar</b></td></tr>
				<tr><td align=center>455185</td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td align=center><img src="<%= request.getContextPath()%>/img/mail.jpg" height="15" width="20" alt="Mail"></img></td></tr>
				<tr><td align=center><abbr title="SOMASRI.KAR@cognizant.com">SOMASRI.KAR</abbr></td></tr>
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
