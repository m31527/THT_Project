package org.apache.jsp.outprint;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Lauar;

public final class _14_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>秋季禮斗法會名冊</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t.table_style_2{\n");
      out.write("\t\twidth:41.91cm ;height: 29.72cm;border-color: black;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.table_style_2 td{\n");
      out.write("\t\twidth: 1cm;font-size: 14pt;\n");
      out.write("\t}\n");
      out.write("\t.word_style{\n");
      out.write("\t\twriting-mode:tb-rl; width:20px;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div align=\"center\" style=\"font-size: 35pt\">\n");
      out.write("\t");
      out.print(Lauar.cyclical(2011) );
      out.write("年秋季禮斗法會名冊\n");
      out.write("</div>\n");
      out.write("<table class=\"table_style_2\" border=\"1\" bordercolor=\"#000000\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\" style=\"height: 2cm;\">\n");
      out.write("\t\t\t<p class=\"word_style\">");
      out.print(i );
      out.write("</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\" style=\"height: 13.5cm;\">\n");
      out.write("\t\t\t<p class=\"word_style\">桃園縣中壢市元化路二段11號</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\" style=\"height: 3.5cm;\">\n");
      out.write("\t\t\t<p class=\"word_style\">張先生</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\" style=\"height: 3cm;\">\n");
      out.write("\t\t\t<p class=\"word_style\" >男</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\" style=\"height: 5.02cm;\">\n");
      out.write("\t\t\t<p class=\"word_style\" style=\"color: white;\">張先生</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t");
for(int i=1;i<=52;i++){ 
      out.write("\n");
      out.write("\t\t<td class=\"table_style_2\">\n");
      out.write("\t\t\t<p class=\"word_style\" style=\"color: white;\">張先生</p>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
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
