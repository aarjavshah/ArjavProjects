package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html >\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Pharma Assist</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/PharmaAssist/img/rx-logo-hi.ico\"></link>\r\n");
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
      out.write("\t\r\n");
      out.write("\tif(pass.length==0)\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password is Compulsory\";\r\n");
      out.write("\t\r\n");
      out.write("\telse if(pass.length < 8)\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password is Length less than 8 !\";\r\n");
      out.write("\t\r\n");
      out.write("\telse if(pass.length >16)\r\n");
      out.write("\t\tdocument.getElementById(\"span_pass\").innerHTML=\"Password Length exceeds 16 !\";\r\n");
      out.write("\t \r\n");
      out.write("\tif(name.length==0)\r\n");
      out.write("\t\tdocument.getElementById(\"span_name\").innerHTML=\"Username is Compulsory\";\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
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
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\"You can learn more here................!!!!!:-)\";\r\n");
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
      out.write("<body onload=\"display_ct();\">\r\n");
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
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"welcome.jsp\">Welcome Page</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logout-1.png\" height=\"40\" width=\"40\" alt=\"Add New Batch\"></img></a>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><font color=white>Logout</font>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<div class=\"banner\" id=\"banner\">\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:75%;\" id=\"out_wel\">\r\n");
      out.write("<div id=\"in_wel\" style=\"text-align:=center;\">\r\n");
      out.write("<table align=\"center\" width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td align=\"center\" width=\"200px\">\r\n");
      out.write("\r\n");
 response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  

      out.write("\r\n");
      out.write("\r\n");

if(request.getParameter("search")!=null||request.getParameter("update")!=null||request.getParameter("delete")!=null||request.getParameter("add")!=null)
{
String x="";
x=request.getAttribute("welcome").toString();

if(x.equals("updateTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch updated successfully.</span></font>");
}
else if(x.equals("updateFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be updated.Entered batchcode already exist</span></font>");
}
else if(x.equals("addTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch added successfully.</span></font>");
}
else if(x.equals("addFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be added.Entered batchcode already exist.</span></font>");
}
else if(x.equals("deleteTrue")){
	out.print("<font color=green> <span style=\"text-align:center;\">Batch deleted successfully.</span></font>");
}
else if(x.equals("deleteFalse")){
	out.print("<font color=red> <span style=\"text-align:center;\">Batch can not be deleted.</span></font>");
}
}
if(request.getParameter("login")!=null){
String username=(String)request.getParameter("username");
session.setAttribute("session_username", username);
session.setMaxInactiveInterval(180);}
if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}
//out.print("Welcome"+(String)session.getAttribute("session_username"));

      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br></br>\r\n");
      out.write("<br></br>\r\n");
      out.write("<table width=\"130%\">\r\n");
      out.write("<tr><td width=\"25%\" align=\"center\"><a href=\"addbatch.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/add_folder.png\" height=\"100\" width=\"100\" alt=\"Add New Batch\"></img></a>\r\n");
      out.write("<td width=\"25%\" align=\"center\"><a href=\"searchbatch.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/search.png\" height=\"100\" width=\"100\" alt=\"Search Batch\"></img></a>\r\n");
      out.write("<td width=\"25%\" align=\"center\"><a href=\"deletebatch.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/delle.png\" height=\"100\" width=\"100\" alt=\"Delete Batch\"></img></a>\r\n");
      out.write("<td width=\"25%\" align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logg.jpg\" height=\"100\" width=\"100\" alt=\"Logout\"></img></a>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"130%\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"25%\" align=\"center\">Add New Batch\r\n");
      out.write("<td width=\"25%\" align=\"center\">Search Batch\r\n");
      out.write("<td width=\"25%\" align=\"center\">Delete Batch\r\n");
      out.write("<td width=\"25%\" align=\"center\">Logout\r\n");
      out.write("</table>\r\n");
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
