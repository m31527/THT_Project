<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.util.Lauar"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>秋季禮斗法會名冊</title>
<style type="text/css">
	.table_style_2{
		width:41.91cm ;height: 29.72cm;border-color: black;
	}
	
	.table_style_2 td{
		width: 1cm;font-size: 14pt;
	}
	.word_style{
		writing-mode:tb-rl; width:20px;
	}
</style>
</head>
<body>
<div align="center" style="font-size: 35pt">
	<%=Lauar.cyclical(2011) %>年秋季禮斗法會名冊
</div>
<table class="table_style_2" border="1" bordercolor="#000000" cellpadding="0" cellspacing="0">
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2" style="height: 2cm;">
			<p class="word_style"><%=i %></p>
		</td>
		<%} %>
	</tr>
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2" style="height: 13.5cm;">
			<p class="word_style">桃園縣中壢市元化路二段11號</p>
		</td>
		<%} %>
	</tr>
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2" style="height: 3.5cm;">
			<p class="word_style">張先生</p>
		</td>
		<%} %>
	</tr>
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2" style="height: 3cm;">
			<p class="word_style" >男</p>
		</td>
		<%} %>
	</tr>
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2" style="height: 5.02cm;">
			<p class="word_style" style="color: white;">張先生</p>
		</td>
		<%} %>
	</tr>
	<tr>
		<%for(int i=1;i<=52;i++){ %>
		<td class="table_style_2">
			<p class="word_style" style="color: white;">張先生</p>
		</td>
		<%} %>
	</tr>
</table>
</body>
</html>