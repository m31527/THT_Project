<%@page import="com.tht.person.People"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tht.action.Active"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tht.action.BidoKind"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String active_year=request.getParameter("active_year")==null?"2011":request.getParameter("active_year");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>春季拜斗名冊</title>
</head>
<body>
<table>
	
		<%
		Active bean=new Active();

        Object[]   key   =     BidoKind.list.keySet().toArray();  
        Arrays.sort(key);  
        for   (int   i   =   0;   i   <   key.length;   i++)   {  
        
%>
		<tr>
			<td>
				<ul>
					<li>(<%=key[i]%>)<%=BidoKind.list.get(key[i])%></li>
					<%
					ArrayList<Active> alist=bean.findByActiveIdAndActiveBidoIdAndStartToEnd(13, active_year+"-01-01", active_year+"-12-31",(Integer)key[i]);
					%>
					<ul>
					<% for(int j=0;j<alist.size();j++){ %>
						<li>
							<%
								People p=new People();
								p=p.findByPK(((Active)alist.get(j)).getPeople_id());
							%>
							<%=p.getPeople_name()%>&nbsp;&nbsp;<%if(p.getPeople_gender()==1){ %>男<%}else{ %>女<%} %>
						</li>
					<%} %>
					</ul>
				</ul>
				
			</td>
		</tr>
		<%} %>
	
</table>
</body>
</html>