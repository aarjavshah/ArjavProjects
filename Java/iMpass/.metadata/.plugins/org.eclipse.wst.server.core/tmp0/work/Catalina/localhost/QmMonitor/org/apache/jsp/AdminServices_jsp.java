package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminServices_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Admin Home</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function confimation(){\r\n");
      out.write("\treturn confirm(\"This Will Start an automated update cycle!\\nAre you sure?\");\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");
if(session.getAttribute("isAdmin")==null ){
response.sendRedirect("Login.jsp");}
else if(!(Boolean)session.getAttribute("isAdmin")){
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");	
	}else{
		response.sendRedirect("Home.jsp");
	}
	
}	
      out.write("\r\n");
      out.write("<div id=\"outer\">\r\n");
      out.write("<div id=\"header2\"><a href=");
      out.print(session.getAttribute("home")!=null?session.getAttribute("home").toString():"" );
      out.write("><img src=\"home.png\" height=\"40\" width=\"40\" alt=\"Home\"></img>  iMPAS : IBM Messaging Platform Access Simplified</a></div>\r\n");
      out.write("<div id=\"logout\"><table><tr><td>Welcome ");
      out.print(session.getAttribute("username") );
      out.write("</td><td><a href=\"Logout.jsp\"><img src=\"logg.jpg\" height=\"25\" width=\"25\" alt=\"Log Out\"></img></a></td></tr></table></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"ErrS2\">\r\n");
      out.write("<table id=\"formTable2\"><tr><td>\r\n");
      out.write("<ol class=\"tree1\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<label for=\"Broker Operation\"> Broker Operation</label><input type=\"checkbox\" id=\"Broker Operation\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"AddBroker.jsp\">Add a new Broker</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"RemoveBroker.jsp\">Remove an existing Broker</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"BrokerList.jsp\">See the existing broker List</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"");
      out.print(request.getContextPath());
      out.write("/BrokerUpdate\" onclick=\"return confimation()\">Update Application status</a></li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ol>\r\n");
      out.write("</td></tr><tr><td>\r\n");
      out.write("<ol class=\"tree1\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<label for=\"Queue-Manager Operation\"> Queue-Manager Operation</label><input type=\"checkbox\" id=\"Queue-Manager Operation\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"AddQManager.jsp\">Add a new Queue-Manager</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"");
      out.print(request.getContextPath());
      out.write("/QMSetup\" onclick=\"return confimation()\">Update All available Queue-Managers</a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ol>\r\n");
      out.write("</td></tr><tr><td>\r\n");
      out.write("<ol class=\"tree1\">\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<label for=\"User-Access Operation\"> User-Access Operation</label><input type=\"checkbox\" id=\"User-Access Operation\">\r\n");
      out.write("\t\t<ol>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"AddUser.jsp\">Add a new User</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"RemoveUser.jsp\">Remove an existing User</a></li>\r\n");
      out.write("\t\t\t<li class=\"file\"><a class=\"admin\" href=\"UserList.jsp\">See the existing User List</a></li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ol>\r\n");
      out.write("</td></tr><tr><td><div class=\"conf\">\r\n");
      out.write("<a href=\"ConfigureProperties.jsp\">Configure Properties</a></div></td></tr>\r\n");
      out.write("<tr><td><div class=\"conf\">\r\n");
      out.write("<a href=\"TrackRequest.jsp\">Track Request</a></div></td></tr>\r\n");
      out.write("<tr><td><div class=\"conf\">\r\n");
      out.write("<a href=\"Home.jsp\">User Home Page</a></div></td></tr>\r\n");
      out.write("</table>\r\n");
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