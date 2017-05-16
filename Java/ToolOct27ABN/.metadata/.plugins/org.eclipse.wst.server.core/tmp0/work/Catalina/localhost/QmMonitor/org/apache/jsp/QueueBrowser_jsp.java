package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application2.QueueBrowser;
import java.util.LinkedHashSet;
import com.cts.dnb.Application1.BrokerXML;
import com.cts.dnb.Application1.BrokerDetailsVO;
import java.util.ArrayList;
import com.cts.dnb.Application1.jaxB;
import com.cts.dnb.model1.*;

public final class QueueBrowser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Queue Browser</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*function PrefixChange(){\r\n");
      out.write("\tvar StartsWith = document.getElementById(\"StartsWith\").value;\r\n");
      out.write("\t//var broker = document.getElementById(\"brokerName\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(alias==\"prefix\"){\r\n");
      out.write("\t\tdocument.getElementById(\"span_StartsWith\").innerHTML=\" Select the starting letter of the queue\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_StartsWith\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(flag==0){\r\n");
      out.write("\t\tdocument.getElementById(\"form0\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("}*/\r\n");
      out.write("function PrefixChange(){\r\n");
      out.write("\tvar px = document.getElementById(\"StartsWith\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(px==\"prefix\"){\r\n");
      out.write("\t\tdocument.getElementById(\"span_Sw\").innerHTML = \" Select the starting letter\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tdocument.getElementById(\"span_Sw\").innerHTML = \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0){\r\n");
      out.write("\t\tdocument.getElementById(\"form0\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function qChange(){\r\n");
      out.write("\tvar q = document.getElementById(\"qName\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(q==\"Queue\"){\r\n");
      out.write("\t\tdocument.getElementById(\"span_broker\").innerHTML=\"Select the Queue\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.getElementById(\"span_broker\").innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0){\r\n");
      out.write("\t\tdocument.getElementById(\"submit\").disabled = true;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t//document.getElementById(\"form\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function QmChange(){\r\n");
      out.write("\tvar qm = document.getElementById(\"qmName\").value;\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\tif(qm==\"val\"){\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML = \" Select Queue Manager\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tdocument.getElementById(\"span_qm\").innerHTML = \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag==0){\r\n");
      out.write("\t\tdocument.getElementById(\"form\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function appChange(){\r\n");
      out.write("\tdocument.getElementById(\"form2\").submit();\r\n");
      out.write("}\r\n");
      out.write("function disableIt() {\r\n");
      out.write("    document.getElementById(\"submit\").disabled = true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");

if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}

      out.write("\r\n");
      out.write("<div id=\"outer\"> \r\n");
      out.write("<div id=\"header\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  Queue Manager Monitor</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

      out.write("\r\n");
      out.write("<div id=\"left\">\r\n");
      out.write("<h1>Queue Manager and Queues</h1>\r\n");
      out.write("<table align=\"left\" id=\"formTable\">\r\n");
      out.write("<tr>\r\n");
      out.write("<form id=\"form\" action=\"SelectQM\" method=\"post\">\r\n");
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
      out.write("</select></td></form>\r\n");
      out.write("<form id=\"form0\" action=\"FilterQueues\" method=\"post\">\r\n");
      out.write("<td class=\"drop\">Start of QueueName:<select name=\"StartsWith\" id=\"StartsWith\" onchange=\"PrefixChange()\">\r\n");
      out.write("<option value=\"prefix\">Choose First Letter</option>\r\n");
if(session.getAttribute("qmName")!=null){
for(String prefix : QueueBrowser.getAlphabateList()){
	if(session.getAttribute("prefix")!=null && session.getAttribute("prefix").toString().equals(prefix)){
      out.write("\r\n");
      out.write("<option value=\"");
      out.print(prefix);
      out.write("\" selected=\"selected\">");
      out.print(prefix );
      out.write("</option>\r\n");
	
}
else{
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(prefix);
      out.write('"');
      out.write('>');
      out.print(prefix);
      out.write("</option>\r\n");
      out.write("\t");

}}}

      out.write("\r\n");
      out.write("</select></td></form>\r\n");
      out.write("<form action=\"GetQueueDetails\" method=\"post\" id=\"form1\" onsubmit=\"return qChange()\">\r\n");
      out.write("<td class=\"drop\">Queue:<select name=\"qName\" id=\"qName\">\r\n");
      out.write("<option value=\"Queue\">--GENERIC QUEUE--</option>\r\n");
if(session.getAttribute("filteredQList")!=null){
	ArrayList <String> FilteredList = (ArrayList <String>)session.getAttribute("filteredQList");
	for(String q : FilteredList){
		if(session.getAttribute("qName")!=null && session.getAttribute("qName").toString().equals(q)){
		
      out.write("<option value=\"");
      out.print(q);
      out.write("\" selected=\"selected\">");
      out.print(q);
      out.write("</option>\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(q);
      out.write('"');
      out.write('>');
      out.print(q);
      out.write("</option>\r\n");
      out.write("\t\t");
}
	}
}

      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td><font color=red><span id=\"span_qm\"></span></font></td>\r\n");
      out.write("<td><font color=red><span id=\"span_Sw\"></span></font></td>\r\n");
      out.write("<td><font color=red><span id=\"span_broker\"></span></font></td>\r\n");
      out.write("</tr><tr><td><input type=\"submit\" name=\"Submit\" id=\"submit\" value=\"Get Properties\"></td><td><input type=\"submit\" name=\"get\" value=\"Browse Messages\"></td><td><input type=\"submit\" name=\"put\" value=\"Put Messages\"></td></tr>\r\n");
      out.write("</form>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"right\"><div id=\"brokerInfo\"><table><tr><td><a href=\"QueueManagerInfo.jsp\">Configuration Details of Queue Managers</a></td></tr></table></div></div>\r\n");
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
