package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ibm.mq.ese.intercept.JmqiGetInterceptorImpl.MsgStatus;
import java.util.ArrayList;
import com.cts.testing.TestRun;
import org.apache.commons.lang3.StringEscapeUtils;
import com.cts.dnb.Application2.GetMessageVO;
import com.cts.dnb.Application2.QueueMessenger;
import com.cts.dnb.Application2.QueueBrowser;

public final class GetMessage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Browse Queue</title>\r\n");
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
      out.write("function reload(){\r\n");
      out.write("\twindow.location=\"GetMessage.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function reload1(){\r\n");
      out.write("\twindow.location=\"GetMessages.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function getMsg(){\r\n");
      out.write("\twindow.location=\"MessageRead.jsp\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/collapse.css\" media=\"screen\">\r\n");
      out.write("<body>\r\n");

if(session.getAttribute("username") == null){response.sendRedirect("Login.jsp");}else{
	//System.out.println((Integer)session.getAttribute("BrCount"));
	if((Integer)session.getAttribute("BrCount")==0){
		//System.out.println("a")	;
	session.setAttribute("BrCount",(Integer)session.getAttribute("BrCount")+1);
	//System.out.println((Integer)session.getAttribute("BrCount"));
	//session.setAttribute("BrCount",0);
	//session.setAttribute("BrMsgs",TestRun.BrowseMessage((String)session.getAttribute("qmName"),(String)session.getAttribute("qName")));
	}else{
		session.setAttribute("BrCount",(Integer)session.getAttribute("BrCount")+1);
		if(session.getAttribute("BrFinish")!=null && (Boolean)session.getAttribute("BrFinish")){
			//System.out.println(session.getAttribute("BrFinish"));
			//System.out.println("ba");
			session.setAttribute("reDirTo","QueueBrowser.jsp");
			session.setAttribute("success", "All Messages Browsed successfully");
			session.setAttribute("BrFinish",false);
			//System.out.println(session.getAttribute("BrFinish"));
			response.sendRedirect("Success.jsp");
		}
	}
}

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
      out.write("<h1>Browse Message</h1>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"right\"><div id=\"brokerInfo\"><table><tr><td><a href=\"QueueManagerInfo.jsp\">Configuration Details of Queue Managers</a></td></tr></table></div></div>\r\n");
      out.write("<div id=\"right2\">\r\n");
      out.write("<div id=\"textbox\"><strong>Queue Name         :</strong>");
      out.print((String)session.getAttribute("qName") );
      out.write("</div>\r\n");
      out.write("<div id=\"textbox\"><strong>Queue-Manager Name :</strong>");
      out.print((String)session.getAttribute("qmName") );
      out.write("</div>\r\n");
      out.write("\r\n");

ArrayList <String> msgs= (ArrayList)session.getAttribute("BrMsgs");
GetMessageVO dsp = new GetMessageVO();
//System.out.print(msgs);
//System.out.println((Integer)session.getAttribute("BrCount"));
if((Integer)session.getAttribute("BrCount")<=msgs.size()){
dsp = QueueMessenger.SeparateHeader(msgs.get((Integer)session.getAttribute("BrCount")-1));} 
if((Integer)session.getAttribute("BrCount")==(msgs.size())){
	//session.setAttribute("BrFinish", true);
	//System.out.println(session.getAttribute("BrFinish"));
}


      out.write("\r\n");
      out.write("<div id=\"textbox\"><strong>Browsing Message ");
      out.print(session.getAttribute("BrCount") );
      out.write(" of ");
      out.print(msgs.size() );
      out.write(":</strong></div>\r\n");
      out.write("<textarea name=\"inMsg\" id=\"formtextarea\"rows=\"10\" cols=\"50\" disabled>");
      out.print(StringEscapeUtils.escapeHtml4(dsp.getHeader()));
      out.write("</textarea>\r\n");
      out.write("<textarea name=\"inMsg\" id=\"formtextarea\"rows=\"10\" cols=\"80\" disabled>");
      out.print(StringEscapeUtils.escapeHtml4(dsp.getData()));
      out.write("</textarea>\r\n");
 
      out.write("<br>");
if((Integer)session.getAttribute("BrCount")!=1){ 
      out.write("\r\n");
      out.write("<input type=button id=\"next\" name=\"next\" value=\"Prev Message\" onclick=\"reload1()\">");
 }else{
      out.write("\r\n");
      out.write("<input type=button id=\"next\" name=\"next\" value=\"Prev Message\" onclick=\"reload1()\" disabled=\"disabled\">\r\n");
}if((Integer)session.getAttribute("BrCount")==msgs.size()){ 
      out.write("\r\n");
      out.write("<input type=button id=\"next\" name=\"next\" value=\"Next Message\" onclick=\"reload()\" disabled=\"disabled\">");
}else{ 
      out.write("\r\n");
      out.write("<input type=button id=\"next\" name=\"next\" value=\"Next Message\" onclick=\"reload()\">");
} 
      out.write("\r\n");
      out.write("<br><br><input type=button id=\"next\" name=\"next\" value=\"Get Messages\" onclick=\"getMsg()\">\r\n");
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
