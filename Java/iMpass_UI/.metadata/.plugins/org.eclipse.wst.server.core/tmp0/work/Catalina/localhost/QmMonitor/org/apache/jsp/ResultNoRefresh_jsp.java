package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application1.AppTypComparator;
import com.cts.dnb.Application1.EgTypComparator;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.text.SimpleDateFormat;
import com.cts.dnb.Application1.FilePaths;
import java.io.File;
import com.cts.dnb.model2.EgVO;
import com.cts.dnb.model2.ApplicationVO;
import com.cts.dnb.model1.MessageFlowsTYP;
import com.cts.dnb.model1.MessageFlowTYP;
import com.cts.dnb.model1.ApplicationsTYP;
import com.cts.dnb.model1.ApplicationTYP;
import com.cts.dnb.model1.BrokersTYP;
import com.cts.dnb.model1.BrokerTYP;
import com.cts.dnb.model1.ExecutionGroupsTYP;
import com.cts.dnb.model1.ExecutionGroupTYP;
import com.cts.dnb.Application1.jaxB;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;

public final class ResultNoRefresh_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Broker Message Flows</title>\r\n");
      out.write("<meta http-equiv=\"refresh\" content=\"180\" >\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function makeDisable(){\r\n");
      out.write("\tdocument.getElementById(\"alias\").disabled = true;\r\n");
      out.write("\tdocument.getElementById(\"brokerName\").disabled = true;\r\n");
      out.write("\tdocument.getElementById(\"eg\").disabled = true;\r\n");
      out.write("\t}\r\n");
      out.write("function makeEnable(){\r\n");
      out.write("\tdocument.getElementById(\"alias\").disabled = false;\r\n");
      out.write("\tdocument.getElementById(\"brokerName\").disabled = false;\r\n");
      out.write("\tdocument.getElementById(\"eg\").disabled = false;\r\n");
      out.write("\t}\r\n");
      out.write("function brokerChange(){\r\n");
      out.write("\tdocument.getElementById(\"form\").submit();\r\n");
      out.write("}\r\n");
      out.write("function egChange(){\r\n");
      out.write("\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("}\r\n");
      out.write("function reDirect()\r\n");
      out.write("{\r\n");
      out.write("window.location=\"Welcome.jsp\";\t\t\r\n");
      out.write("}\r\n");
      out.write("function display_c(){\r\n");
      out.write("\tvar refresh=1000; // Refresh rate in milli seconds\r\n");
      out.write("\tsetTimeout('display_ct()',refresh)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("function display_ct() {\r\n");
      out.write("\tvar strcount;\r\n");
      out.write("\tvar x = new Date();\r\n");
      out.write("\tvar hour=x.getHours();\r\n");
      out.write("\r\n");
      out.write("\tif(hour>=0 && hour<12)\r\n");
      out.write("\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" am     \";\r\n");
      out.write("\t\r\n");
      out.write("\telse if(hour==12)\r\n");
      out.write("\t\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\r\n");
      out.write("\telse\r\n");
      out.write("\tdocument.getElementById('time').innerHTML = (hour-12) + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\t\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.getElementById('date').innerHTML = x.getDate() + \"-\"+ (x.getMonth()+1) + \"-\" +x.getFullYear() ;\r\n");
      out.write("\tdisplay_c();\r\n");
      out.write("\t }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<body style=\"overflow: hidden\" onload=display_ct();>\r\n");

if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}

      out.write("\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t<div id=\"header-wrapper\">\r\n");
      out.write("\t\t<div id=\"header\" class=\"container\">\r\n");
      out.write("\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\t<h1><a href=\"");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">iMPAS</a></h1>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"menu\" class=\"container\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">Welcome Page</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logout-1.png\" height=\"40\" width=\"40\" alt=\"logout\"></img></a>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><font color=white>Logout ");
      out.print(session.getAttribute("username") );
      out.write("</font>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"banner1\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:0%;\" id=\"out_search\">\r\n");
      out.write("<div id=\"in_search\" style=\"text-align:=center;\">\r\n");
      out.write("<table><tr><td>\r\n");
      out.write("\r\n");
 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

      out.write('\r');
      out.write('\n');

//session.setAttribute("appList", appList);
Boolean boolean1 = false;
if(session.getAttribute("brokerStatus") != null)
boolean1 = (Boolean)session.getAttribute("brokerStatus");
Boolean boolean2 = false;
if(session.getAttribute("egStatus") != null)
boolean2 = (Boolean)session.getAttribute("egStatus");
 
      out.write("\r\n");
      out.write("<h1>Environment and Broker</h1>\r\n");
      out.write("\r\n");
      out.write("<table align=\"left\" id=\"formTable\" style=\"padding-bottom: 15px\"><tr>\r\n");
      out.write("<form  id=\"form0\" action=\"GetEgs\" method=\"post\">\r\n");
      out.write("<td class=\"drop\">Environment:<select name=\"alias\" id=\"alias\" onchange=\"aliasChange()\" disabled=\"disabled\">\r\n");
      out.write("<option value=\"Environments\">--Environments--</option>\r\n");

