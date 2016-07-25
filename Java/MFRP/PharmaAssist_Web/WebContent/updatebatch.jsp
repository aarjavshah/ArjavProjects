  <%@ page import="com.cts.pharma.vo.BatchVO" %>
<%@ page import="com.cts.pharma.dao.BatchDAO" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pharma Assist</title>
<link rel="shortcut icon" href="/PharmaAssist/img/rx-logo-hi.ico"></link>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="fonts.css" rel="stylesheet" type="text/css" />
<!--  
 * CSS and Java Script
 * 
 * @version 1
 * @author 454580(Shivang Trivedi)
 * */ -->
<script type="text/javascript">



function validate(){
	
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
	else if(price > 999999)
	{
		document.getElementById("span_price").innerHTML="Price should be a less than 999999";
		flag=1;
	}
	else
		{
		document.getElementById("span_price").innerHTML="";
		
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

function makeDisable(){
	
	document.getElementById("batchcode").disabled = true;
	document.getElementById("medicinecode").disabled = true;
	document.getElementById("select").disabled = true;
	document.getElementById("refregeration1").disabled = true;
	document.getElementById("refregeration2").disabled = true;
	document.getElementById("weight").disabled = true;
	document.getElementById("price").disabled = true;
	document.getElementById("update").disabled = true;
	
}
function makeEnable(){
	
	document.getElementById("batchcode").disabled = false;
	document.getElementById("medicinecode").disabled = false;
	document.getElementById("select").disabled = false;
	document.getElementById("refregeration1").disabled = false;
	document.getElementById("refregeration2").disabled = false;
	document.getElementById("weight").disabled = false;
	document.getElementById("price").disabled = false;
	document.getElementById("update").disabled = false;
	document.getElementById("edit").disabled = true;
	
}

function clean()
{
	document.getElementById("weight").innerHTML="";
	document.getElementById("price").innerHTML="";
	document.getElementById("select").innerHTML="";
	document.getElementById("batchcode").innerHTML="";
}
	
	
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
window.location="searchbatch.jsp";		
}
</script>
</head>

<!--  
 * Login JSP page Business Logic
 * 
 * @version 1
 * @author 454582(Arjav Shah)
 * */ -->

<body onload="display_ct(); makeDisable();">

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
				<li><a href="contact.jsp">Contact</a></li>>
			</ul>
		</div>
		
	
	</td>
	<td>
	<table width="100%">
	<tr>
	<td align="center"><a href="Logout.jsp"><img src="<%= request.getContextPath()%>/img/logout-1.png" height="40" width="40" alt="Add New Batch"></img></a>
	<tr>
	<td align="center"><font color=white>Welcome <%
	if(session.getAttribute("session_username")!=null)
	out.println(session.getAttribute("session_username").toString());%></font>
	</table>
	</td>
	</tr>
	
	</tr>
	</table>
	
	</div>
	
<div id="banner">
<div style="height:75%;" id="out_update">
<div id="in_update" style="text-align:=center;">

<%

response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);
 
if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}  
%>

<%
BatchVO searchedBatchDetails=(BatchVO) request.getAttribute("update");
if(searchedBatchDetails!=null){
//out.print("Welcome"+(String)session.getAttribute("session_username"));
%>
<form action=UpdateBatch method=post onsubmit="return validate()">
<input type=hidden name=previousbatchcode value=<%=request.getAttribute("previous_batchcode") %>>
<table>
<tr>
	<td>BATCH CODE
	<td><input type=text name=batchcode id="batchcode" value=${update.batchcode} placeholder="Enter Batchcode">
	<td><font color=red><span id="span_batch"></span></font></td>
<tr>
	<td>MEDICINE<BR>CODE
	<td><select name=medicinecode id="medicinecode">
<%
String medicine_code[]=new BatchDAO().getMedicineCodes();
for(int i=0;i<medicine_code.length;i++){
	if(medicine_code[i].equals(searchedBatchDetails.getMedicinecode())){
		out.println("<option value="+medicine_code[i]+" selected=selected>"+medicine_code[i]);
	}else{
	out.println("<option value="+medicine_code[i]+">"+medicine_code[i]);} 
}
%>
	</select>
	
<tr>
	<td>WEIGHT
	<td><input type=text name=weight id="weight" value=${update.weight} autocomplete="off" placeholder="Enter Weight (1-1500)">
	<td><font color=red><span id="span_weight"></span></font></td>
<tr>
	<td>PRICE
	<td><input type=text name=price id="price" value=${update.price} autocomplete="off" placeholder="Enter Price">
	<td><font color=red><span id="span_price"></span></font></td>
<tr>
	<td>MEDICINE TYPE
	<td><select name=medicinetype id="select">
	<option value="S">--Select--
	<option value=Tablets ${update.medicinetype == 'T'||update.medicinetype == 't' ? 'selected' : ''}>Tablets
	<option value=Capsule ${update.medicinetype == 'C'|| update.medicinetype == 'c'? 'selected' : ''}>Capsule
	<option value=Syrup ${update.medicinetype == 'S'||update.medicinetype == 's' ? 'selected' : ''}>Syrup
	</select>
	<td><font color=red><span id="span_select"></span></font></td>
<tr>
	<td>REFRIGERATION
	<td><input type=radio name=refregeration value=Yes id="refregeration1"<%if(searchedBatchDetails.getRefregeration().equalsIgnoreCase("yes")){out.print("checked=checked");} %>>YES
		<input type=radio name=refregeration value=No id="refregeration2"<%if(searchedBatchDetails.getRefregeration().equalsIgnoreCase("no")){out.print("checked=checked");} %>>NO

</table>
<table>
<tr>
	<td width=100px><input type=button name=cancel value=CANCEL onclick="reDirect()">
	<td width=100px><input type=button name=edit value=EDIT id="edit"  onclick="makeEnable()">
	<td width=100px><input type=submit name=update value=UPDATE id="update">
</tr>
</table>

</form>

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
<%} %>
</body>
</html>







