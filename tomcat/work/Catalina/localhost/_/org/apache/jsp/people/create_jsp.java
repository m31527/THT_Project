package org.apache.jsp.people;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.lang.StringUtils;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>信徒建檔</title>\n");
      out.write("<link type='text/css' rel='stylesheet' href='/css/form_style.css' />\n");
      out.write("<script language=\"JavaScript\" src=\"../script/gen_validatorv4.js\" charset=\"utf-8\" type=\"text/javascript\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".myform {\n");
      out.write("    margin: 0 auto;\n");
      out.write("    padding: 14px;\n");
      out.write("    width: 500px;\n");
      out.write("}\n");
      out.write("#stylized input {\n");
      out.write("    border: 1px solid #AACFE4;\n");
      out.write("    float: left;\n");
      out.write("    font-size: 16px;\n");
      out.write("    margin: 2px 0 20px 10px;\n");
      out.write("    padding: 4px 2px;\n");
      out.write("    width: 300px;\n");
      out.write("}\n");
      out.write("#stylized select {\n");
      out.write("    border: 1px solid #AACFE4;\n");
      out.write("    float: left;\n");
      out.write("    font-size: 16px;\n");
      out.write("    margin: 2px 0 20px 10px;\n");
      out.write("    padding: 4px 2px;\n");
      out.write("    width: 300px;\n");
      out.write("}\n");
      out.write(".note {\n");
      out.write("    color: navy;\n");
      out.write("    font-size: 16px;\n");
      out.write("    margin: 0 auto;\n");
      out.write("    padding-bottom: 20px;\n");
      out.write("    padding-left: 20px;\n");
      out.write("    width: 200px;\n");
      out.write("}\n");
      out.write("</style>\n");
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

	String people_name="";
	if(request.getParameter("type")!=null){
		people_name=request.getAttribute("people_name")==null?"": (String)request.getAttribute("people_name");
	}

      out.write("\n");
      out.write("<table align=\"center\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td valign=\"top\">\n");
      out.write("\t\t<div id=\"stylized\" class=\"myform\" >\n");
      out.write("\t\t\t<form name=\"peopleForm\" id=\"peopleForm\" method=\"post\" action=\"../PeopleServlet?action=AddPeopleData\">\t\t\t\n");
      out.write("\t\t\t\t<h1>信徒建檔</h1>\n");
      out.write("\t\t\t\t<p>輸入信徒個人資訊</p>\n");
      out.write("\t\t\t\t<label>姓名 <span class=\"small\">輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_name\" id=\"people_name\" value=\"");
      out.print(people_name );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>出生日期 <span class=\"small\">輸入國曆年月日</span> </label> \n");
      out.write("\t\t\t\t<!-- \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_birthday\" id=\"people_birthday\" />\n");
      out.write("\t\t\t\t-->\n");
      out.write("\t\t\t<div style=\"float: left;width: 300px;\">\n");
      out.write("\t\t\t\t\t<table style=\"width: 300px;\">\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_birthday_year\" id=\"people_birthday_year\" />&nbsp;年&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_birthday_month\" id=\"people_birthday_month\" />&nbsp;月&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_birthday_day\" id=\"people_birthday_day\" />&nbsp;日&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>出生時辰 <span class=\"small\">下拉選擇</span> </label> \n");
      out.write("\t\t\t\t<select name=\"people_birthdayTime\" id=\"people_birthdayTime\">\n");
      out.write("\t\t\t\t\t<option value=\"吉\" selected=\"selected\">吉時</option>\n");
      out.write("\t\t\t\t\t<option value=\"子\">子時(23:00-01:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"丑\">丑時(01:00-03:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"寅\">寅時(03:00-05:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"卯\">卯時(05:00-07:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"辰\">辰時(07:00-09:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"巳\">巳時(09:00-11:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"午\">午時(11:00-13:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"未\">未時(13:00-15:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"申\">申時(15:00-17:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"酉\">酉時(17:00-19:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"戍\">戍時(19:00-21:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"亥\">亥時(21:00-23:00)</option>\t\t\t\t\t\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t<!--\n");
      out.write("\t\t\t\t<div id=\"people_lunerBirthday\" name=\"people_lunerBirthday\" class=\"note\" align=\"center\">系統會自行計算</div>\n");
      out.write("\t\t\t\t-->\n");
      out.write("\t\t\t\t<label>農曆 <span class=\"small\">若沒輸入會自動計算</span> </label> \t\t\t\t\n");
      out.write("\t\t\t\t<div style=\"float: left;width: 300px;\">\n");
      out.write("\t\t\t\t\t<table style=\"width: 300px;\">\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_lunerBirthday_year\" id=\"ppeople_lunerBirthday_year\" />&nbsp;年&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_lunerBirthday_month\" id=\"people_lunerBirthday_month\" />&nbsp;月&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 50px;\" name=\"people_lunerBirthday_day\" id=\"people_lunerBirthday_day\" />&nbsp;日&nbsp;</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<label>地址 <span class=\"small\">輸入地址</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_address\" id=\"people_address\" />\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>電話 <span class=\"small\">輸入電話</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_phone\" id=\"people_phone\" />\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>行動電話 <span class=\"small\">輸入行動電話</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_cellPhone\" id=\"people_cellPhone\" />\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>電子郵件<span class=\"small\">輸入郵件信箱</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_email\" id=\"people_email\" />\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>性別 <span class=\"small\">下拉選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_gender\" id=\"people_gender\">\n");
      out.write("\t\t\t\t\t\t<option value=\"9\" selected=\"selected\">請選擇性別</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"1\">男</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\">女</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t<!-- \n");
      out.write("\t\t\t\t<label>稱謂 <span class=\"small\">輸入稱謂(例如:父親)</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_salutation\" id=\"people_salutation\" />\n");
      out.write("\t\t\t\t -->\n");
      out.write("\t\t\t\t<label>是否為戶主 <span class=\"small\">請選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_main\" id=\"people_main\">\n");
      out.write("\t\t\t\t\t\t<option value=\"1\">是</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" selected=\"selected\">否</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t<label>是否願意收到邀請函 <span class=\"small\">請選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_sendmail\" id=\"people_sendmail\">\n");
      out.write("\t\t\t\t\t\t<option value=\"1\">是</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" selected=\"selected\">否</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t<button type=\"submit\">建檔</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t</td>\n");
      out.write("\t\t\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("\t\t\n");
      out.write("\t\t\t<script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("  \t\t\t\t\tvar frmvalidator  = new Validator(\"peopleForm\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_name\",\"req\",\"請輸入姓名\");\n");
      out.write(" \t\t\t\t\t\t//frmvalidator.addValidation(\"people_birthday\",\"req\",\"請輸入國曆出生年月日\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_address\",\"req\",\"請輸入地址\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_phone\",\"numeric\",\"電話請輸入數字\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_cellPhone\",\"numeric\",\"行動電話請輸入數字\");\t\t\t\t\t\t\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"gender\",\"dontselect=000\",\"請選擇性別\");\n");
      out.write(" \t\t\t\t\t\t\n");
      out.write("  \t\t\t\t\t\t//frmvalidator.addValidation(\"people_birthdayTime\",\"dontselect=000\",\"請選擇出生時辰\");  \n");
      out.write("    \t\t\t</script>\n");
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
