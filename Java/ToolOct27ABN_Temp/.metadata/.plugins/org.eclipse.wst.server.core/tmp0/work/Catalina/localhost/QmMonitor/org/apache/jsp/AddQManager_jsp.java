package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.nio.channels.SeekableByteChannel;

public final class AddQManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Add Queue-Manager</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function ValidateAddBroker(){\r\n");
      out.write("\tvar alias=document.getElementById(\"alias\").value;\r\n");
      out.write("\tvar host=document.getElementById(\"host\").value;\r\n");
      out.write("\tvar port=document.getElementById(\"port\").value;\r\n");
      out.write("\tvar chl=document.getElementById(\"chaName\").value;\r\n");
      out.write("\tvar qm=document.getElementById(\"qm\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(alias.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_alias\").innerHTML=\"Enter Environment\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_alias\").innerHTML=\"\";\r\n");
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
      out.write("\tif(chl.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_chaName\").innerHTML=\"Enter SVRCONN Channel name\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_chaName\").innerHTML=\"\";\r\n");
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
      out.write("\t\tdocument.getElementById(\"addBroker\").disabled = true;\r\n");
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
      out.write("    document.getElementById(\"addBroker\").disabled = true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");
if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Welcome.jsp");
	}
	
}	
      out.write("\r\n");
      out.write("<div id=\"outer\"> \r\n");
      out.write("<div id=\"header\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  Queue Messaging Utility</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"left\">\r\n");
      out.write("<div id=\"centeredText\">\r\n");
      out.write("<h1>Add New Queue Manager</h1></div>\r\n");
      out.write("<form action=\"AddQM\" method=\"post\" onsubmit=\"return ValidateAddBroker()\">\r\n");
      out.write("<table id=\"adminbroker\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Environment<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"alias\" id=\"alias\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_alias\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Queue-Manager Name<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"qm\" id=\"qm\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_qm\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Host IP<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"host\" id=\"host\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_host\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Port Number<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"port\" id=\"port\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_port\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Channel Name<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"chaName\" id=\"chaName\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_chaName\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td><input type=\"submit\" name=\"addBroker\" id=\"addBroker\" value=\"Validate and Add\"></td>\r\n");
      out.write("<td><input type=button name=back value=\"Go Back\" onclick=\"reDirect()\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"right1\">\r\n");
if(session.getAttribute("QMAvail")!=null ){
	Boolean qmavail = (Boolean)session.getAttribute("QMAvail");
	if(!qmavail){
		session.removeAttribute("QMAvail");
	
      out.write("<font color=\"red\">Unable to Connect to Queue-Manager<br />Please Provide Valid Queue-Manager Details</font>\r\n");
}}
      out.write("\r\n");
      out.write("</div>\r\n");
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
