package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>妙華慈惠堂信徒管理系統</title>\n");
      out.write("<link type='text/css' rel='stylesheet' href='/css/form_style.css' /> \n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"stylized\" class=\"myform\">\n");
      out.write("<form id=\"login_form\" name=\"login_form\" method=\"post\" action=\"PeopleServlet?action=Login\">\n");
      out.write("<h1>系統登入</h1>\n");
      out.write("<p>請輸入您的帳號密碼</p>\n");
if(request.getAttribute("message")!=null){ 
      out.write("\n");
      out.write("<span style=\"color: red;\">");
      out.print((String)request.getAttribute("message") );
      out.write("</span>\n");
} 
      out.write("\n");
      out.write("<label>帳號\n");
      out.write("<span class=\"small\">輸入帳號</span>\n");
      out.write("</label>\n");
      out.write("<input type=\"text\" name=\"user_name\" id=\"user_name\" />\n");
      out.write("\n");
      out.write("<label>密碼\n");
      out.write("<span class=\"small\">輸入密碼</span>\n");
      out.write("</label>\n");
      out.write("<input type=\"password\" name=\"user_password\" id=\"user_password\" />\n");
      out.write("\n");
      out.write("<button type=\"submit\">登入</button>\n");
      out.write("<div class=\"spacer\"></div>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
