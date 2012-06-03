<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>妙華慈惠堂信徒管理系統</title>
<link type='text/css' rel='stylesheet' href='/css/form_style.css' /> 

</head>
<body>
<div id="stylized" class="myform">
<form id="login_form" name="login_form" method="post" action="PeopleServlet?action=Login">
<h1>系統登入</h1>
<p>請輸入您的帳號密碼</p>
<%if(request.getAttribute("message")!=null){ %>
<span style="color: red;"><%=(String)request.getAttribute("message") %></span>
<%} %>
<label>帳號
<span class="small">輸入帳號</span>
</label>
<input type="text" name="user_name" id="user_name" />

<label>密碼
<span class="small">輸入密碼</span>
</label>
<input type="password" name="user_password" id="user_password" />

<button type="submit">登入</button>
<div class="spacer"></div>

</form>
</div>
</body>
</html>