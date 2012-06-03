<%@page import="com.tht.person.People"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<div style="page-break-after: always;">
	<table border="1">
	<%
		People bean=new People();
	%>
		<%for(People pp:bean.list()){ %>
		<tr>
			<td><%=pp.getPeople_id()%></td>
			<td><%=pp.getPeople_name() %></td>
			<td><%=pp.getPeople_address()%></td>
		</tr>
		<%} %>
	</table>
</div>
</body>
</html>