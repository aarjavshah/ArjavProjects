package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Application2.*;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import com.cts.dnb.Application1.BrokerDetailsVO;
import com.cts.dnb.Application1.BrokerXML;

public final class QueueStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Queue Status</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function makeDisable(){\r\n");
      out.write("\tdocument.getElementById(\"qmName\").disabled = true;\r\n");
      out.write("\tdocument.getElementById(\"StartsWith\").disabled = true;\r\n");
      out.write("\tdocument.getElementById(\"qName\").disabled = true;\r\n");
      out.write("\t}\r\n");
      out.write("function makeEnable(){\r\n");
      out.write("\tdocument.getElementById(\"qmName\").disabled = false;\r\n");
      out.write("\tdocument.getElementById(\"StartsWith\").disabled = false;\r\n");
      out.write("\tdocument.getElementById(\"qName\").disabled = false;\r\n");
      out.write("\t}\r\n");
      out.write("function brokerChange(){\r\n");
      out.write("\tdocument.getElementById(\"form\").submit();\r\n");
      out.write("}\r\n");
      out.write("function egChange(){\r\n");
      out.write("\tdocument.getElementById(\"form1\").submit();\r\n");
      out.write("}\r\n");
      out.write("function reDirect()\r\n");
      out.write("{\r\n");
      out.write("window.location=\"QueueBrowser.jsp\";\t\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body onload=\"makeDisable()\">\r\n");

if(session.getAttribute("username")== null){
	response.sendRedirect("Login.jsp");
	}

      out.write("<div id=\"container\">\r\n");
      out.write("<div id=\"outer\"> \r\n");
      out.write("<div id=\"header\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  Queue Manager Monitor</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragma","no-cache"); 
response.setHeader ("Expires", "0"); //prevents caching at the proxy server 

