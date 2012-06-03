package org.apache.jsp.people;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tht.person.People;
import com.util.MyUtil;
import com.tht.person.Relation;
import java.util.Iterator;
import com.tht.action.ActiveKind;
import com.tht.action.Active;
import com.tht.action.BidoKind;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("<script type=\"text/javascript\">\n");
      out.write("function DeleteActive(active_id,people_id){\n");
      out.write("\tvar answer = confirm(\"確定刪除嗎?\")\n");
      out.write("\tif (answer){\n");
      out.write("\t\tdocument.active_modify_form.active_id.value=active_id;\n");
      out.write("\t\tdocument.active_modify_form.people_id.value=people_id;\n");
      out.write("\t\tdocument.active_modify_form.submit();\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("\n");
      out.write("function selectActive(){\n");
      out.write("\tvar active_kind_id=document.active_add_form.active_kind_id.value;\n");
      out.write("\tif(active_kind_id==\"14\" || active_kind_id==\"13\"){\n");
      out.write("\t\tdocument.getElementById('bido_div').style.display=\"\";\n");
      out.write("\t}\t\t\n");
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
      out.write('\n');

	People bean=request.getAttribute("bean")==null?new People():(People)request.getAttribute("bean");

      out.write("\n");
      out.write("<table align=\"center\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t<form id=\"seachform\" name=\"seachform\" method=\"post\" action=\"PeopleServlet?action=QueryByName\">\n");
      out.write("\t\t\t<div id=\"stylized\" class=\"myform\" style=\"width: 100%;height: 50px;\">\n");
      out.write("\t\t\t<label>搜尋 <span class=\"small\">輸入姓名</span> </label><input type=\"text\" name=\"people_name\" id=\"people_name\">\n");
      out.write("\t\t\t<button type=\"submit\">搜尋</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<!-- 個人基本資料 -->\n");
      out.write("\t\t<td valign=\"top\">\n");
      out.write("\t\t<div id=\"stylized\" class=\"myform\" >\n");
      out.write("\t\t\t<form name=\"peopleModifyForm\" id=\"peopleModifyForm\" method=\"post\" action=\"../PeopleServlet?action=ModifyPeople\">\t\t\t\n");
      out.write("\t\t\t\t<h1>信徒建檔</h1>\n");
      out.write("\t\t\t\t<p>輸入信徒個人資訊</p>\n");
      out.write("\t\t\t\t<label>姓名 <span class=\"small\">輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_name\" id=\"people_name\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_name()));
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>出生日期 <span class=\"small\">輸入國曆年月日</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_birthday\" id=\"people_birthday\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_birthday()));
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>出生時辰 <span class=\"small\">下拉選擇</span> </label> \n");
      out.write("\t\t\t\t<select name=\"people_birthdayTime\" id=\"people_birthdayTime\">\n");
      out.write("\t\t\t\t\t");

					String b_time=MyUtil.replaceNullForString(bean.getPeople_birthdayTime());
					
      out.write("\n");
      out.write("\t\t\t\t\t<option value=\"吉\" ");
if(b_time.equals("")){
      out.write("selected=\"selected\"");
}
      out.write(">吉時</option>\n");
      out.write("\t\t\t\t\t<option value=\"子\" ");
if(b_time.equals("子")){
      out.write("selected=\"selected\"");
}
      out.write(">子時(23:00-01:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"丑\" ");
if(b_time.equals("丑")){
      out.write("selected=\"selected\"");
}
      out.write(">丑時(01:00-03:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"寅\" ");
if(b_time.equals("寅")){
      out.write("selected=\"selected\"");
}
      out.write(">寅時(03:00-05:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"卯\" ");
if(b_time.equals("卯")){
      out.write("selected=\"selected\"");
}
      out.write(">卯時(05:00-07:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"辰\" ");
if(b_time.equals("辰")){
      out.write("selected=\"selected\"");
}
      out.write(">辰時(07:00-09:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"巳\" ");
if(b_time.equals("巳")){
      out.write("selected=\"selected\"");
}
      out.write(">巳時(09:00-11:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"午\" ");
if(b_time.equals("午")){
      out.write("selected=\"selected\"");
}
      out.write(">午時(11:00-13:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"未\" ");
if(b_time.equals("未")){
      out.write("selected=\"selected\"");
}
      out.write(">未時(13:00-15:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"申\" ");
if(b_time.equals("申")){
      out.write("selected=\"selected\"");
}
      out.write(">申時(15:00-17:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"酉\" ");
if(b_time.equals("酉")){
      out.write("selected=\"selected\"");
}
      out.write(">酉時(17:00-19:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"戍\" ");
if(b_time.equals("戍")){
      out.write("selected=\"selected\"");
}
      out.write(">戍時(19:00-21:00)</option>\n");
      out.write("\t\t\t\t\t<option value=\"亥\" ");
if(b_time.equals("亥")){
      out.write("selected=\"selected\"");
}
      out.write(">亥時(21:00-23:00)</option>\t\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t</select>\n");
      out.write("\t\t\t\t<label>農曆<span class=\"small\">輸入農曆生日</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_lunerBirthday\" id=\"people_lunerBirthday\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_lunerBirthday()) );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>地址 <span class=\"small\">輸入地址</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_address\" id=\"people_address\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_address()) );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>電話 <span class=\"small\">輸入電話</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_phone\" id=\"people_phone\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_phone()) );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>行動電話 <span class=\"small\">輸入行動電話</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_cellPhone\" id=\"people_cellPhone\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_cellPhone()) );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>電子郵件<span class=\"small\">輸入郵件信箱</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_email\" id=\"people_email\" value=\"");
      out.print(MyUtil.replaceNullForString(bean.getPeople_email()) );
      out.write("\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<label>性別 <span class=\"small\">下拉選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_gender\" id=\"people_gender\">\n");
      out.write("\t\t\t\t\t\t<option value=\"9\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==9){
      out.write(" selected=\"selected\"");
} 
      out.write(">請選擇性別</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"1\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==1){
      out.write(" selected=\"selected\"");
} 
      out.write(">男</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==0){
      out.write(" selected=\"selected\"");
} 
      out.write(">女</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t<!-- \n");
      out.write("\t\t\t\t<label>稱謂 <span class=\"small\">輸入稱謂(例如:父親)</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_salutation\" id=\"people_salutation\" value=\"兒子\"/>\n");
      out.write("\t\t\t\t -->\n");
      out.write("\t\t\t\t<label>是否為戶主 <span class=\"small\">請選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_main\" id=\"people_main\">\n");
      out.write("\t\t\t\t\t\t<option value=\"1\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){
      out.write(" selected=\"selected\"");
} 
      out.write(">是</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==0){
      out.write(" selected=\"selected\"");
} 
      out.write(">否</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t<label>是否願意收到邀請函 <span class=\"small\">請選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"people_sendmail\" id=\"people_sendmail\">\n");
      out.write("\t\t\t\t\t\t<option value=\"1\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_sendmail())==1){
      out.write(" selected=\"selected\"");
} 
      out.write(">是</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" ");
if(MyUtil.replaceNullForInteger(bean.getPeople_sendmail())==0){
      out.write(" selected=\"selected\"");
} 
      out.write(">否</option>\n");
      out.write("\t\t\t\t\t</select>\t\n");
      out.write("\t\t\t\t<button type=\"submit\">更新</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"people_id\" value=\"");
      out.print(bean.getPeople_id());
      out.write("\">\n");
      out.write("\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 其他家人 -->\n");
      out.write("\t\t<div id=\"styliz_searchrs\" class=\"searchform\" style=\"margin: 20px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"login_form\" name=\"form\" method=\"post\" action=\"index.jsp\">\n");
      out.write("\t\t\t\t<h1>同地址家人</h1>\n");
      out.write("\t\t\t\t\t<p>目前其他同地址家人清單</p>\n");
      out.write("\t\t\t\t\t<table class=\"search_table\" align=\"center\">\n");
      out.write("\t\t\t\t\t\t<tr style=\"font-size: 17px;\">\n");
      out.write("\t\t\t\t\t\t\t<td>稱呼</td>\n");
      out.write("\t\t\t\t\t\t\t<td>姓名</td>\n");
      out.write("\t\t\t\t\t\t\t<td>出生</td>\n");
      out.write("\t\t\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");

						int people_s=0;
						for(Relation rel_bean: bean.getRelation_list()){
						
								if(rel_bean.getSame_address()==0){
									if(bean.getPeople_id()!=rel_bean.getPeople_id()){
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
if(rel_bean.getPeople_id()==rel_bean.getMain_people_id()){
      out.write("<img src=\"images/king.png\">");
}
      out.print(rel_bean.getRelation_name() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><a href=\"PeopleServlet?action=DetailPeople&people_id=");
      out.print(rel_bean.getPeople_id());
      out.write('"');
      out.write('>');
      out.print(rel_bean.getPeople_name() );
      out.write("</a></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rel_bean.getPeople_birthday() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){
      out.write("<button type=\"button\" onclick=\"location.href='PeopleServlet?action=notJoinPeople&relation_id=");
      out.print(rel_bean.getRelation_id());
      out.write("&people_id=");
      out.print(bean.getPeople_id());
      out.write("'\">解除</button>");
} 
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
									}		
						}
						
      out.write("\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){
      out.write("\n");
      out.write("\t\t\t<!-- 新增其他家人 -->\n");
      out.write("\t\t\t<div id=\"stylized\" class=\"myform\"  style=\"margin: 20px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"insert_search_form\" name=\"insert_search_form\" method=\"post\" action=\"../PeopleServlet?action=QueryByNameForRelation\">\n");
      out.write("\t\t\t\t<h1>新增其他家人</h1>\n");
      out.write("\t\t\t\t\t<p>請用搜尋來尋找其他家人</p>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t<label>姓名<span class=\"small\">請輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"people_name\" id=\"people_name\"/>\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"main_people_id\" value=\"");
      out.print(bean.getPeople_id());
      out.write("\">\n");
      out.write("\t\t\t\t<button type=\"submit\">搜尋</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t \n");
      out.write("\t\t\t<!-- 不同地址 -->\n");
      out.write("\t\t<div id=\"styliz_searchrs\" class=\"searchform\" style=\"margin: 20px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"loginother_form\" name=\"loginother_form\" method=\"post\" action=\"index.jsp\">\n");
      out.write("\t\t\t\t<h1>不同地址家人</h1>\n");
      out.write("\t\t\t\t\t<p>目前不同地址家人清單</p>\n");
      out.write("\t\t\t\t\t<table class=\"search_table\" align=\"center\">\n");
      out.write("\t\t\t\t\t\t<tr style=\"font-size: 17px;\">\n");
      out.write("\t\t\t\t\t\t\t<td>稱呼</td>\n");
      out.write("\t\t\t\t\t\t\t<td>姓名</td>\n");
      out.write("\t\t\t\t\t\t\t<td>出生</td>\n");
      out.write("\t\t\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");

						int people_v=0;
						for(Relation rel_bean: bean.getRelation_list()){
								//不同地址家人=1
								if(rel_bean.getSame_address()==1){
									//if(bean.getPeople_id()!=rel_bean.getPeople_id()){
									
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
if(rel_bean.getPeople_id()==rel_bean.getMain_people_id()){
      out.write("<img src=\"images/king.png\">");
}
      out.print(rel_bean.getRelation_name() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><a href=\"PeopleServlet?action=DetailPeople&people_id=");
      out.print(rel_bean.getPeople_id());
      out.write('"');
      out.write('>');
      out.print(rel_bean.getPeople_name() );
      out.write("</a></td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(rel_bean.getPeople_birthday() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){
      out.write("<button type=\"button\" onclick=\"location.href='PeopleServlet?action=notJoinPeople&relation_id=");
      out.print(rel_bean.getRelation_id());
      out.write("&people_id=");
      out.print(bean.getPeople_id());
      out.write("'\">解除</button>");
} 
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
									//}		
						}
						
      out.write("\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){
      out.write("\n");
      out.write("\t\t\t<!-- 新增其他不同地址家人 -->\n");
      out.write("\t\t\t<div id=\"stylized\" class=\"myform\"  style=\"margin: 20px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"insert_search_other_form\" name=\"insert_search_other_form\" method=\"post\" action=\"../PeopleServlet?action=QueryByNameForOtherRelation\">\n");
      out.write("\t\t\t\t<h1>新增不同地址家人</h1>\n");
      out.write("\t\t\t\t\t<p>請用搜尋來尋找不同地址家人</p>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t<label>姓名<span class=\"small\">請輸入姓名</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"o_people_name\" id=\"o_people_name\"/>\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"main_people_id\" value=\"");
      out.print(bean.getPeople_id());
      out.write("\">\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"o_main_people_id\" value=\"");
      out.print(bean.getPeople_id());
      out.write("\">\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"search_state\" value=\"other\">\n");
      out.write("\t\t\t\t<button type=\"submit\">搜尋</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<!-- 用的服務 -->\n");
      out.write("\t\t<td valign=\"top\">\n");
      out.write("\t\t\t<div id=\"styliz_searchrs\" class=\"searchform\" style=\"margin: 50px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"active_modify_form\" name=\"active_modify_form\" method=\"post\" action=\"../PeopleServlet?action=DeleteActive\">\n");
      out.write("\t\t\t\t<h1>現有委託儀式</h1>\n");
      out.write("\t\t\t\t\t<p>目前該信徒委託儀式清單如下</p>\n");
      out.write("\t\t\t\t\t<table class=\"search_table\" align=\"center\">\n");
      out.write("\t\t\t\t\t\t<tr style=\"font-size: 17px;\">\n");
      out.write("\t\t\t\t\t\t\t<td>儀式</td>\n");
      out.write("\t\t\t\t\t\t\t<td>委託日期</td>\n");
      out.write("\t\t\t\t\t\t\t<td>備註</td>\n");
      out.write("\t\t\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");
for(Active a_bean: bean.getActive_list()){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(ActiveKind.list.get(a_bean.getActive_kind_id()));
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t\t");
if(a_bean.getActive_bido_id()!=0){
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t(");
      out.print(BidoKind.list.get(a_bean.getActive_bido_id()) );
      out.write(")\n");
      out.write("\t\t\t\t\t\t\t\t");
}
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(a_bean.getActive_create_date() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.print(a_bean.getActive_note()==null?"無":a_bean.getActive_note());
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t<td><button type=\"button\" onclick=\"DeleteActive(");
      out.print(a_bean.getActive_id());
      out.write(',');
      out.print(a_bean.getPeople_id() );
      out.write(")\">刪除</button></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"active_id\">\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"people_id\">\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- 新增委託儀式 -->\n");
      out.write("\t\t\t<div id=\"stylized\" class=\"myform\"  style=\"margin: 20px auto 0;width: 500px;\">\n");
      out.write("\t\t\t\t<form id=\"active_add_form\" name=\"active_add_form\" method=\"post\" action=\"../PeopleServlet?action=AddActive\">\n");
      out.write("\t\t\t\t<h1>新增委託儀式</h1>\n");
      out.write("\t\t\t\t\t<p>請指定委託儀式</p>\n");
      out.write("\t\t\t\t\t<label>選擇儀式 <span class=\"small\">下拉選擇</span> </label> \n");
      out.write("\t\t\t\t\t<select name=\"active_kind_id\" id=\"active_kind_id\" onchange=\"selectActive();\">\n");
      out.write("\t\t\t\t\t<option value=\"000\" selected=\"selected\">請選擇儀式</option>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t");

						Iterator<Integer> it = ActiveKind.list.keySet().iterator();
						while (it.hasNext()) {
							int num=it.next();

						
      out.write("\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(num);
      out.write('"');
      out.write('>');
      out.print(ActiveKind.list.get(num));
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t<div id=\"bido_div\" style=\"display: none;\">\n");
      out.write("\t\t\t\t<label>禮斗名<span class=\"small\">請選擇</span> </label>\n");
      out.write("\t\t\t\t\t<select name=\"active_bido_id\" id=\"active_bido_id\">\n");
      out.write("\t\t\t\t\t\t<option value=\"0\" selected=\"selected\">請選擇儀式</option>\n");
      out.write("\t\t\t\t\t");

						Iterator<Integer> it2 = BidoKind.list.keySet().iterator();
						while (it2.hasNext()) {
							int num=it2.next();

						
      out.write("\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(num );
      out.write('"');
      out.write('>');
      out.print(BidoKind.list.get(num));
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</div>\t\t\n");
      out.write("\t\t\t\t<label>委託日期 <span class=\"small\">請選擇日期</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"active_create_date\" id=\"active_create_date\" value=\"");
      out.print(MyUtil.getToday("yyyy-MM-dd"));
      out.write("\"/>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t<label>備註 <span class=\"small\">可註明備註事項</span> </label> \n");
      out.write("\t\t\t\t<input type=\"text\" name=\"active_note\" id=\"active_note\"/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<button type=\"submit\">新增</button>\n");
      out.write("\t\t\t\t<div class=\"spacer\"></div>\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"people_id\" value=\"");
      out.print(bean.getPeople_id());
      out.write("\">\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("</table>\t\t\n");
      out.write("\t\t\t<script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("  \t\t\t\t\tvar frmvalidator  = new Validator(\"peopleModifyForm\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_name\",\"req\",\"請輸入姓名\");\n");
      out.write(" \t\t\t\t\t\t//frmvalidator.addValidation(\"people_birthday\",\"req\",\"請輸入國曆出生年月日\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_address\",\"req\",\"請輸入地址\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_phone\",\"numeric\",\"電話請輸入數字\");\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"people_cellPhone\",\"numeric\",\"行動電話請輸入數字\");\t\n");
      out.write(" \t\t\t\t\t\tfrmvalidator.addValidation(\"gender\",\"dontselect=000\",\"請選擇性別\");\n");
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