LinkedHashSet<String> aliasList = jaxB.getAliasList(); 
for(String alias:aliasList){
	if(session.getAttribute("alias")!=null && session.getAttribute("alias").toString().equals(alias)){
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(alias);
      out.write("\" selected=\"selected\">");
      out.print(alias);
      out.write("</option>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(alias);
      out.write('"');
      out.write('>');
      out.print(alias);
      out.write("</option>\r\n");
      out.write("\t");
}
}

      out.write("\r\n");
      out.write("</select></td><form  id=\"form\" action=\"GetEgs\" method=\"post\" >\r\n");
      out.write("<td class=\"drop\">Broker-Name:<select name=\"broker\" id=\"brokerName\" onchange=\"brokerChange()\" disabled=\"disabled\">\r\n");
      out.write("<option value=\"Brokers\">--Brokers--</option>\r\n");

if(session.getAttribute("brokerList")!=null){
ArrayList<String> tmp =(ArrayList<String>) session.getAttribute("brokerList");
for(String broker :tmp){
	if(session.getAttribute("broker")!=null && session.getAttribute("broker").toString().equals(broker)){
      out.write("\r\n");
      out.write("<option value=\"");
      out.print(broker);
      out.write("\" selected=\"selected\">");
      out.print(broker );
      out.write("</option>\r\n");
	
}
else{
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(broker);
      out.write('"');
      out.write('>');
      out.print(broker );
      out.write("</option>");

}
}}

      out.write("\r\n");
      out.write("</select>");
if(session.getAttribute("broker")!=null){ 
      out.write('\r');
      out.write('\n');
      out.print((boolean1?"<font color=\"green\">Running</font>":"<font color=\"red\">NotRunning</font>") );
} 
      out.write("\r\n");
      out.write("</td></tr><tr>\r\n");
      out.write("\r\n");
if(session.getAttribute("broker")!=null){String bkr = (String)session.getAttribute("broker"); 
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<input type=\"hidden\" name=\"broker\" value=");
      out.print(bkr);
      out.write(">\r\n");
      out.write("<INPUT TYPE=\"submit\" VALUE=\"Refresh\"></td>\r\n");
} 
      out.write("\r\n");
      out.write("<td></form></form>\r\n");
      out.write("\r\n");
      out.write("<button name=\"enable\" id=\"enable\" onclick=\"reDirect()\" value=\"Change\">Change</button>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");



      out.write("\r\n");
      out.write("<h2 style=\"padding-top: 15px\">Execution Groups</h2>\r\n");
      out.write("<div id=\"lastmod\">Last Updated on : ");
      out.print(sdf.format(new File(FilePaths.getBrokerStatus()).lastModified()) );
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<ol class=\"tree\">\r\n");

if(session.getAttribute("brokerTYP")!=null){
BrokerTYP brokerTyp = (BrokerTYP)session.getAttribute("brokerTYP");

int i=0;
List<ExecutionGroupTYP> egList = brokerTyp.getExecutionGroups().getExecutionGroup();
//Collections.sort(egList, new EgTypComparator());
for(ExecutionGroupTYP eg :egList){
      out.write("\r\n");
      out.write("<div id=\"textbox\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t");

	String ans="";
	if(eg.isIsExecutionGroupRunning()){
		ans = "<font color=\"green\">Running</font>";
	}else{
		ans = "<font color=\"red\">NotRunning</font>";
	}
	//System.out.print(ans);
	out.println("<label for="+eg.getExecutionGroupName()+">"+eg.getExecutionGroupName()+"::"+ans+"</label>"+"<input type=checkbox id="+eg.getExecutionGroupName()+"/>"); 
	
      out.write("\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t");
List <ApplicationTYP> appList =eg.getApplications().getApplication();
			//Collections.sort(appList, new AppTypComparator());
			for(ApplicationTYP app : appList)
			{
			
      out.write("\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t");

			out.println("<label for="+app.getApplicationName()+">"+app.getApplicationName()+"::"+(app.isIsApplicationRunning()?"<font color=\"green\">Running</font>":"<font color=\"red\">NotRunning</font>")+"</label>"+"<input type=checkbox id="+app.getApplicationName()+"/>");
			
      out.write("\r\n");
      out.write("\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t\t<li class=\"file\"><a href=\"#\">Deployment Date:");
      out.print(app.getApplicationDeployedOn());
      out.write("</a></li>");

					for(MessageFlowTYP msgFlow:app.getMessageFlows().getMessageFlow())
					{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><label for=\"");
      out.print(msgFlow.getMessageFlowName() );
      out.write('"');
      out.write('>');
      out.print(msgFlow.getMessageFlowName()+"::"+(msgFlow.isIsMessageFlowRunning()?
						"<font color=\"green\">Running</font>":
						"<font color=\"red\">NotRunning</font>")+"</label>"+"<input type=checkbox id="+msgFlow.getMessageFlowName() +" />");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"file\"><a href=\"#\">");
      out.print("Additional Instances:"+(msgFlow.getMessageFlowInstances()-1) );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
if(msgFlow.getQueues().getQueue().size()>0){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li><label for=\"Queues\">Queue List</label><input type=\"checkbox\" id=\"Queues\" />\r\n");
      out.write("\t\t\t\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t\t\t\t");
for(String q:msgFlow.getQueues().getQueue()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"file\"><a href=\"#\">");
      out.print(q );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</ol></li>");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ol>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t</ol>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t");
}
	
      out.write("\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</li>\r\n");
      out.write("</div>\r\n");
}
      out.write('\r');
      out.write('\n');
}
      out.write("\r\n");
      out.write("</ol>\r\n");
      out.write("</td></tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"copyright\" class=\"container\">\r\n");
      out.write("<div style=\"height:75%;\" id=\"out_copy\">\r\n");
      out.write("<div id=\"in_copy\" style=\"text-align:=center;\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t&copy;copyright cognizant 2011-2020\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<img src=\"");
      out.print( request.getContextPath());
      out.write("/img/cognizant.png\" height=\"50\" width=\"60\" alt=\"Add New Batch\"></img>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<span id=\"time\"></span><span id=\"date\"></span>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
