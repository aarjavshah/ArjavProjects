package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application1.BrokerDetailsVO;

public final class UpdateBroker_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>iMPAS : Edit Broker</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function ValidateAddBroker(){\r\n");
      out.write("\tvar broker=document.getElementById(\"broker\").value;\r\n");
      out.write("\tvar alias=document.getElementById(\"alias\").value;\r\n");
      out.write("\tvar host=document.getElementById(\"host\").value;\r\n");
      out.write("\tvar port=document.getElementById(\"port\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(alias.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_alias\").innerHTML=\"Enter Environment\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_alias\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(broker.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_broker\").innerHTML=\"Enter BrokerName\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_broker\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(qm.length==0){\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML=\"Enter Queue-Manager Name\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(host.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_host\").innerHTML=\"Enter Host IP address\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_host\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(port.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_port\").innerHTML=\"Enter Port\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(isNaN(port))\r\n");
      out.write("\t{\tdocument.getElementById(\"span_port\").innerHTML=\"Port should be number\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_port\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"updateBroker\").disabled = true;\r\n");
      out.write("\t\treturn true;\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("}\r\n");
      out.write("function reDirect()\r\n");
      out.write("{\r\n");
      out.write("window.location=\"AdminServices.jsp\";\t\t\r\n");
      out.write("}\r\n");
      out.write("function disableIt() {\r\n");
      out.write("    document.getElementById(\"updateBroker\").disabled = true;\r\n");
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
      out.write("function load()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\r\n");
      out.write("\t\t\t\" You can also edit the connection parameters.\"+\r\n");
      out.write("\t\t\t\" Be cautious while editing the connection parameters. These are used by the tool to connect to the broker.\"+\r\n");
      out.write("\t\t\t\" Entering the wrong parameters can lead to issues in the tool.\"+\r\n");
      out.write("\t\t\t\" <br><br><strong>#This does not alter any properties of the broker on the server, but it changes connection information of the broker for the tool.<strong> \";\r\n");
      out.write("\t\tdocument.getElementById(\"open\").innerHTML=\"\";\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"close\").innerHTML=\"...hide\";\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function unload()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById(\"open\").innerHTML=\"...learn more\";\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"close\").innerHTML=\"\";\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<body style=\"overflow: hidden\" onload=display_ct();>\r\n");
      out.write("\r\n");
if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Welcome.jsp");
	}
	
}
BrokerDetailsVO broker = (BrokerDetailsVO)session.getAttribute("currentBroker");
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
      out.write("<table><tr><td width=\"550px\">\r\n");
      out.write("<table><tr><td align=\"center\">\r\n");
      out.write("<h1>Update Broker<sup>#</sup></h1></td></tr><tr><td> </td></tr><tr><td> </td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table id=\"formTable\"><tr><td>\r\n");
      out.write("<form action=\"UpdateBroker\" method=\"post\" onsubmit=\"return ValidateAddBroker()\">\r\n");
      out.write("<input type=\"hidden\" name=\"oldName\" value=\"");
      out.print(session.getAttribute("oldName").toString());
      out.write("\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Environment<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"alias\" id=\"alias\" value=\"");
      out.print(broker.getAlias());
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_alias\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Broker Name<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"broker\" id=\"broker\" value=\"");
      out.print(broker.getBrokerName());
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_broker\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Queue-Manager Name<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"qm\" id=\"qm\" value=\"");
      out.print(broker.getQueueManagerName() );
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_qm\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Host IP<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"host\" id=\"host\" value=\"");
      out.print(broker.getHost());
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_host\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Port Number<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"port\" id=\"port\" value=\"");
      out.print(broker.getPort());
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_port\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td><input type=\"submit\" name=\"updateBroker\" id=\"updateBroker\" value=\"Update Broker\"></td>\r\n");
      out.write("<td><input type=button name=back value=\"Go Back\" onclick=\"reDirect()\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</td><td>\r\n");
      out.write("<div id=\"define\">\r\n");
      out.write("<p >Brokers and it's connection information can be viewed from here.<span id=\"about\"></span>\r\n");
      out.write("<a href=\"javascript:load()\" id=\"open\">...learn more</a>\r\n");
      out.write("<a href=\"javascript:unload()\" id=\"close\"></a>\r\n");
      out.write("</br>\r\n");
      out.write("</p>\r\n");
      out.write("</div></td></tr></table>\r\n");
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
