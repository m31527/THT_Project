<%@page import="java.util.List"%>
<%@page import="com.test.PeopleImp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.tht.action.Active"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tht.person.Relation"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tht.person.People"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>秋季禮斗法會貼紙</title>
<style type="text/css">

		.table_sytle{
		height:29.8cm;width: 21cm;
		margin: 0;
		padding: 0;
		font-weight:bold;
		font-family:'標楷體'
	}
	
	.table_sytle tr{		
		valign:top
	}
	
	.div1{
		font-size: 15pt;
		padding-left: 5px;
		font-weight:bold;
		text-align: left;
		font-family:'標楷體'
	}
	
	.div2{
		font-size: 20pt;
		font-weight:bold;
		font-family:'標楷體'
	}
	
</style>
</head>
<body style="margin: 0 auto;">
<%
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
%>
<%
int tpc=0;
for(int i=1;i<=pages;i++){
%>
<div style="page-break-after: always;">
<table class="table_sytle">
	<%
		for(int j=1;j<=(int)totalpic;j++){ 
			if(outprintPeopleList.size()>tpc){
		%>
	<%if((j-1)%2==0){ %>
	<tr valign="top">
	<%} %>
		<td WIDTH=50% height="12.5%">
		<div style="overflow:auto">
			<div class="div1" <%if(j==1||j==2){%>style="padding-top: 8px;padding-left:11px;padding-right:11px;"<%}else{%>style="padding-left:11px;padding-right:11px;"<%}%>><%=((People)outprintPeopleList.get(tpc)).getPeople_address()%></div>
			<div class="div2">&nbsp;&nbsp;&nbsp;&nbsp;<%=((People)outprintPeopleList.get(tpc)).getPeople_name()%>&nbsp;&nbsp;大德</div>
		</div>
		</td>
	<%if(j%2==0){%>	
	</tr>	
	<%} %>
	<%} %>
	<%
	tpc++;
		} %>				
</table>
</div>
<%} %>
</body>
</html>