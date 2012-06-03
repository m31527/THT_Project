package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/header.jsp");
  }

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
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>妙華慈惠堂管理系統</title>\n");
      out.write("<link type='text/css' rel='stylesheet' href='/css/form_style.css' />\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function outprint(){\n");
      out.write("\tvar path=document.outprintform.active_kind_id.value\n");
      out.write("\tvar kind=document.outprintform.active_kind_id.value;\n");
      out.write("\tif(kind==14){\n");
      out.write("\t\tpath=path+\"_1.jsp\"\n");
      out.write("\t}else if(kind==13){\n");
      out.write("\t\tpath=\"do.jsp\"\n");
      out.write("\t}else if(kind==11){\t\n");
      out.write("\t\tpath=\"11_1.jsp\"\n");
      out.write("\t}else{\n");
      out.write("\t\tpath=path+\".jsp\"\n");
      out.write("\t}\n");
      out.write("\tdocument.outprintform.action=\"outprint/\"+path;\n");
      out.write("\tdocument.outprintform.active_kind_id.value=kind;\n");
      out.write("\tdocument.outprintform.submit();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("</head>\n");

	String user_name="";
	if(session.getAttribute("user_name")==null){
		response.sendRedirect("login.jsp");
	}else{
		user_name=session.getAttribute("user_name")==null?"":(String)session.getAttribute("user_name");
	}

      out.write("\n");
      out.write("<body>\n");
      out.write("<div style=\"background: none repeat scroll 0 0 #EBF4FB;height: 100px;\">\n");
      out.write("\t<div style=\"font-size: 35px;padding-top: 28px;padding-left: 20px;\">妙華慈惠堂管理系統</div>\n");
      out.write("\t<div style=\"float: right;padding-right: 20px;\">");
if(!user_name.equals("")){ 
      out.print(user_name);
      out.write("<a href=\"PeopleServlet?action=LoginOut\" style=\"font-size: 20px;\">登出</a>");
} 
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"index.jsp\" style=\"font-size: 20px;\">回首頁</a></div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("<table align=\"center\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t<div id=\"stylized\" class=\"myform\">\n");
      out.write("\t\t\t<form id=\"seachform\" name=\"seachform\" method=\"post\" action=\"PeopleServlet?action=QueryByName\">\n");
      out.write("\t\t\t\t<h1>搜尋信徒</h1>\n");
      out.write("\t\t\t\t<p>輸入姓名來尋找信徒</p>\n");
      out.write("\n");
      out.write("\t\t\t\t<label>姓名 <span class=\"small\">輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_name\" id=\"people_name\" />\n");
      out.write("\t\t\t\t<button type=\"submit\">搜尋</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\t\n");
      out.write("\t\t</td>\n");
      out.write("\n");
      out.write("\t\t<td>\n");
      out.write("\t\t<div id=\"stylized\" class=\"myform\">\n");
      out.write("\t\t\t<form id=\"addform\" name=\"addform\" method=\"post\" action=\"PeopleServlet?action=AddPeoplePage\">\n");
      out.write("\t\t\t\t<h1>信徒建檔</h1>\n");
      out.write("\t\t\t\t<p>輸入信徒個人資訊</p>\n");
      out.write("\t\t\t\t<label>姓名 <span class=\"small\">輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_name\" id=\"people_name\" />\n");
      out.write("\t\t\t\t<button type=\"submit\">建檔</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t\t\t<div id=\"stylized\" class=\"myform\">\n");
      out.write("\t\t\t<form id=\"outprintform\" name=\"outprintform\" method=\"post\" action=\"\">\n");
      out.write("\t\t\t\t<h1>列印</h1>\n");
      out.write("\t\t\t\t<p>選擇格式</p>\n");
      out.write("\n");
      out.write("\t\t\t\t<label>年 <span class=\"small\">選擇年度</span> </label> \n");
      out.write("\t\t\t\t<select name=\"active_year\">\n");
      out.write("\t\t\t\t\t");

						Date date=new Date();
						int y=date.getYear()+1900;
					
      out.write("\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(y-1 );
      out.write('"');
      out.write('>');
      out.print(y-1 );
      out.write("</option>\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(y );
      out.write("\" selected=\"selected\">");
      out.print(y );
      out.write("</option>\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(y+1 );
      out.write('"');
      out.write('>');
      out.print(y+1 );
      out.write("</option>\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t<label>儀式<span class=\"small\"></span> </label> \n");
      out.write("\t\t\t\t<select name=\"active_kind_id\">\n");
      out.write("\t\t\t\t\t<option value=\"14\">秋季禮斗法會</option>\n");
      out.write("\t\t\t\t\t<option value=\"13\">春季禮斗法會</option>\n");
      out.write("\t\t\t\t\t<option value=\"11\">年度祭改</option>\n");
      out.write("\t\t\t\t\t<option value=\"letter\">信封貼紙</option>\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t<button type=\"button\" onClick=\"outprint()\">開始產生</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\t\n");
      out.write("\t\t</td>\n");
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
