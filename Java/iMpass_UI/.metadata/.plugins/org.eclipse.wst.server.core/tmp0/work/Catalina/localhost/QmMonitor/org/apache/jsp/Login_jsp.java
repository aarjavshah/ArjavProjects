package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>ESB Queue-Manager Monitor Login</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function GetPassword() {\r\n");
      out.write("\tpassword.style.visibility = 'visible';\r\n");
      out.write("\tadminLink.style.visibility = 'hidden';\r\n");
      out.write("}\r\n");
      out.write("function  RemovePassword() {\r\n");
      out.write("\tpassword.style.visibility = 'hidden';\r\n");
      out.write("\tadminLink.style.visibility = 'visible';\r\n");
      out.write("}\r\n");
      out.write("function ValidateLogin(){\r\n");
      out.write("\tvar userName=document.getElementById(\"username\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(userName.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_broker\").innerHTML=\"Enter UserName\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tdocument.getElementById(\"span_broker\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0)\r\n");
      out.write("\t{\r\n");
      out.write("\treturn true;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("else\r\n");
      out.write("\t{\r\n");
      out.write("\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write(" <STYLE type=\"text/css\" media=\"screen\">\r\n");
      out.write("    td{width:300px;}\r\n");
      out.write("    #dont{width:93px;}\r\n");
      out.write("    #button{width:53px;}\r\n");
      out.write(" </STYLE>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");
if(session.getAttribute("username")!=null){
	if((Boolean)session.getAttribute("isAdmin")){
		response.sendRedirect("AdminServices.jsp");		
	}else{
		response.sendRedirect("Home.jsp");
	}
}	
      out.write("\r\n");
      out.write("<div id=\"header2\">iMPAS : IBM Messaging Platform Access Simplified</div>\r\n");
      out.write("<div id=\"desc\">\r\n");
      out.write("<p>\r\n");
      out.write("\t<div id=\"textbox\"><img src=\"Bullet.png\" height=\"10px\" width=\"10px\">\r\n");
      out.write("\tThis tool gives the information about Queues, Channels, Brokers, execution groups and deployed services.</div><div id=\"textbox\"><img src=\"Bullet.png\"  height=\"10px\" width=\"10px\">\r\n");
      out.write("\tSelect an environment (dev,QA,Stag etc) which will provide list of queue managers/brokers available on this environment.</div><div id=\"textbox\"><img src=\"Bullet.png\"  height=\"10px\" width=\"10px\">\r\n");
      out.write("\tSelect a queue manager/broker from the list. </div><div id=\"textbox2\">     <img src=\"Bullet.png\"  height=\"10px\" width=\"10px\">\r\n");
      out.write("\tOn selecting broker it will display all flows ,status (running or stopped) deployed on this broker.\r\n");
      out.write("\tInformation about Services like deployment date, version, instances of the messageFlow and the status of the service will be displayed.\r\n");
      out.write("\t</div><div id=\"textbox2\"><img src=\"Bullet.png\"  height=\"10px\" width=\"10px\">\r\n");
      out.write("\tOn selecting queue manager the information about queue properties and channel status will be displayed\r\n");
      out.write("\t</div>\r\n");
      out.write("</p>\r\n");
      out.write("</div>\r\n");
      out.write("<form action=\"Login\" method=\"post\" onsubmit=\"return ValidateLogin()\">\r\n");
      out.write("<div id=\"err\">\r\n");
if(session.getAttribute("AdminLoginFail")!=null){
if((Boolean)session.getAttribute("AdminLoginFail")){
	out.print("<font color=red>Admin Login Failed</font>");
	session.removeAttribute("AdminLoginFail");
}}

      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<table id=\"adminbroker\">\r\n");
      out.write("<tr id=\"user\">\r\n");
      out.write("\t<td id=\"dont\" align=\"right\">Username:</td>\r\n");
      out.write("\t<td><input type=\"text\" name=\"username\" id=\"username\" placeholder=\"Use your Employee ID\"></td>\r\n");
      out.write("\t<td><font color=red><span id=\"span_broker\"></span></font></td><td> </td>\r\n");
      out.write("\t<td id=\"adminLink\" onclick=\"GetPassword()\"><a href=\"#\">Admin Login</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr id=\"password\" style=\"visibility:hidden;\">\r\n");
      out.write("\t<td id=\"dont\" align=\"right\">Password:</td>\r\n");
      out.write("\t<td><input type=\"password\" name=\"password\" ></td><td> </td><td> </td>\r\n");
      out.write("\t<td id=\"userLink\" onclick=\"RemovePassword()\"><a href=\"#\">User Login</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"button\"><input type=\"submit\" name =\"login\" value=\"Login\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>-->\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html >\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Pharma Assist</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print( request.getContextPath());
      out.write("/img/rx-logo-hi.ico\"></link>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function GetPassword() {\r\n");
      out.write("\tpassword.style.visibility = 'visible';\r\n");
      out.write("\tadminLink.style.visibility = 'hidden';\r\n");
      out.write("}\r\n");
      out.write("function  RemovePassword() {\r\n");
      out.write("\tpassword.style.visibility = 'hidden';\r\n");
      out.write("\tadminLink.style.visibility = 'visible';\r\n");
      out.write("}\r\n");
      out.write("function ValidateLogin(){\r\n");
      out.write("\tvar userName=document.getElementById(\"username\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(userName.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_broker\").innerHTML=\"Enter UserName\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tdocument.getElementById(\"span_broker\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0)\r\n");
      out.write("\t{\r\n");
      out.write("\treturn true;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("else\r\n");
      out.write("\t{\r\n");
      out.write("\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
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
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("function validate()\r\n");
      out.write("{\r\n");
      out.write("\tvar name=document.getElementById(\"username\").value;\r\n");
      out.write("\tvar pass=document.getElementById(\"password\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\t\r\n");
      out.write("\tif(pass.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password is Compulsory\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse if(pass.length < 8)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password is Length less than 8 !\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse if(pass.length >16)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password Length exceeds 16 !\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t \r\n");
      out.write("\tif(name.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_name\").innerHTML=\"Username is Compulsory\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\tif(flag==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function clean()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"span_name\").innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById(\"username\").value=\"\";\r\n");
      out.write("\t\tdocument.getElementById(\"password\").value=\"\";\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function load()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\r\n");
      out.write("\t\t\t\" This Utility facilitates virtual read only access to IBM Messaging Platform (WMQ and WMB/IIB). \"+\r\n");
      out.write("\t\t\t\"Utility will enable access to objects and messages for live data. \"+\r\n");
      out.write("\t\t\t\"It provides on demand data view and object health check.\";\r\n");
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
      out.write("</head>\r\n");
      out.write("<body onload=display_ct();>\r\n");
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
      out.write("\t\t\t\t<h1><a>iMPAS</a></h1>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"menu\" class=\"container\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"login.jsp\">Homepage</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"contact1.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"banner\">\r\n");
      out.write("\r\n");
      out.write("<table style=\"height:75%;\">\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<div id=\"define\">\r\n");
      out.write("<p >iMPAS (IBM Messaging Platform Access Simplified) is an utility designed by Cognizant.<span id=\"about\"></span>\r\n");
      out.write("<a href=\"javascript:load()\" id=\"open\">...learn more</a>\r\n");
      out.write("<a href=\"javascript:unload()\" id=\"close\"></a>\r\n");
      out.write("</br>\r\n");
      out.write("</p>\r\n");
      out.write("</div>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:75%;\" id=\"out_index\">\r\n");
      out.write("<div id=\"in_index\" style=\"text-align:=center;\">\r\n");
      out.write("\r\n");
      out.write("<form action=\"Login\" method=\"post\" onsubmit=\"return ValidateLogin()\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table align=center>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
if(session.getAttribute("AdminLoginFail")!=null){
if((Boolean)session.getAttribute("AdminLoginFail")){
	out.print("<font color=red>Admin Login Failed</font>");
	session.removeAttribute("AdminLoginFail");
}}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table id=\"adminbroker\">\r\n");
      out.write("<tr id=\"user\">\r\n");
      out.write("\t<td id=\"dont\" align=\"right\">Username:</td>\r\n");
      out.write("\t<td><input type=\"text\" name=\"username\" id=\"username\" placeholder=\"Use your Employee ID\"></td>\r\n");
      out.write("\t<td><font color=red><span id=\"span_broker\"></span></font></td><td> </td>\r\n");
      out.write("\t<td id=\"adminLink\" onclick=\"GetPassword()\"><a href=\"#\">Admin Login</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr id=\"password\" style=\"visibility:hidden;\">\r\n");
      out.write("\t<td id=\"dont\" align=\"right\">Password:</td>\r\n");
      out.write("\t<td><input type=\"password\" name=\"password\" ></td><td> </td><td> </td>\r\n");
      out.write("\t<td id=\"userLink\" onclick=\"RemovePassword()\"><a href=\"#\">User Login</a></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td id=\"button\"><input type=\"submit\" name =\"login\" value=\"Login\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</table>\r\n");
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
      out.write("/img/cognizant.png\" height=\"50\" width=\"60\" alt=\"cts_logo\"></img>\r\n");
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
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
