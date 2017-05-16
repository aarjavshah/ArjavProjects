package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application2.TopicProperties;
import java.util.ArrayList;
import com.cts.dnb.Application2.QueueBrowser;
import com.cts.dnb.Application2.ChannelStatus;

public final class TpStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Topic Status</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function makeDisable(){\r\n");
      out.write("\tdocument.getElementById(\"qmName\").disabled = true;\r\n");
      out.write("\tdocument.getElementById(\"TpName\").disabled = true;\r\n");
      out.write("\t}\r\n");
      out.write("function makeEnable(){\r\n");
      out.write("\tdocument.getElementById(\"qmName\").disabled = false;\r\n");
      out.write("\tdocument.getElementById(\"TpName\").disabled = false;\r\n");
      out.write("\t}\r\n");
      out.write("function reDirect(){\r\n");
      out.write("\twindow.location=\"TopicBrowser.jsp\";\t\t\r\n");
      out.write("\t}function display_c(){\r\n");
      out.write("\t\tvar refresh=1000; // Refresh rate in milli seconds\r\n");
      out.write("\t\tsetTimeout('display_ct()',refresh)\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction display_ct() {\r\n");
      out.write("\t\tvar strcount;\r\n");
      out.write("\t\tvar x = new Date();\r\n");
      out.write("\t\tvar hour=x.getHours();\r\n");
      out.write("\r\n");
      out.write("\t\tif(hour>=0 && hour<12)\r\n");
      out.write("\t\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" am     \";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\telse if(hour==12)\r\n");
      out.write("\t\t\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\tdocument.getElementById('time').innerHTML = (hour-12) + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById('date').innerHTML = x.getDate() + \"-\"+ (x.getMonth()+1) + \"-\" +x.getFullYear() ;\r\n");
      out.write("\t\tdisplay_c();\r\n");
      out.write("\t\t }\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<body onload=display_ct();>\r\n");
      out.write("\t");

	if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
	
      out.write("\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t<div id=\"header-wrapper\">\r\n");
      out.write("\t\t\t<div id=\"header\" class=\"container\">\r\n");
      out.write("\t\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\t\t<h1><a href=\"");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">iMPAS</a></h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<div id=\"menu\" class=\"container\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"current_page_item\"><a href=\"");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">Welcome Page</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logout-1.png\" height=\"40\" width=\"40\" alt=\"logout\"></img></a>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td align=\"center\"><font color=white>Logout ");
      out.print(session.getAttribute("username") );
      out.write("</font>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div id=\"banner1\">\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"height:0%;\" id=\"out_search\">\r\n");
      out.write("\t<div id=\"in_search\" style=\"text-align:=center;\">\r\n");
      out.write("\t<table><tr><td>\r\n");
      out.write("\r\n");
      out.write("\t");
 
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragma","no-cache"); 
	response.setHeader ("Expires", "0"); //prevents caching at the proxy server 
	
      out.write("\r\n");
      out.write("<h1>Queue Manager and Topics</h1>\r\n");
      out.write("<table align=\"left\" id=\"formTable\">\r\n");
      out.write("<tr>\r\n");
      out.write("<form id=\"form\" action=\"LoadChannels\" method=\"post\">\r\n");
      out.write("<td class=\"drop\">Queue Manager:<select name=\"qmName\" id=\"qmName\" onchange=\"QmChange()\" disabled=\"disabled\">\r\n");
      out.write("<option value=\"val\">--Queue Manager--</option>\r\n");

for(String qm : QueueBrowser.getQmList()){
	if(session.getAttribute("qmName")!=null && session.getAttribute("qmName").toString().equals(qm)){
      out.write("\r\n");
      out.write("<option value=\"");
      out.print(qm);
      out.write("\" selected=\"selected\">");
      out.print(qm );
      out.write("</option>\r\n");
	
}
else{
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(qm);
      out.write('"');
      out.write('>');
      out.print(qm);
      out.write("</option>\r\n");
      out.write("\t");

}}

      out.write("\r\n");
      out.write("</select><font color=red><span id=\"span_alias\"></span></font></td></form>\r\n");
      out.write("<form id=\"form0\" action=\"GetTopicDetails\" method=\"post\">\r\n");
      out.write("<td class=\"drop\">ChannelName:<select name=\"TpName\" id=\"TpName\" disabled=\"disabled\">\r\n");
      out.write("<option value=\"prefix\">--Channel--</option>\r\n");
if(session.getAttribute("qmName")!=null){
for(String channel : QueueBrowser.getAllTopics((String)session.getAttribute("qmName"))){
	if(session.getAttribute("TpName")!=null && channel.equals((String)session.getAttribute("TpName"))){

      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(channel);
      out.write("\" selected=\"selected\">");
      out.print(channel);
      out.write("</option>\r\n");
}else{ 
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(channel);
      out.write('"');
      out.write('>');
      out.print(channel);
      out.write("</option>\r\n");
      out.write("\t");

}}}

      out.write("\r\n");
      out.write("</select><font color=red><span id=\"span_StartsWith\"></span></font></td></tr>\r\n");
      out.write("<tr>");
if(session.getAttribute("TpName")!=null){String ch = (String)session.getAttribute("TpName"); 
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<input type =\"hidden\" name=\"TpName\" value=");
      out.print(ch );
      out.write(">\r\n");
      out.write("<INPUT TYPE=\"submit\" VALUE=\"Refresh\"></td>\r\n");
} 
      out.write("</form><td>\r\n");
      out.write("<button name=\"enable\" id=\"enable\" onclick=\"reDirect()\" value=\"Change\">Change</button>\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"right1\">\r\n");

TopicProperties tp = (TopicProperties)session.getAttribute("TpProp");


      out.write("\r\n");
      out.write("<table width=70% class=\"qDis\" align=\"center\"><tr>\r\n");
      out.write("<th>Property Name</th>\r\n");
      out.write("<th>Property Value</th></tr>\r\n");
      out.write("<tr><td class=\"res\">Topic Name </td><td class=\"res\"> ");
      out.print(tp.getTopicName());
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Topic String </td><td class=\"res\"> ");
      out.print(tp.getTopicString());
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Topic Description </td><td class=\"res\"> ");
      out.print(tp.getTopicDesc());
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Publication </td><td class=\"res\"> ");
      out.print(tp.getPubAllowed());
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Subscription </td><td class=\"res\"> ");
      out.print(tp.getSubAllowed());
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
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