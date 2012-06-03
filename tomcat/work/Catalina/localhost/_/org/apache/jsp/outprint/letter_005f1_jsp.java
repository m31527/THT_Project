package org.apache.jsp.outprint;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.test.PeopleImp;
import com.tht.action.Active;
import java.util.ArrayList;
import java.util.HashMap;
import com.tht.person.Relation;
import java.util.Iterator;
import com.tht.person.People;

public final class letter_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
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
      out.write("<title>秋季禮斗法會貼紙</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("\n");
      out.write("\t\t.table_sytle{\n");
      out.write("\t\theight:29.8cm;width: 21cm;\n");
      out.write("\t\tmargin: 0;\n");
      out.write("\t\tpadding: 0;\n");
      out.write("\t\tfont-weight:bold;\n");
      out.write("\t\tfont-family:'標楷體'\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.table_sytle tr{\t\t\n");
      out.write("\t\tvalign:top\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div1{\n");
      out.write("\t\tfont-size: 15pt;\n");
      out.write("\t\tpadding-left: 5px;\n");
      out.write("\t\tfont-weight:bold;\n");
      out.write("\t\ttext-align: left;\n");
      out.write("\t\tfont-family:'標楷體'\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.div2{\n");
      out.write("\t\tfont-size: 20pt;\n");
      out.write("\t\tfont-weight:bold;\n");
      out.write("\t\tfont-family:'標楷體'\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body style=\"margin: 0 auto;\">\n");


	float totalpic=16;
	List<People> outprintPeopleList= new ArrayList<People>();
	People pbean=new People();
	outprintPeopleList=pbean.findMainAndMail();



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
      out.write("<div style=\"page-break-after: always;\" >\n");
      out.write("<table class=\"table_sytle\">\n");
      out.write("\t");

		for(int j=1;j<=(int)totalpic;j++){ 
			if(outprintPeopleList.size()>tpc){
		
      out.write('\n');
      out.write('	');
if((j-1)%2==0){ 
      out.write("\n");
      out.write("\t<tr valign=\"top\">\n");
      out.write("\t");
} 
      out.write("\n");
      out.write("\t\t<td WIDTH=50% height=\"12.5%\">\n");
      out.write("\t\t<div style=\"overflow:auto\">\n");
      out.write("\t\t\t<div class=\"div1\" ");
if(j==1||j==2){
      out.write("style=\"padding-top: 8px;padding-left:11px;padding-right:11px;\"");
}else{
      out.write("style=\"padding-left:11px;padding-right:11px;\"");
}
      out.write('>');
      out.print(((People)outprintPeopleList.get(tpc)).getPeople_address());
      out.write("</div>\n");
      out.write("\t\t\t<div class=\"div2\">&nbsp;&nbsp;&nbsp;&nbsp;");
      out.print(((People)outprintPeopleList.get(tpc)).getPeople_name());
      out.write("&nbsp;&nbsp;大德</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t</td>\n");
      out.write("\t");
if(j%2==0){ 
      out.write("\t\n");
      out.write("\t</tr>\t\n");
      out.write("\t");
} 
      out.write('\n');
      out.write('	');
} 
      out.write('	');
      out.write('\n');
      out.write('	');

	tpc++;
		} 
      out.write("\t\t\t\t\n");
      out.write("</table>\n");
      out.write("</div>\n");
} 
      out.write("\n");
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
