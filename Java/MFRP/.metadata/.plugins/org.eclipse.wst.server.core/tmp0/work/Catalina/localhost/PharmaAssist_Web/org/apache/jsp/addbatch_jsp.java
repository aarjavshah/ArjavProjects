package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cts.pharma.dao.BatchDAO;

public final class addbatch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n");
      out.write("<html >\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!--  \r\n");
      out.write(" * CSS and Java Script\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 454580(Shivang Trivedi)\r\n");
      out.write(" * */ -->\r\n");
      out.write("<title>Pharma Assist</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/PharmaAssist/img/rx-logo-hi.ico\"></link>\r\n");
      out.write("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"fonts.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function display_c(){\r\n");
      out.write("\tvar refresh=1000; // Refresh rate in milli seconds\r\n");
      out.write("\tsetTimeout('display_ct()',refresh)\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("function display_ct() {\r\n");
      out.write("\tvar strcount;\r\n");
      out.write("\tvar x = new Date();\r\n");
      out.write("\tvar hour=x.getHours();\r\n");
      out.write("\r\n");
      out.write("\tif(hour>=0 && hour<12)\r\n");
      out.write("\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" am     \";\r\n");
      out.write("\t\r\n");
      out.write("\telse if(hour==12)\r\n");
      out.write("\t\tdocument.getElementById('time').innerHTML = hour + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\r\n");
      out.write("\telse\r\n");
      out.write("\tdocument.getElementById('time').innerHTML = (hour-12) + \":\"+ x.getMinutes() + \":\" +x.getSeconds() + \" pm     \";\t\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.getElementById('date').innerHTML = x.getDate() + \"-\"+ (x.getMonth()+1) + \"-\" +x.getFullYear() ;\r\n");
      out.write("\tdisplay_c();\r\n");
      out.write("\t }\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("function validate()\r\n");
      out.write("{\r\n");
      out.write("\tvar weight=document.getElementById(\"weight\").value;\r\n");
      out.write("\tvar price=document.getElementById(\"price\").value;\r\n");
      out.write("\tvar select=document.getElementById(\"select\").value;\r\n");
      out.write("\tvar batchcode=document.getElementById(\"batchcode\").value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar flag=0;\r\n");
      out.write("\t\r\n");
      out.write("\tif(batchcode.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_batch\").innerHTML=\"Enter Batchcode\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\telse if(batchcode.length<8 || batchcode.length>16)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_batch\").innerHTML=\"Batchcode length must be between 8-16 characters\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\telse\r\n");
      out.write("\t{\tdocument.getElementById(\"span_batch\").innerHTML=\"\";\r\n");
      out.write("\t\t//flag=0;\r\n");
      out.write("\t}\t\r\n");
      out.write("\tif(weight.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_weight\").innerHTML=\"Enter Weight\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\telse if(isNaN(weight))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_weight\").innerHTML=\"Weight should be a Number\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(weight<=0 || weight>1500)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_weight\").innerHTML=\"Enter weight between 1-1500\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_weight\").innerHTML=\"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(price.length==0)\r\n");
      out.write("\t{\tdocument.getElementById(\"span_price\").innerHTML=\"Enter Price\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\telse if(isNaN(price))\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_price\").innerHTML=\"Price should be a Number\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\telse if(price<=0)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_price\").innerHTML=\"Price should be a greater than Zero\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\telse if(price > 999999)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_price\").innerHTML=\"Price should be a less than 999999\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_price\").innerHTML=\"\";\r\n");
      out.write("\t\t//flag=0;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(select==\"S\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_select\").innerHTML=\"Select an Option\";\r\n");
      out.write("\t\tflag=1;\r\n");
      out.write("\t}\t\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tdocument.getElementById(\"span_select\").innerHTML=\"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(flag==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\treturn true;\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function clean()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"span_batch\").innerHTML=\"\";\r\n");
      out.write("\tdocument.getElementById(\"span_weight\").innerHTML=\"\";\r\n");
      out.write("\tdocument.getElementById(\"span_price\").innerHTML=\"\";\r\n");
      out.write("\tdocument.getElementById(\"span_select\").innerHTML=\"\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function load()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\"You can learn more here................!!!!!:-)\";\r\n");
      out.write("\t\tdocument.getElementById(\"open\").innerHTML=\"\";\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"close\").innerHTML=\"...hide\";\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function unload()\r\n");
      out.write("{\r\n");
      out.write("\t\tdocument.getElementById(\"about\").innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById(\"open\").innerHTML=\"...learn more\";\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"close\").innerHTML=\"\";\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function reDirect()\r\n");
      out.write("{\r\n");
      out.write("window.location=\"welcome.jsp\";\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=display_ct();>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t<div id=\"header-wrapper\">\r\n");
      out.write("\t\t<div id=\"header\" class=\"container\">\r\n");
      out.write("\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\t<h1><a>Pharma Assist</a></h1>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<div id=\"menu\" class=\"container\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"welcome.jsp\">Welcome Page</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"contact.jsp\">Contact</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><a href=\"Logout.jsp\"><img src=\"");
      out.print( request.getContextPath());
      out.write("/img/logout-1.png\" height=\"40\" width=\"40\" alt=\"Add New Batch\"></img></a>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\"><font color=white>Welcome ");

	if(session.getAttribute("session_username")!=null)
	out.println(session.getAttribute("session_username").toString());
      out.write("</font>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"banner\">\r\n");
      out.write("<div style=\"height:75%;\" id=\"out_add\">\r\n");
      out.write("<div id=\"in_add\" style=\"text-align:=center;\">\r\n");
      out.write("\r\n");
      out.write("<!--  \r\n");
      out.write(" * AddBatch JSP page Business Logic\r\n");
      out.write(" * \r\n");
      out.write(" * @version 1\r\n");
      out.write(" * @author 454579(Fenil Tailor)\r\n");
      out.write(" * */ -->\r\n");
      out.write("\r\n");
 response.setHeader("Cache-Control","no-cache,no-store");  
 response.setHeader("Pragma","no-cache");
 response.setDateHeader ("Expires", 0);  

      out.write("\r\n");
      out.write("\r\n");

if((String)session.getAttribute("session_username")==null)
{
	response.sendRedirect("login.jsp");
}//out.print("Welcome"+(String)session.getAttribute("session_username")); 
      out.write("\r\n");
      out.write("<Form action=\"AddNewBatch\" method=\"post\" onsubmit=\"return validate()\">\r\n");
      out.write("<table>\r\n");
      out.write("<tr><td height=30px>BATCH CODE<sup><font color=red>*</font></sup><td><input type=text name=batchcode id=\"batchcode\" placeholder=\"Enter Batchcode\"><td><font color=red><span id=\"span_batch\"></span></font></td>\r\n");
      out.write("<tr><td height=30px>MEDICINE<sup><font color=red>*</font></sup><BR>CODE<td><select name=medicinecode>\r\n");

String medicine_code[]=new BatchDAO().getMedicineCodes();
for(int i=0;i<medicine_code.length;i++){
	out.println("<option value="+medicine_code[i]+">"+medicine_code[i]); 
}

      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("<tr><td height=30px>WEIGHT<sup><font color=red>*</font></sup><td><input type=text name=weight id=\"weight\" autocomplete=\"off\" placeholder=\"Enter Weight (1-1500)\"><td><font color=red><span id=\"span_weight\"></span></font></td>\r\n");
      out.write("<tr><td height=30px>PRICE<sup><font color=red>*</font></sup><td><input type=text name=price id=\"price\" autocomplete=\"off\" placeholder=\"Enter Price\"><td><font color=red><span id=\"span_price\"></span></font></td>\r\n");
      out.write("<tr><td height=30px>MEDICINE TYPE<sup><font color=red>*</font></sup><td ><select name=medicinetype id=\"select\">\r\n");
      out.write("<option value=\"S\" >--Select--\r\n");
      out.write("<option value=Tablets>Tablets\r\n");
      out.write("<option value=Capsule>Capsule\r\n");
      out.write("<option value=Syrup>Syrup\r\n");
      out.write("</select> <td><font color=red><span id=\"span_select\"></span></font></td>\r\n");
      out.write("<tr><td height=30px>REFRIGERATION<td><input type=radio name=refregeration value=Yes>YES<input type=radio name=refregeration value=No checked=checked>NO\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<table >\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=100px><input type=button name=cancl value=CANCEL onclick=\"reDirect()\">\r\n");
      out.write("<td width=100px><input type=reset name=clear value=CLEAR onclick=\"clean();\">\r\n");
      out.write("<td width=100px><input type=submit name=add value=ADD>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</br>\r\n");
      out.write("</Form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"copyright\" class=\"container\">\r\n");
      out.write("<div id=\"out_copy\">\r\n");
      out.write("<div id=\"in_copy\" style=\"text-align:=center;\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t&copy;copyright cognizant 2011-2020\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<img src=\"");
      out.print( request.getContextPath());
      out.write("/profile/cognizant.png\" height=\"50\" width=\"60\" alt=\"Add New Batch\"></img>\r\n");
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
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
