<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<%
	String user_name="";
	if(session.getAttribute("user_name")==null){
		response.sendRedirect("login.jsp");
	}else{
		user_name=session.getAttribute("user_name")==null?"":(String)session.getAttribute("user_name");
	}
%>
<body>
<div style="background: none repeat scroll 0 0 #EBF4FB;height: 100px;">
	<div style="font-size: 35px;padding-top: 28px;padding-left: 20px;">妙華慈惠堂管理系統</div>
	<div style="float: right;padding-right: 20px;"><%if(!user_name.equals("")){ %><%=user_name%><a href="PeopleServlet?action=LoginOut" style="font-size: 20px;">登出</a><%} %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp" style="font-size: 20px;">回首頁</a></div>
</div>
</body>
</html>