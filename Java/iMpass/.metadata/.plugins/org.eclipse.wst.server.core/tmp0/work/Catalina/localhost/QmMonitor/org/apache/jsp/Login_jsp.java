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

      out.write("\r\n");
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
