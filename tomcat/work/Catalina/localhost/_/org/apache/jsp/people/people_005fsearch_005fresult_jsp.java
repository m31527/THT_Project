package org.apache.jsp.people;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.tht.person.People;
import com.util.MyUtil;

public final class people_005fsearch_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/people/../header.jsp");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>搜尋信徒結果</title>\n");
      out.write("<link type='text/css' rel='stylesheet' href='/css/form_style.css' />\n");
      out.write("<style type=\"text/css\">\n");
      out.write("#styliz_searchrs input {\n");
      out.write("\tfloat: left;\n");
      out.write("\tfont-size: 16px;\n");
      out.write("\tpadding: 4px 2px;\n");
      out.write("\tborder: solid 1px #aacfe4;\n");
      out.write("\twidth: 100px;\n");
      out.write("\tmargin: 2px 0 20px 10px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction sendIdToJoin(id,search_state){\n");
      out.write("\t\tdocument.people_search_result_from.people_id.value=id;\n");
      out.write("\t\tdocument.people_search_result_from.search_state.value=search_state;\n");
      out.write("\t\tdocument.people_search_result_from.submit();\n");
      out.write("\t}\n");
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
      out.write('\n');

	String people_name=request.getAttribute("people_name_relation")==null?"":(String)request.getAttribute("people_name_relation");
	ArrayList<People> search_result=request.getAttribute("search_result_relation")==null?new ArrayList<People>():(ArrayList<People>)request.getAttribute("search_result_relation");
	Long main_people_id=request.getAttribute("main_people_id")==null?0:(Long)request.getAttribute("main_people_id");
	String search_state=request.getAttribute("search_state")==null?"":(String)request.getAttribute("search_state");


      out.write("\n");
      out.write("\t\t<div id=\"styliz_searchrs\" class=\"searchform\" style=\"margin: 20px auto 0;\">\n");
      out.write("\t\t\t<form id=\"people_search_result_from\" name=\"people_search_result_from\" method=\"post\" action=\"PeopleServlet?action=JoinPeople\">\n");
      out.write("\t\t\t\t<h1>搜尋結果</h1>\n");
      out.write("\t\t\t\t<p>共找到");
      out.print(search_result.size() );
      out.write("筆符合條件資料</p>\n");
      out.write("\t\t\t\t\t<table width=\"100%\" class=\"search_table\">\n");
      out.write("\t\t\t\t\t\t<tr style=\"font-size: 17px;\">\n");
      out.write("\t\t\t\t\t\t\t<td>姓名</td>\n");
      out.write("\t\t\t\t\t\t\t<td>生日</td>\n");
      out.write("\t\t\t\t\t\t\t<td>地址</td>\n");
      out.write("\t\t\t\t\t\t\t<td>稱謂</td>\n");
      out.write("\t\t\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");
for(People bean:search_result){ 
							if(bean.getPeople_id()!=main_people_id){
						
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>");
if(bean.getPeople_main()==1){ 
      out.write("<img src=\"images/king.png\">");
}
      out.print(MyUtil.replaceNullForString(bean.getPeople_name()) );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(MyUtil.replaceNullForString(bean.getPeople_birthday()) );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(MyUtil.replaceNullForString(bean.getPeople_address()) );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"dearname_");
      out.print(bean.getPeople_id() );
      out.write("\"></td>\n");
      out.write("\t\t\t\t\t\t\t<td><button type=\"button\" onclick=\"sendIdToJoin(");
      out.print(bean.getPeople_id());
      out.write(',');
      out.write('\'');
      out.print(search_state);
      out.write("')\">加入</button></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");
} }
      out.write("\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"people_id\" >\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"main_people_id\" value=\"");
      out.print(main_people_id );
      out.write("\">\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"search_state\">\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\t\n");
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
