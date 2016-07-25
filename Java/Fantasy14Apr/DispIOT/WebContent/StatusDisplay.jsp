<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cts.iot.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>Appliance Status</title>
	<meta http-equiv="refresh" content="10" >
	<link rel="stylesheet" href="style2.css">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!-- <script type="text/javascript">
		$(document).ready(function(){
			$('#button').on('click', function(){
				$(this).toggleClass('on');
			});
		});
	</script> -->
</head>
<body>
	<h1>IOT Appliance Status</h1>
	<section>
		<%if(ReadStatus.GetStatus().isAcStatus()){ %>
		<a href="#" id="button" class="on">&#xF011;</a><%}else{ %>
		
		<a href="#" id="button">&#xF011;</a><%} %>
		<span></span><br>
		<h2>AC</h2>
	</section>
	<section>
		<%if(ReadStatus.GetStatus().isHeaterStatus()){ %>
		<a href="#" id="button" class="on">&#xF011;</a><%}else{ %>
		
		<a href="#" id="button">&#xF011;</a><%} %>
		<span></span><br>
		<h2>Heater</h2>
	</section>
</body>
</html>