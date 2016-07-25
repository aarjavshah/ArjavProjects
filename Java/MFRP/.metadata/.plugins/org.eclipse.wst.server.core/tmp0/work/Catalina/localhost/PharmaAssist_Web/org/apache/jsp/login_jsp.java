package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html >\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!--  \r\n");
      out.write(" * CSS and Java Script\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 454580(Shivang Trivedi)\r\n");
      out.write(" * */ -->\r\n");
      out.write("<title>Pharma Assist</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print( request.getContextPath());
      out.write("/img/rx-logo-hi.ico\"></link>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
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
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Compulsory\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse if(pass.length < 8)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Length less than 8 !\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse if(pass.length >16)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Length exceeds 16 !\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t \r\n");
      out.write("\tif(name.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_name\").innerHTML=\"Compulsory\";\r\n");
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
      out.write("\t\t\t\" Indiaâs leading online healthcare Pharma Assistant brings you a wide assortment of Over the Counter medicines online.\"+\r\n");
      out.write("\t\t\t\" You can search for medicine by name or by batch_no.\"+\r\n");
      out.write("\t\t\t\" Brands like Cipla, Bremed, Glaxo, Acti Patch and Ayush Medica are featured here at cost-effective prices.\"+\r\n");
      out.write("\t\t\t\" It gives you a faster service.\"+\r\n");
      out.write("\t\t\t\" It is user-friendly\";\r\n");
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
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("var nHist = window.history.length;\r\n");
      out.write("if(window.history[nHist] != window.location)\r\n");
      out.write("  window.history.forward();\r\n");
      out.write("//-->\r\n");
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
      out.write("\t\t\t\t<h1><a>Pharma Assist</a></h1>\r\n");
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
      out.write("<p >Pharma Assist is an <abbr title=\"My First Real-Time Project\">MFRP</abbr> designed for Cognizant.<span id=\"about\"></span>\r\n");
      out.write("<br style=\"text-align:justify;\"><a href=\"javascript:load()\" id=\"open\"><abbr title=\"Click to learn more\">...learn more</abbr></a>\r\n");
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
      out.write("<!--  \r\n");
      out.write(" * Login JSP page Business Logic\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 454591(Dev Gaba)\r\n");
      out.write(" * */ -->\r\n");
      out.write("\r\n");
 response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  

      out.write("\r\n");
      out.write("\r\n");

if(session.getAttribute("session_username")!=null){
	response.sendRedirect("welcome.jsp");
}
if(request.getParameter("login")!=null||request.getParameter("passwordChange")!=null)
{
int x=0;
x=Integer.parseInt(request.getAttribute("wrong").toString());

if(x==1){
	out.print("<font color=red><span style=\"text-align:center;\">Invalid Userid or Passoword</span></font>");
}
else if(x==2){
	out.print("<font color=green> <span style=\"text-align:center;\">Password Changed!Login in with your credentials.</span></font>");
}
else if(x==3){
	out.print("<font color=orange> <span style=\"text-align:center;\">Last attempt remaining before deactivation.</span></font>");
}
}

      out.write("\r\n");
      out.write("<form action=UserLogin method=post onsubmit=\"return validate();\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table align=center>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("<table align=center style=\"width:150%\">\r\n");
      out.write("<tr><th><i>USERNAME<sup><font color=red>*</font></sup></i></th><td><input type=text name=username id=\"username\" size=28% placeholder=\"Enter Username\"></td><td width=\"50%\"><font color=red><span id=\"span_name\"></span></font></td></tr>\r\n");
      out.write("<tr><th><i>PASSWORD<sup><font color=red>*</font></sup></i></th><td><input type=password name=password id=\"password\" size=28% placeholder=\"Enter Password (8-16 Characters)\"></td><td width=\"50%\"\"><font color=red><span id=\"span_pass\"></span></font></td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"92px\"><input type=\"submit\" name=\"login\" value=\"LOGIN\" ></td>\r\n");
      out.write("<td ><input type=\"reset\" name=\"reset\" value=\"RESET\" onclick=\"clean()\" ></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td >\r\n");
      out.write("<a href=\"DirectPasswordReset.jsp\"><font color=\"blue\"><abbr title=\"Click to redirect to Forgot Password\">Forgot Password</abbr></font></a>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
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
      out.write("\r\n");
      out.write("<div id=\"copyright\" class=\"container\">\r\n");
      out.write("<div id=\"out_copy\">\r\n");
      out.write("<div id=\"in_copy\" style=\"text-align:=center;\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t&copy;copyright cognizant 2011-2020\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<img src=\"");
      out.print( request.getContextPath());
      out.write("/profile/cognizant.png\" height=\"50\" width=\"60\" alt=\"Add New Batch\"></img>\r\n");
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
