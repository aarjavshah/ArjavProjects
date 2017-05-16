<%@ page import="com.cts.pharma.dao.BatchDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
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
	var weight=document.getElementById("weight").value;
	var price=document.getElementById("price").value;
	var select=document.getElementById("select").value;
	var batchcode=document.getElementById("batchcode").value;
	
	var flag=0;
	
	if(batchcode.length==0)
	{	document.getElementById("span_batch").innerHTML="Enter Batchcode";
		flag=1;
	}
	
	else if(batchcode.length<8 || batchcode.length>16)
	{	document.getElementById("span_batch").innerHTML="Batchcode length must be between 8-16 characters";
		flag=1;
	}
	
	else
	{	document.getElementById("span_batch").innerHTML="";
		//flag=0;
	}	
	if(weight.length==0)
	{	document.getElementById("span_weight").innerHTML="Enter Weight";
		flag=1;
	}

	else if(isNaN(weight))
	{
		document.getElementById("span_weight").innerHTML="Weight should be a Number";
		flag=1;
	}
	else if(weight<=0 || weight>1500)
		{
		document.getElementById("span_weight").innerHTML="Enter weight between 1-1500";
		flag=1;
		}
	else
		{
		document.getElementById("span_weight").innerHTML="";
		}
	
	if(price.length==0)
	{	document.getElementById("span_price").innerHTML="Enter Price";
		flag=1;
	}
	
	else if(isNaN(price))
	{
		document.getElementById("span_price").innerHTML="Price should be a Number";
		flag=1;
	}
	
	else if(price<=0)
	{
		document.getElementById("span_price").innerHTML="Price should be a greater than Zero";
		flag=1;
	}
	else
		{
		document.getElementById("span_price").innerHTML="";
		//flag=0;
		}
	
	if(select=="S")
	{
		document.getElementById("span_select").innerHTML="Select an Option";
		flag=1;
	}	
	else
		{
		document.getElementById("span_select").innerHTML="";
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
	document.getElementById("span_batch").innerHTML="";
	document.getElementById("span_weight").innerHTML="";
	document.getElementById("span_price").innerHTML="";
	document.getElementById("span_select").innerHTML="";
			
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


function reDirect()
{
window.location="welcome.jsp";		
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
				<li class="current_page_item"><a href="welcome.jsp">Welcome Page</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		
	
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
	
<div id="banner">
<div style="height:75%;" id="out_add">
<div id="in_add" style="text-align:=center;">

<% response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  
%>

<%
if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}//out.print("Welcome"+(String)session.getAttribute("session_username")); %>
<Form action="AddNewBatch" method="post" onsubmit="return validate()">
<table>
<tr><td height=30px>BATCH CODE<sup><font color=red>*</font></sup><td><input type=text name=batchcode id="batchcode" placeholder="Enter Batchcode"><td><font color=red><span id="span_batch"></span></font></td>
<tr><td height=30px>MEDICINE<sup><font color=red>*</font></sup><BR>CODE<td><select name=medicinecode>
<%
String medicine_code[]=new BatchDAO().getMedicineCodes();
for(int i=0;i<medicine_code.length;i++){
	out.println("<option value="+medicine_code[i]+">"+medicine_code[i]); 
}
%>
</select>
<tr><td height=30px>WEIGHT<sup><font color=red>*</font></sup><td><input type=text name=weight id="weight" placeholder="Enter Weight (1-1500)"><td><font color=red><span id="span_weight"></span></font></td>
<tr><td height=30px>PRICE<sup><font color=red>*</font></sup><td><input type=text name=price id="price" placeholder="Enter Price"><td><font color=red><span id="span_price"></span></font></td>
<tr><td height=30px>MEDICINE TYPE<sup><font color=red>*</font></sup><td ><select name=medicinetype id="select">
<option value="S" >--Select--
<option value=Tablets>Tablets
<option value=Capsule>Capsule
<option value=Syrup>Syrup
</select> <td><font color=red><span id="span_select"></span></font></td>
<tr><td height=30px>REFREGERATION<td><input type=radio name=refregeration value=Yes>YES<input type=radio name=refregeration value=No checked=checked>NO
</table>

<br>
<table >
<tr>
<td width=100px><input type=button name=cancl value=CANCEL onclick="reDirect()">
<td width=100px><input type=reset name=clear value=CLEAR onclick="clean();">
<td width=100px><input type=submit name=add value=ADD>
</tr>
</table>
</br>
</Form>
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







