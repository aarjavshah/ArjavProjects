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
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body onload=\"makeDisable()\">\r\n");
if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}

      out.write("\r\n");
      out.write("<div id=\"outer\">\r\n");
      out.write("<div id=\"header\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  Queue Manager Monitor</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

      out.write("\r\n");
      out.write("<div id=\"left\">\r\n");
      out.write("<h1>Queue Manager and Topics</h1>\r\n");
      out.write("<table align=\"left\" id=\"formTable\">\r\n");
      out.write("<tr>\r\n");
      out.write("<form id=\"form\" action=\"LoadChannels\" method=\"post\">\r\n");
      out.write("<td class=\"drop\">Queue Manager:<select name=\"qmName\" id=\"qmName\" onchange=\"QmChange()\">\r\n");
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
      out.write("<td class=\"drop\">ChannelName:<select name=\"TpName\" id=\"TpName\" >\r\n");
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
