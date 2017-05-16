package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TestFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<input type=\"file\" id=\"fileinput\"/>\r\n");
      out.write("\r\n");
      out.write("<form>\r\n");
      out.write("Please specify a file, or a set of files:<br>\r\n");
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("<textarea id=\"demo\" style=\"width:400px;height:150px;\"></textarea>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  \r\n");
      out.write("  function readSingleFile(evt) {\r\n");
      out.write("    //Retrieve the first (and only!) File from the FileList object\r\n");
      out.write("    var f = evt.target.files[0]; \r\n");
      out.write("\r\n");
      out.write("    if (f) {\r\n");
      out.write("      var r = new FileReader();\r\n");
      out.write("      r.onload = function(e) { \r\n");
      out.write("\t      var contents = e.target.result;\r\n");
      out.write("\t      document.getElementById(\"demo\").innerHTML = contents;\r\n");
      out.write("        alert( \"Got the file.n\" \r\n");
      out.write("              +\"name: \" + f.name + \"n\"\r\n");
      out.write("              +\"type: \" + f.type + \"n\"\r\n");
      out.write("              +\"size: \" + f.size + \" bytesn\"\r\n");
      out.write("              + \"starts with: \" + contents.substr(1, contents.indexOf(\"n\"))\r\n");
      out.write("        );  \r\n");
      out.write("      }\r\n");
      out.write("      r.readAsText(f);\r\n");
      out.write("    } else { \r\n");
      out.write("      alert(\"Failed to load file\");\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  document.getElementById('fileinput').addEventListener('change', readSingleFile, false);\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("</script>  \r\n");
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
