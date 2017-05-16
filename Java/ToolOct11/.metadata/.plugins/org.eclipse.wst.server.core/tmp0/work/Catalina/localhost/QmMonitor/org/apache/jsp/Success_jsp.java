package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Success_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<meta http-equiv=\"Refresh\" content=\"5;url=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">\r\n");
      out.write("<title>Success</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("(function () {\r\n");
      out.write("    var timeLeft = 5,\r\n");
      out.write("        cinterval;\r\n");
      out.write("\r\n");
      out.write("    var timeDec = function (){\r\n");
      out.write("        timeLeft--;\r\n");
      out.write("        document.getElementById('time').innerHTML = \"\\nYou will be Redirected in \"+timeLeft+\" seconds\";\r\n");
      out.write("        if(timeLeft === 0){\r\n");
      out.write("            clearInterval(cinterval);\r\n");
      out.write("        }\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    cinterval = setInterval(timeDec, 1000);\r\n");
      out.write("})();\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("<div id=\"ErrS\">\r\n");
      out.write("<img src=\"Loading.gif\" alt=\"Loading\" height=\"100px\" width=\"100px\"></img><br>\r\n");
      out.write("<font color=\"Green\" size=\"40\">Success</font>\r\n");
      out.write("<h3><font color=\"Green\">");
      out.print(session.getAttribute("success").toString() );
      out.write("</font></h3> \r\n");
      out.write("<a href=\"");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("\">Click Here</a> if you are not redirected!<br>\r\n");
      out.write("<strong><span id=\"time\"></span></strong>\r\n");
      out.write("</div>\r\n");
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