      out.write("\r\n");
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
      out.write("</select><font color=red><span id=\"span_alias\"></span></font></td></form>\r\n");
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
      out.write("</select><font color=red><span id=\"span_StartsWith\"></span></font></td></form>\r\n");
      out.write("<form action=\"GetQueueDetails\" method=\"post\" id=\"form1\">\r\n");
      out.write("<td class=\"drop\">Queue:<select name=\"qName\" id=\"qName\">\r\n");
      out.write("<option value=\"Queue\">--GENERIC QUEUE--</option>\r\n");
if(session.getAttribute("filteredQList")!=null){
	ArrayList <String> FilteredList = (ArrayList <String>)session.getAttribute("filteredQList");
	for(String q : FilteredList){
		if(session.getAttribute("qName")!=null && session.getAttribute("qName").toString().equals(q)){
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(q);
      out.write("\" selected=\"selected\">");
      out.print(q );
      out.write("</option>\r\n");
      out.write("\t\t");
	
		}
		else{
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(q);
      out.write('"');
      out.write('>');
      out.print(q);
      out.write("</option>\r\n");
      out.write("\t\t");

	}}
}

      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("<font color=red><span id=\"span_broker\"></span></font></td>\r\n");
      out.write("</tr>");
if(session.getAttribute("qName")!=null){String q=(String)session.getAttribute("qName"); 
      out.write("\r\n");
      out.write("<tr><td><input type=\"hidden\" name=\"qName\" value=");
      out.print(q);
      out.write(">\r\n");
      out.write("<INPUT TYPE=\"submit\" VALUE=\"Refresh\"></td>");
} 
      out.write("</form><td>\r\n");
      out.write("<button name=\"enable\" id=\"enable\" onclick=\"reDirect()\" value=\"Change\">Change</button>\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"right1\">\r\n");

QueueProperties qProperties = null;
if(session.getAttribute("qProperties")!=null){
	qProperties =(QueueProperties)session.getAttribute("qProperties");


      out.write("\r\n");
      out.write("<table width=70% class=\"qDis\" align=\"center\"><tr>\r\n");
      out.write("<th>Property Name</th>\r\n");
      out.write("<th>Property Value</th></tr>\r\n");
      out.write("<tr><td class=\"res\">Queue Name </td><td class=\"res\"> ");
      out.print(qProperties.getQueueName() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Queue Type</td> <td class=\"res\"> ");
      out.print(qProperties.getQueueType()
);
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Put Messages </td><td class=\"res\"> ");
      out.print(qProperties.getInhibitPutMessage() );
      out.write("</td></tr>\r\n");

if(qProperties.getQueueType().equals("LOCAL")||qProperties.getQueueType().equals("ALIAS")){

      out.write("\r\n");
      out.write("<tr><td class=\"res\">Get Messages </td><td class=\"res\"> ");
      out.print(qProperties.getInhibitGetMessage() );
      out.write("</td></tr>\r\n");
	
}if(qProperties.getQueueType().equals("LOCAL")){

      out.write("\r\n");
      out.write("<tr><td class=\"res\">Queue Depth </td><td class=\"res\"> ");
      out.print(qProperties.getCurDepth() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Maximum Depth </td><td class=\"res\"> ");
      out.print(qProperties.getMaxDepth() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Open Input Count<br>(Consumer Application Count)</td> \r\n");
if(qProperties.getOpenInputCount()>0){ 
      out.write("\r\n");
      out.write("<td class=\"res\">\r\n");
      out.write("<ol class=\"tree1\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t<label for=\"");
      out.print(qProperties.getOpenInputCount() );
      out.write('"');
      out.write('>');
      out.print(qProperties.getOpenInputCount() );
      out.write("</label><input type=\"checkbox\" id=\"");
      out.print(qProperties.getOpenInputCount() );
      out.write("\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t");
for(QueueListener ls: qProperties.getListenerList()){ 
			if(ls.getType().equals("I")||ls.getType().equals("B")){
      out.write("\r\n");
      out.write("\t\t\t\t<li><label for=\"");
      out.print(ls.getConName() );
      out.write('"');
      out.write('>');
      out.print(ls.getConName());
      out.write("</label>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" id=\"");
      out.print(ls.getConName());
      out.write("\">\r\n");
      out.write("\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t<li class=\"file\"><a href=\"#\">Channel Name: ");
      out.print(ls.getChName() );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");

				if(ls.getType().equals("B")){
				
      out.write("<li class=\"file\"><a href=\"#\">Listener Activity: Browse </a></li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</ol></li>\r\n");
      out.write("\t\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t\r\n");
} 
      out.write("</ol></li></ol>");
}else{
      out.write(" <td style=\"vertical-align: middle;\">");
 out.print(qProperties.getOpenInputCount());} 
      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Open Output Count<br>(Provider Application Count)</td>\r\n");
if(qProperties.getOpenOutputCount()>0){ 
      out.write("\r\n");
      out.write("<td class=\"res\">\r\n");
      out.write("<ol class=\"tree1\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t<label for=\" ");
      out.print(qProperties.getOpenOutputCount() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(qProperties.getOpenOutputCount() );
      out.write("</label><input type=\"checkbox\" id=\" ");
      out.print(qProperties.getOpenOutputCount() );
      out.write("\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t");
for(QueueListener ls: qProperties.getListenerList()){ 
			if(ls.getType().equals("O")){
      out.write("\r\n");
      out.write("\t\t\t\t<li><label for=\"");
      out.print(ls.getConName() );
      out.write('"');
      out.write('>');
      out.print(ls.getConName());
      out.write("</label>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" id=\"");
      out.print(ls.getConName());
      out.write("\">\r\n");
      out.write("\t\t\t\t<ol>\r\n");
      out.write("\t\t\t\t<li class=\"file\"><a href=\"#\">Channel Name: ");
      out.print(ls.getChName() );
      out.write("</a></li>\r\n");
      out.write("\t\t\t\t</ol></li>\r\n");
      out.write("\t\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t\r\n");
} 
      out.write("</ol></li></ol>");
}else{ 
      out.write("<td style=\"vertical-align: middle;\">");
out.print(qProperties.getOpenOutputCount());}
      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Last Get Date </td><td class=\"res\"> ");
      out.print(qProperties.getLastGetDt() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Last Get Time </td><td class=\"res\"> ");
      out.print(qProperties.getLastGetTm() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Last Put Date </td><td class=\"res\"> ");
      out.print(qProperties.getLastPutDt() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Last Put Time </td><td class=\"res\"> ");
      out.print(qProperties.getLastPutTm() );
      out.write("</td></tr>\r\n");
}else if(qProperties.getQueueType().equals("ALIAS")){ 

      out.write("\r\n");
      out.write("<tr><td class=\"res\">Target Queue </td><td class=\"res\"> ");
      out.print(qProperties.getTargetQ() );
      out.write("</td></tr>\r\n");
}else if(qProperties.getQueueType().equals("REMOTE")){ 

      out.write("\r\n");
      out.write("<tr><td class=\"res\">Remote Queue Manager </td><td class=\"res\"> ");
      out.print(qProperties.getRemoteQM() );
      out.write("</td></tr>\r\n");
      out.write("<tr><td class=\"res\">Remote Queue Name </td><td class=\"res\"> ");
      out.print(qProperties.getRemoteQ() );
      out.write("</td></tr>\r\n");
} }
      out.write("\r\n");
      out.write("</table>\r\n");
if(session.getAttribute("isPermit")!=null && qProperties.getQueueType().equals("LOCAL")){
	if((Boolean)session.getAttribute("isPermit")){
      out.write("\r\n");
      out.write("\t<div id=\"instance1\"><form action=\"MessageQueue\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"qm\" value=\"");
      out.print((String)session.getAttribute("qmName"));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"q\" value=\"");
      out.print((String)session.getAttribute("qName"));
      out.write("\">\r\n");
      out.write("\t<input type=\"submit\" name=\"put\" value=\"Put Messages\">\r\n");
      out.write("\t");
if(qProperties.getCurDepth()>0){ 
      out.write("\r\n");
      out.write("\t\t<input type=\"submit\" name=\"get\" value=\"Browse Messages\">\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t<input type=\"submit\" name=\"get\" value=\"Browse Messages\" disabled=\"disabled\">");
} 
      out.write("\r\n");
      out.write("\t</form></div>\r\n");
		}
	}
      out.write("\r\n");
      out.write("</div></div>\r\n");
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
