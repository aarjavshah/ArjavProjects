package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.dnb.Controller.Login;
import org.apache.log4j.Logger;
import com.cts.dnb.Application2.QueueBrowser;
import com.cts.dnb.model3.QueueManager;
import java.util.ArrayList;
import com.cts.dnb.Application1.*;

public final class QueueManagerInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Queue Manager Info</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function reDirect()\r\n");
      out.write("{\r\n");
      out.write("window.location=\"Home.jsp\";\t\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}
Logger logger = Logger.getLogger(Login.class);
logger.debug("user "+session.getAttribute("username")+" loaded the Queue Manager Configuration List");

      out.write("\r\n");
      out.write("<div id=\"outer\"> \r\n");
      out.write("<div id=\"header\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  Queue Manager Monitor</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"left\">\r\n");
      out.write("<div id=\"centeredText\">\r\n");
      out.write("<h1>Existing Queue Manager List</h1></div>\r\n");
      out.write("<div id=\"right\">\r\n");
      out.write("<h1>Queue Managers</h1>\r\n");
      out.write("<ol class=\"tree\">\r\n");
      out.write("\r\n");
for(QueueManager qm :QueueBrowser.getQMRoot().getQueueManager()){
      out.write("\r\n");
      out.write("\t<div id=\"textbox\"><li>\r\n");
      out.write("\t<label for=\"");
      out.print(qm.getConnectConfig().getQMname() );
      out.write('"');
      out.write('>');
      out.print(qm.getConnectConfig().getQMname() );
      out.write("</label>\r\n");
      out.write("\t<input type=\"checkbox\" id=\"");
      out.print(qm.getConnectConfig().getQMname());
      out.write("\"> \r\n");
      out.write("\t<ol>\r\n");
      out.write("\t<li class=\"file\"><a href=\"#\">Environment Name : ");
      out.print(qm.getEnvironment() );
      out.write("</a></li>\r\n");
      out.write("\t<li class=\"file\"><a href=\"#\">Host IP : ");
      out.print(qm.getConnectConfig().getQMhost() );
      out.write("</a></li>\r\n");
      out.write("\t<li class=\"file\"><a href=\"#\">Port Number : ");
      out.print(qm.getConnectConfig().getQMport());
      out.write("</a></li>\r\n");
      out.write("\t\r\n");
      out.write("\t</ol></li>\r\n");
}
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</ol>\r\n");
      out.write("<input type=button name=back value=\"Go Back\" onclick=\"reDirect()\">\r\n");
      out.write("</div></div>\r\n");
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
