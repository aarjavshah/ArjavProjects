<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" content="5;url=<%=session.getAttribute("reDirTo")!=null?session.getAttribute("reDirTo").toString():(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" )%>">
<title>Success</title>
<script type="text/javascript">
(function () {
    var timeLeft = 5,
        cinterval;

    var timeDec = function (){
        timeLeft--;
        document.getElementById('time').innerHTML = "\nYou will be Redirected in "+timeLeft+" seconds";
        if(timeLeft === 0){
            clearInterval(cinterval);
        }
    };

    cinterval = setInterval(timeDec, 1000);
})();
</script>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body>
<div id="container">
<div id="ErrS">
<img src="Loading.gif" alt="Loading" height="100px" width="100px"></img><br>
<font color="Green" size="40">Success</font>
<h3><font color="Green"><%=session.getAttribute("success").toString() %></font></h3> 
<a href="<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"Login.jsp" %>">Click Here</a> if you are not redirected!<br>
<strong><span id="time"></span></strong>
<%session.removeAttribute("reDirTo"); %>
</div>
</div>
</body>
</html>