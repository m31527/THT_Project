package org.apache.jsp.outprint;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tht.action.Active;
import java.util.ArrayList;
import java.util.HashMap;
import com.tht.person.Relation;
import java.util.Iterator;
import com.tht.person.People;

public final class _14_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<title>秋季禮斗法會貼紙</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\t.table_sytle{\n");
      out.write("\t\twidth: 29.8cm;height: 21cm;\n");
      out.write("\t}\n");
      out.write("\t.table_sytle td{\n");
      out.write("\t\twidth:3.3cm;height: 9.5cm;background: white;table-layout:fixed;\n");
      out.write("\t}\n");
      out.write("\t.div1{\n");
      out.write("\t\tfloat: right;padding-right: 60px;font-size: 13pt;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div1p{\n");
      out.write("\t\twriting-mode:tb-rl; width:10px;\n");
      out.write("\t\twhite-space: pre; /* CSS2 */\n");
      out.write("white-space: -moz-pre-wrap; /* Mozilla */\n");
      out.write("white-space: -hp-pre-wrap; /* HP printers */\n");
      out.write("white-space: -o-pre-wrap; /* Opera 7 */\n");
      out.write("white-space: -pre-wrap; /* Opera 4-6 */\n");
      out.write("white-space: pre-wrap; /* CSS 2.1 */\n");
      out.write("white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */\n");
      out.write("/*word-wrap: break-word;*/ \t /*IE */\n");
      out.write("\t}\n");
      out.write("\t\tbody{\n");
      out.write("\t\tmargin:0 auto;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div1pwhite{\n");
      out.write("\t\twriting-mode:tb-rl; width:20px;background:white;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div2{\n");
      out.write("\t\tfloat: right;padding-right: 10px;font-size: 20pt;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div2white{\n");
      out.write("\t\tfloat: right;padding-right: 50px;font-size: 30pt;background: white;\n");
      out.write("\t}\n");
      out.write("\t.div2p{\n");
      out.write("\t\twriting-mode:tb-rl; width:40px;\n");
      out.write("\t\twhite-space: pre; /* CSS2 */\n");
      out.write("white-space: -moz-pre-wrap; /* Mozilla */\n");
      out.write("white-space: -hp-pre-wrap; /* HP printers */\n");
      out.write("white-space: -o-pre-wrap; /* Opera 7 */\n");
      out.write("white-space: -pre-wrap; /* Opera 4-6 */\n");
      out.write("white-space: pre-wrap; /* CSS 2.1 */\n");
      out.write("white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */\n");
      out.write("word-wrap: break-word; /* IE */\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div3p{\n");
      out.write("\t\tfont-size: 20pt;\n");
      out.write("\t\t\t\twriting-mode:tb-rl; width:40px;\n");
      out.write("\t\twhite-space: pre; /* CSS2 */\n");
      out.write("white-space: -moz-pre-wrap; /* Mozilla */\n");
      out.write("white-space: -hp-pre-wrap; /* HP printers */\n");
      out.write("white-space: -o-pre-wrap; /* Opera 7 */\n");
      out.write("white-space: -pre-wrap; /* Opera 4-6 */\n");
      out.write("white-space: pre-wrap; /* CSS 2.1 */\n");
      out.write("white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */\n");
      out.write("word-wrap: break-word; /* IE */\n");
      out.write(" width: 10px;\n");
      out.write("  padding-left: 2px;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");


	float totalpic=16;
	String active_year=request.getParameter("active_year")==null?"2011":request.getParameter("active_year");
	int active_kind_id=request.getParameter("active_kind_id")==null?14:Integer.parseInt(request.getParameter("active_kind_id"));

	Active actbean=new Active();
	ArrayList<Active> activeList=new ArrayList<Active>();
	activeList=actbean.findByActiveIdAndStartToEnd(active_kind_id,active_year+"-01-31",active_year+"-12-31");

	HashMap<Long,Long> total_peoplelist=new HashMap<Long,Long>();
	//先把people id 塞到HashMap
	for(Active abean:activeList){
		total_peoplelist.put(abean.getPeople_id(),abean.getPeople_id());
	}
	
	//刪減用戶假設遇到戶主，只保留戶主
	for(Active abean:activeList){
		Relation rebean=new Relation();
		rebean=rebean.findByMainId(abean.getPeople_id());
		if(rebean!=null){
			if(total_peoplelist.containsKey(rebean.getMain_people_id())){
				total_peoplelist.remove(rebean.getPeople_id());
			}
		}
		
	}

	ArrayList<People> outprintPeopleList= new ArrayList<People>();
	
	Iterator<Long> it = total_peoplelist.values().iterator();
	while (it.hasNext()) {
		People bean=new People();
		bean=bean.findByPK(it.next());
		outprintPeopleList.add(bean);
	}


	//算有幾頁 totalpic= 14(14張/頁)
	float pages= 1;
	
		if(outprintPeopleList.size()>totalpic){
			float temppages=(float)outprintPeopleList.size()/totalpic;
			pages=(float)Math.ceil(temppages);
		}

      out.write('\n');

int tpc=0;
for(int i=1;i<=pages;i++){

      out.write("\n");
      out.write("<div style=\"page-break-after: always;margin-left: -10px;padding-left: 0;\" >\n");
      out.write("<table class=\"table_sytle\">\n");
      out.write("\t<tr valign=\"top\">\n");
      out.write("\t\t");

		for(int j=1;j<=(int)totalpic;j++){ 
			if(outprintPeopleList.size()>tpc){
		
      out.write("\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<table>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td valign=\"top\"><div class=\"div3p\">");
      out.print(((People)outprintPeopleList.get(tpc)).getPeople_name());
      out.write("<span style=\"color: white;visibility : hidden;\">空白</span>大德</div></td>\n");
      out.write("\t\t\t\t\t<td valign=\"top\"><div class=\"div1\"><p class=\"div1p\">");
      out.print(((People)outprintPeopleList.get(tpc)).getPeople_address());
      out.write("</p></div></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t");
}else{ 
      out.write("\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\"><span style=\"color: white;\">桃園縣中壢市元化路二段11號</span></p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\"><span style=\"color: white;\">張先生空白大德</span></p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");
} 
      out.write("\t\t\n");
      out.write("\t\t");

		if(j==8){
		
      out.write("\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr valign=\"top\">\n");
      out.write("\t\t");
}
      out.write('\n');
      out.write('	');
      out.write('	');
tpc++; 
      out.write('\n');
      out.write('	');
      out.write('	');
}
      out.write("\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
} 
      out.write("\n");
      out.write("<!--  \n");
      out.write("<div style=\"page-break-after: always;\">\n");
      out.write("<table class=\"table_sytle\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t</tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t<td >\n");
      out.write("\t\t\t<div class=\"div1\"><p class=\"div1p\">桃園縣中壢市元化路二段11號</p></div>\n");
      out.write("\t\t\t<div class=\"div2\"><p class=\"div2p\">張先生<span style=\"color: white;\">空白</span>大德</p></div>\n");
      out.write("\t\t</td>\t\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("-->\n");
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
