<%@page import="com.cts.dnb.Application1.AppTypComparator"%>
<%@page import="com.cts.dnb.Application1.EgTypComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cts.dnb.Application1.FilePaths"%>
<%@page import="java.io.File"%>
<%@page import="com.cts.dnb.model2.EgVO"%>
<%@page import="com.cts.dnb.model2.ApplicationVO"%>
<%@page import="com.cts.dnb.model1.MessageFlowsTYP"%>
<%@page import="com.cts.dnb.model1.MessageFlowTYP"%>
<%@page import="com.cts.dnb.model1.ApplicationsTYP"%>
<%@page import="com.cts.dnb.model1.ApplicationTYP"%>
<%@page import="com.cts.dnb.model1.BrokersTYP"%>
<%@page import="com.cts.dnb.model1.BrokerTYP"%>
<%@page import="com.cts.dnb.model1.ExecutionGroupsTYP"%>
<%@page import="com.cts.dnb.model1.ExecutionGroupTYP"%>
<%@page import="com.cts.dnb.Application1.jaxB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="com.cts.dnb.Application1.BrokerDetailsVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.cts.dnb.Application1.BrokerXML" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Broker Message Flows</title>
<meta http-equiv="refresh" content="180" >
</head>
<script type="text/javascript">
function makeDisable(){
	document.getElementById("alias").disabled = true;
	document.getElementById("brokerName").disabled = true;
	document.getElementById("eg").disabled = true;
	}
function makeEnable(){
	document.getElementById("alias").disabled = false;
	document.getElementById("brokerName").disabled = false;
	document.getElementById("eg").disabled = false;
	}
function brokerChange(){
	document.getElementById("form").submit();
}
function egChange(){
	document.getElementById("form1").submit();
}
function reDirect()
{
window.location="Welcome.jsp";		
}
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/collapse.css" media="screen">
<body onload="makeDisable()">
<%
if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}
else if(session.getAttribute("broker")== null || session.getAttribute("brokerStatus")== null){
	response.sendRedirect("Welcome.jsp");
}
%><div id="container">
<div id="outer"> 
<div id="header"><a href=<%=session.getAttribute("home")!=null?session.getAttribute("home").toString():"" %>><img src="home.png" height="40" width="40" alt="Home"></img>  Queue Manager Monitor</a></div>
<div id="logout"><table><tr><td>Welcome <%=session.getAttribute("username") %></td><td><a href="Logout.jsp"><img src="logg.jpg" height="25" width="25" alt="Log Out"></img></a></td></tr></table></div>
</div>
<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
%>
<%
//session.setAttribute("appList", appList);
Boolean boolean1 = false;
if(session.getAttribute("brokerStatus") != null)
boolean1 = (Boolean)session.getAttribute("brokerStatus");
Boolean boolean2 = false;
if(session.getAttribute("egStatus") != null)
boolean2 = (Boolean)session.getAttribute("egStatus");
 %>
<div id="left">
<h1>Environment and Broker</h1>

<table align="left" id="formTable"><tr>
<form  id="form0" action="GetEgs" method="post">
<td class="drop">Environment:<select name="alias" id="alias" onchange="aliasChange()">
<option value="Environments">--Environments--</option>
<%
LinkedHashSet<String> aliasList = jaxB.getAliasList(); 
for(String alias:aliasList){
	if(session.getAttribute("alias")!=null && session.getAttribute("alias").toString().equals(alias)){%>
		<option value="<%=alias%>" selected="selected"><%=alias%></option>
	<%}else{%>
		<option value="<%=alias%>"><%=alias%></option>
	<%}
}
%>
</select></td><form  id="form" action="GetEgs" method="post" >
<td class="drop">Broker-Name:<select name="broker" id="brokerName" onchange="brokerChange()">
<option value="Brokers">--Brokers--</option>
<%
if(session.getAttribute("brokerList")!=null){
ArrayList<String> tmp =(ArrayList<String>) session.getAttribute("brokerList");
for(String broker :tmp){
	if(session.getAttribute("broker")!=null && session.getAttribute("broker").toString().equals(broker)){%>
<option value="<%=broker%>" selected="selected"><%=broker %></option>
<%	
}
else{%>
	<option value="<%=broker%>"><%=broker %></option><%
}
}}
%>
</select><%if(session.getAttribute("broker")!=null){ %>
<%=(boolean1?"<font color=\"green\">Running</font>":"<font color=\"red\">NotRunning</font>") %><%} %>
</td></tr><tr>

