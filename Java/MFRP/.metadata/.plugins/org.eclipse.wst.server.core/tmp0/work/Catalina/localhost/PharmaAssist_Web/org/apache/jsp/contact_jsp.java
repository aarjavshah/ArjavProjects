package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Pharma Assist</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/PharmaAssist/img/rx-logo-hi.ico\"></link>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<!--  \r\n");
      out.write(" * CSS and Java Script\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 455185(Somasri Kar)\r\n");
      out.write(" * */ -->\r\n");
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
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<!--  \r\n");
      out.write(" * Contact JSP page\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 454591(Dev Gaba)\r\n");
      out.write(" * */ -->\r\n");
      out.write("<body onload=display_ct();>\r\n");
if(session.getAttribute("session_username")==null){
	response.sendRedirect("login.jsp");
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
      out.write("\t\t\t\t<h1><a href=\"#\">Pharma Assist</a></h1>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"menu\" class=\"container\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li ><a href=\"welcome.jsp\">Welcome Page</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end #menu --> \r\n");
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logout-1.png\" height=\"40\" width=\"40\" alt=\"Add New Batch\"></img></a>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><font color=white>Welcome ");

	if(session.getAttribute("session_username")!=null)
	out.println(session.getAttribute("session_username").toString());
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
      out.write("\t<div id=\"banner\" align=center>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"height:15%;\" id=\"out_contact\">\r\n");
      out.write("\t<div id=\"in_contact\" style=\"text-align:=center;\">\r\n");
      out.write("\t");
 response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  

      out.write("\r\n");
      out.write("\t<table align=center>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t<table width=\"150px\">\r\n");
      out.write("\t\t\t\t<tr><td align=center><b>Arjav Shah</b></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center>454582</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/mail.jpg\" height=\"15\" width=\"20\" alt=\"Mail\"></img></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><abbr title=\"ArjavDhirendra.Shah@cognizant.com\">ArjavDhirendra.Shah</abbr></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t<table width=\"150px\">\r\n");
      out.write("\t\t\t\t<tr><td align=center><b>Dev gaba</b></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center>454591</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/mail.jpg\" height=\"15\" width=\"20\" alt=\"Mail\"></img></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><abbr title=\"Dev.Gaba@cognizant.com\">Dev.Gaba</abbr></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t<table width=\"150px\">\r\n");
      out.write("\t\t\t\t<tr><td align=center><b>Fenil Tailor</b></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center>454579</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/mail.jpg\" height=\"15\" width=\"20\" alt=\"Mail\"></img></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><abbr title=\"FenilShaileshkumar.Tailor@cognizant.com\">FenilShaileshkumar.Tailor</abbr></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t<table width=\"150px\">\r\n");
      out.write("\t\t\t\t<tr><td align=center><b>Shivang Trivedi</b></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center>4545980</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/mail.jpg\" height=\"15\" width=\"20\" alt=\"Mail\"></img></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><abbr title=\"ShivangSanjay.Trivedi@cognizant.com\">ShivangSanjay.Trivedi</abbr></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t<table width=\"150px\">\r\n");
      out.write("\t\t\t\t<tr><td align=center><b>Somasri Kar</b></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center>455185</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/mail.jpg\" height=\"15\" width=\"20\" alt=\"Mail\"></img></td></tr>\r\n");
      out.write("\t\t\t\t<tr><td align=center><abbr title=\"SOMASRI.KAR@cognizant.com\">SOMASRI.KAR</abbr></td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
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
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
