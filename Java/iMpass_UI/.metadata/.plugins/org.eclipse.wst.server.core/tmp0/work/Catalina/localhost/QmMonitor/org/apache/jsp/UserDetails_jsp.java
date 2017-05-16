package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application1.UserAuth;
import com.cts.dnb.model4.UserTYP;

public final class UserDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>iMPAS : Edit User</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function ValidateAddUser(){\r\n");
      out.write("\tvar usr=document.getElementById(\"usr\").value;\r\n");
      out.write("\tvar type=document.getElementById(\"type\").value;\r\n");
      out.write("\tvar pass=document.getElementById(\"password\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(usr.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_user\").innerHTML=\"Enter UserName\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_user\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(pass.length==0){\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML=\"Enter Password\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML=\"\";\r\n");
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
      out.write("function enablePassword() {\r\n");
      out.write("\tpassword.style.visibility = 'visible';\r\n");
      out.write("    document.getElementById(\"password1\").disabled = false;\r\n");
      out.write("}\r\n");
      out.write("function disale(){\r\n");
      out.write("\tpassword.style.visibility = 'hidden';\r\n");
      out.write("\tdocument.getElementById(\"password1\").disabled = true;\r\n");
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
      out.write("\t\t\t\" This is required in case you are setting up the tool for the first time or a new broker is added to the scope.\"+\r\n");
      out.write("\t\t\t\" You need to provide connection information about broker.\"+\r\n");
      out.write("\t\t\t\" Broker Name, Environment, Hostname and port are the connection parameters needed for tool to connect to the broker.\"+\r\n");
      out.write("\t\t\t\" <br><br><strong>#This does not facilitate the creation of a new broker, but it adds an existing broker to the scope of the tool.<strong> \";\r\n");
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
      out.write("<body style=\"overflow: hidden\" onload=\"display_ct(); disale();\">\r\n");
if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Welcome.jsp");
	}
	
}	
      out.write('\r');
      out.write('\n');

String username = request.getParameter("user");
UserTYP usr = UserAuth.GetUserTYP(username);
if(usr == null){
	session.setAttribute("error", "User was deleted");
	response.sendRedirect("Error.jsp");
}

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
      out.write("<table ><tr><td width = \"550px\">\r\n");
      out.write("<table><tr><td align=\"center\">\r\n");
      out.write("<h1>User Details<sup>#</sup></h1></td></tr><tr><td> </td></tr><tr><td> </td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table id=\"formTable\">\r\n");
      out.write("<form action=\"EditUser\" method=\"post\" onsubmit=\"return ValidateAddUser()\">\r\n");
      out.write("<input type=\"hidden\" name=\"olduser\" value=\"");
      out.print(usr.getUserName());
      out.write("\">\r\n");
      out.write("<table id=\"adminbroker\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Username<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td><input type=\"text\" name=\"user\" id=\"user\" value=\"");
      out.print(usr.getUserName());
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_user\"></span></font></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");

boolean flag = false;
if(usr.getUserType().equals("admin")){
	flag = true;
}

      out.write("\r\n");
      out.write("<td>User Type<font color=\"Red\">*</font>:</td>\r\n");
      out.write("<td>\r\n");
if(flag){ 
      out.write("\r\n");
      out.write("\t<input type=\"radio\" name=\"type\" value=\"admin\" id=\"type\" onclick=\"enablePassword()\" checked=\"checked\">Administrator<input type=\"radio\" name=\"type\" value=\"permit\" id=\"type\" onclick=\"disale()\">Authorized\r\n");
}else{ 
      out.write("\r\n");
      out.write("\t<input type=\"radio\" name=\"type\" value=\"admin\" id=\"type\" onclick=\"enablePassword()\">Administrator<input type=\"radio\" name=\"type\" value=\"permit\" id=\"type\" onclick=\"disale()\" checked=\"checked\">Authorized\r\n");
} 
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td><font color=red><span id=\"span_type\"></span></font></td>\r\n");
      out.write("</tr>\r\n");

String pass="";
if(!flag){ 
      out.write("\r\n");
      out.write("<tr id=\"password\" style=\"visibility:hidden;\">\r\n");
}else{
      out.write("\r\n");
      out.write("<tr id=\"password\" style=\"visibility:visible;\">\r\n");

if(usr.getUserType().equals("admin")){
	pass = usr.getPassword();
}}

      out.write("\r\n");
      out.write("<td>Password:</td>\r\n");
      out.write("<td><input type=\"password\" name=\"password\" id=\"password1\" value=\"");
      out.print(pass);
      out.write("\"></td>\r\n");
      out.write("<td><font color=red><span id=\"span_pass\"></span></font></td>\r\n");
      out.write("</tr></table>\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td><input type=\"submit\" name=\"addBroker\" id=\"addBroker\" value=\"Update User\"></td>\r\n");
      out.write("<td><input type=button name=back value=\"Go Back\" onclick=\"reDirect()\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form></td><td>\r\n");
      out.write("<div id=\"define\">\r\n");
      out.write("<p >Adding a broker to the scope of the tool can be done from here.<span id=\"about\"></span>\r\n");
      out.write("<a href=\"javascript:load()\" id=\"open\">...learn more</a>\r\n");
      out.write("<a href=\"javascript:unload()\" id=\"close\"></a>\r\n");
      out.write("</br>\r\n");
      out.write("</p>\r\n");
      out.write("</div>\r\n");
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
