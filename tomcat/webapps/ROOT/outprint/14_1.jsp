<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.tht.action.Active"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tht.person.Relation"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tht.person.People"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>秋季禮斗法會貼紙</title>
<style type="text/css">
	.table_sytle{
		width: 29.8cm;height: 21cm;
	}
	.table_sytle td{
		width:3.3cm;height: 9.5cm;background: white;table-layout:fixed;
	}
	.div1{
		float: right;padding-right: 60px;font-size: 13pt;
	}
	
	.div1p{
		writing-mode:tb-rl; width:10px;
		white-space: pre; /* CSS2 */
white-space: -moz-pre-wrap; /* Mozilla */
white-space: -hp-pre-wrap; /* HP printers */
white-space: -o-pre-wrap; /* Opera 7 */
white-space: -pre-wrap; /* Opera 4-6 */
white-space: pre-wrap; /* CSS 2.1 */
white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */
/*word-wrap: break-word;*/ 	 /*IE */
	}
		body{
		margin:0 auto;
	}
	
	.div1pwhite{
		writing-mode:tb-rl; width:20px;background:white;
	}
	
	.div2{
		float: right;padding-right: 10px;font-size: 20pt;
	}
	
	.div2white{
		float: right;padding-right: 50px;font-size: 30pt;background: white;
	}
	.div2p{
		writing-mode:tb-rl; width:40px;
		white-space: pre; /* CSS2 */
white-space: -moz-pre-wrap; /* Mozilla */
white-space: -hp-pre-wrap; /* HP printers */
white-space: -o-pre-wrap; /* Opera 7 */
white-space: -pre-wrap; /* Opera 4-6 */
white-space: pre-wrap; /* CSS 2.1 */
white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */
word-wrap: break-word; /* IE */
	}
	
	.div3p{
		font-size: 20pt;
				writing-mode:tb-rl; width:40px;
		white-space: pre; /* CSS2 */
white-space: -moz-pre-wrap; /* Mozilla */
white-space: -hp-pre-wrap; /* HP printers */
white-space: -o-pre-wrap; /* Opera 7 */
white-space: -pre-wrap; /* Opera 4-6 */
white-space: pre-wrap; /* CSS 2.1 */
white-space: pre-line; /* CSS 3 (and 2.1 as well, actually) */
word-wrap: break-word; /* IE */
 width: 10px;
  padding-left: 2px;
	}
</style>
</head>
<body>
<%

	float totalpic=16;
	String active_year=request.getParameter("active_year")==null?"2011":request.getParameter("active_year");
	int active_kind_id=request.getParameter("active_kind_id")==null?14:Integer.parseInt(request.getParameter("active_kind_id"));

	Active actbean=new Active();
	ArrayList<Active> activeList=new ArrayList<Active>();
	activeList=actbean.findByActiveIdAndStartToEnd(active_kind_id,active_year+"-01-01",active_year+"-12-31");

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
%>
<%
int tpc=0;
for(int i=1;i<=pages;i++){
%>
<div style="page-break-after: always;margin-left: -10px;padding-left: 0;" >
<table class="table_sytle">
	<tr valign="top">
		<%
		for(int j=1;j<=(int)totalpic;j++){ 
			if(outprintPeopleList.size()>tpc){
		%>
		<td >
			<table>
				<tr>
					<td valign="top"><div class="div3p"><%=((People)outprintPeopleList.get(tpc)).getPeople_name()%><span style="color: white;visibility : hidden;">空白</span>大德</div></td>
					<td valign="top"><div class="div1"><p class="div1p"><%=((People)outprintPeopleList.get(tpc)).getPeople_address()%></p></div></td>
				</tr>
			</table>
					</td>
		<%}else{ %>
		<td >
			<div class="div1"><p class="div1p"><span style="color: white;">桃園縣中壢市元化路二段11號</span></p></div>
			<div class="div2"><p class="div2p"><span style="color: white;">張先生空白大德</span></p></div>
		</td>
		<%} %>		
		<%
		if(j==8){
		%>
		</tr>
		<tr valign="top">
		<%}%>
		<%tpc++; %>
		<%}%>
	</tr>
</table>
</div>
<%} %>
<!--  
<div style="page-break-after: always;">
<table class="table_sytle">
	<tr>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>										
	</tr>
	<tr>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>
		<td >
			<div class="div1"><p class="div1p">桃園縣中壢市元化路二段11號</p></div>
			<div class="div2"><p class="div2p">張先生<span style="color: white;">空白</span>大德</p></div>
		</td>	
	</tr>
</table>
</div>
-->
</body>
</html>