<%if(session.getAttribute("broker")!=null){String bkr = (String)session.getAttribute("broker"); %>
<td>
<input type="hidden" name="broker" value=<%=bkr%>>
<INPUT TYPE="submit" VALUE="Refresh"></td>
<%} %>
<td></form></form>

<button name="enable" id="enable" onclick="reDirect()" value="Change">Change</button>
</td>
</tr>
</table>
</div>
<%
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


%>
<div id="right">
<h1>Execution Groups</h1>
<div id="lastmod">Last Updated on : <%=sdf.format(new File(FilePaths.getBrokerStatus()).lastModified()) %>
</div>
<ol class="tree">
<%
if(session.getAttribute("brokerTYP")!=null){
BrokerTYP brokerTyp = (BrokerTYP)session.getAttribute("brokerTYP");

int i=0;
List<ExecutionGroupTYP> egList = brokerTyp.getExecutionGroups().getExecutionGroup();
//Collections.sort(egList, new EgTypComparator());
for(ExecutionGroupTYP eg :egList){%>
<div id="textbox">
	<li>
	<%
	String ans="";
	if(eg.isIsExecutionGroupRunning()){
		ans = "<font color=\"green\">Running</font>";
	}else{
		ans = "<font color=\"red\">NotRunning</font>";
	}
	//System.out.print(ans);
	out.println("<label for="+eg.getExecutionGroupName()+">"+eg.getExecutionGroupName()+"::"+ans+"</label>"+"<input type=checkbox id="+eg.getExecutionGroupName()+"/>"); 
	%>
		<ol>
	
			<%List <ApplicationTYP> appList =eg.getApplications().getApplication();
			//Collections.sort(appList, new AppTypComparator());
			for(ApplicationTYP app : appList)
			{
			%>	
			<li>
			<%
			out.println("<label for="+app.getApplicationName()+">"+app.getApplicationName()+"::"+(app.isIsApplicationRunning()?"<font color=\"green\">Running</font>":"<font color=\"red\">NotRunning</font>")+"</label>"+"<input type=checkbox id="+app.getApplicationName()+"/>");
			%>
				<ol>
					<li class="file"><a href="#">Deployment Date:<%=app.getApplicationDeployedOn()%></a></li><%
					for(MessageFlowTYP msgFlow:app.getMessageFlows().getMessageFlow())
					{
					%>
					<li><label for="<%=msgFlow.getMessageFlowName() %>"><%=msgFlow.getMessageFlowName()+"::"+(msgFlow.isIsMessageFlowRunning()?
						"<font color=\"green\">Running</font>":
						"<font color=\"red\">NotRunning</font>")+"</label>"+"<input type=checkbox id="+msgFlow.getMessageFlowName() +" />"%>
						<ol>
							<li class="file"><a href="#"><%="Additional Instances:"+(msgFlow.getMessageFlowInstances()-1) %></a></li>
							<%if(msgFlow.getQueues().getQueue().size()>0){ %>
							<li><label for="Queues">Queue List</label><input type="checkbox" id="Queues" />
							<ol>
							<%for(String q:msgFlow.getQueues().getQueue()){ %>
									<li class="file"><a href="#"><%=q %></a></li>
								<%} %>
							</ol></li><%} %>
						</ol>
					</li>
				<%}%>
				</ol>
			</li>
	<%}
	%>
		</ol>
	</li>
</div>
<%}%>
<%}%>
</ol>
</div></div>
</body>
</html>
