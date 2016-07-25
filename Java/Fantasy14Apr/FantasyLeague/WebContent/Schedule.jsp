<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule</title>
</head>
<body>
<img src="<%=request.getContextPath() %>/logos/GL.jpg" height="100" width="100" alt="team1"></img> vs <img src="<%=request.getContextPath() %>/logos/RPS.jpg" height="80" width="100" alt="team2"></img> 
<form action="PredictRedirect" method="post">
<input type="hidden" name="team1" value="GL">
<input type="hidden" name="team2" value="RPS">
<input type="submit" name="Predict" value="Predict">
</form>

</body>
</html>