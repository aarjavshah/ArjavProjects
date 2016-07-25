<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cts.iot.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>Appliance Status</title>
	<link rel="stylesheet" href="style2.css">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	function display_c(){
		var refresh=15000; // Refresh rate in milli seconds
		setTimeout(function submitForm(){
			document.getElementById("mqttpub").submit()
		},refresh)
		}
	</script>
	<!-- <script type="text/javascript">
		$(document).ready(function(){
			$('#button').on('click', function(){
				$(this).toggleClass('on');
			});
		});
	</script> -->
</head>
<body onload="display_c()">
	<%SensorInputVO vo = new SensorInputVO();
	if(session.getAttribute("prevRead")!=null){ 
		vo = (SensorInputVO)session.getAttribute("prevRead"); 	
	}else{
		vo = new SensorInputVO(25,150,2);
	}
	%>
	
		<h1>IOT Inputs</h1>
		<section class="small">
		<form action="GenerateSignal" method="post" name="mqttpub" id="mqttpub">
		<div id="left">
			<h2>Temperature</h2>
			<input type="number" name="temp" min="0" max="60" value="<%=vo.getTemp()%>" style="width: 10em">
		</div><div id="left">
			<h2>Light</h2>
			<input type="number" name="light" min="100" max="600" value="<%=vo.getLight()%>" style="width: 10em">
		</div><div id="left">
			<h2>Motion</h2>
			<input type="number" name="motion" min="1" max="3" value="<%=vo.getMotion()%>" style="width: 10em">
		</div></form>
		</section>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<h1 style="width: 100%">IOT Appliance Status</h1>
	<div id="outer">
	<div id="inner">
	<section >
	<div style="width:33.33%;  float: left;">
		<%if(ReadStatus.GetStatus().isAcStatus()){ %>
		<a href="#" id="button" class="on">&#xF011;</a><%}else{ %>
		
		<a href="#" id="button">&#xF011;</a><%} %>
		<span></span><br>
		<h2 style="	padding-left:15px;">AC</h2></div>
	<div style="width:33.33%; float: left;">
		<%if(ReadStatus.GetStatus().isHeaterStatus()){ %>
		<a href="#" id="button" class="on">&#xF011;</a><%}else{ %>
		
		<a href="#" id="button">&#xF011;</a><%} %>
		<span class="right"></span><br>
		<h2>Heater</h2></div>
	<div style="width: 33.33%; float: left;">
		<%if(ReadStatus.GetStatus().isLightStatus()){ %>
		<a href="#" id="button" class="on">&#xF011;</a><%}else{ %>
		
		<a href="#" id="button">&#xF011;</a><%} %>
		<span class="right2"></span><br>
		<h2 style="	padding-left:10px;">Light</h2></div>
	</section>
	</div></div>
</body>
</html>