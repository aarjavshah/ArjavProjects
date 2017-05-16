package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.cts.testing.TestRun;
import org.apache.commons.lang3.StringEscapeUtils;
import com.cts.dnb.Application2.GetMessageVO;
import com.cts.dnb.Application2.QueueMessenger;
import com.cts.dnb.Application2.QueueBrowser;

public final class MessageRead_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Read Queue</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function getContent(){\r\n");
      out.write("\tvar div_val=document.getElementById(\"editablediv\").innerHTML;\r\n");
      out.write("    document.getElementById(\"formtextarea\").value =div_val;\r\n");
      out.write("    if(div_val==''){\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("    \t//empty form will not be submit. You can also alert this message like this. alert(blahblah);\r\n");
      out.write("    \t}\r\n");
      out.write("\t}\r\n");
      out.write("function enableChange(){\r\n");
      out.write("\tdocument.getElementById(\"msgNum\").removeAttribute(\"disabled\");\r\n");
      out.write("}\r\n");
      out.write("function disableChange(){\r\n");
      out.write("\tdocument.getElementById(\"msgNum\").setAttribute(\"disabled\", true);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
String qName= (String)session.getAttribute("qName") ;
String qmName= (String)session.getAttribute("qmName") ;
int curDepth = QueueMessenger.GetQueueDepth(qmName, qName);

      out.write("\r\n");
      out.write("<div id=\"left\">\r\n");
      out.write("<h1>Get Message</h1>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"right\"><div id=\"brokerInfo\"><table><tr><td><a href=\"QueueManagerInfo.jsp\">Configuration Details of Queue Managers</a></td></tr></table></div></div>\r\n");
      out.write("<div id=\"right2\">\r\n");
      out.write("<div id=\"textbox\"><strong>Queue Name         :</strong>");
      out.print(qName );
      out.write("</div>\r\n");
      out.write("<div id=\"textbox\"><strong>Queue-Manager Name :</strong>");
      out.print(qmName );
      out.write("</div>\r\n");
      out.write("<div id=\"textbox\"><strong>Read Messages :</strong> Available Messages are <strong>");
      out.print(curDepth );
      out.write("</strong></div>\r\n");
      out.write("<form action=\"ReadMessage\" method=\"post\">\r\n");
      out.write("<div id=\"textbox\"><br></div>\r\n");
      out.write("<div id=\"textbox\"><input type=\"radio\" name=\"GMO\" id =\"fst\" value=\"First\" checked=\"checked\" onchange=\"disableChange()\">First Message</div>\r\n");
      out.write("<br><div id=\"textbox\"><input type=\"radio\" name=\"GMO\" id =\"mny\" value=\"Multiple\" onchange=\"enableChange()\">First <input type=\"number\" id=\"msgNum\" name=\"msgNum\" value=1 min=1 max=");
      out.print(curDepth );
      out.write(" disabled=\"true\"> Messages</div>\r\n");
      out.write("<br><div id=\"textbox\"><input type=\"radio\" name=\"GMO\" id=\"all\" value=\"All\" onchange=\"disableChange()\">All Messages</div>\r\n");
      out.write("<br><div id=\"textbox\">");
if(curDepth>0){ 
      out.write("<input type=\"submit\" name=\"readMsg\" value=\"Get Messages\">\r\n");
}else{ 
      out.write("<input type=\"submit\" name=\"readMsg\" value=\"Get Messages\" disabled=\"disabled\">");
} 
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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