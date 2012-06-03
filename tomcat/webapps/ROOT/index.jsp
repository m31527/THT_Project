<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>妙華慈惠堂管理系統</title>
<link type='text/css' rel='stylesheet' href='/css/form_style.css' />
<script type="text/javascript">
function outprint(){
	var path=document.outprintform.active_kind_id.value
	var kind=document.outprintform.active_kind_id.value;
	if(kind==14){
		path=path+"_1.jsp"
	}else if(kind==13){
		path="do.jsp"
	}else if(kind==11){	
		path="11_1.jsp"
	}else{
		path=path+".jsp"
	}
	document.outprintform.action="outprint/"+path;
	document.outprintform.active_kind_id.value=kind;
	document.outprintform.submit();
}
</script>
</head>
<body>
<%@include file="header.jsp" %>
<table align="center">
	<tr>
		<td>
		<div id="stylized" class="myform">
			<form id="seachform" name="seachform" method="post" action="PeopleServlet?action=QueryByName">
				<h1>搜尋信徒</h1>
				<p>輸入姓名來尋找信徒</p>

				<label>姓名 <span class="small">輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name" />
				<button type="submit">搜尋</button>
				<div class="spacer"></div>
			</form>
		</div>	
		</td>

		<td>
		<div id="stylized" class="myform">
			<form id="addform" name="addform" method="post" action="PeopleServlet?action=AddPeoplePage">
				<h1>信徒建檔</h1>
				<p>輸入信徒個人資訊</p>
				<label>姓名 <span class="small">輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name" />
				<button type="submit">建檔</button>
				<div class="spacer"></div>
		</form>
		</div>
		</td>
	</tr>
	<tr>
		<td>
				<div id="stylized" class="myform">
			<form id="outprintform" name="outprintform" method="post" action="">
				<h1>列印</h1>
				<p>選擇格式</p>

				<label>年 <span class="small">選擇年度</span> </label> 
				<select name="active_year">
					<%
						Date date=new Date();
						int y=date.getYear()+1900;
					%>
					<option value="<%=y-1 %>"><%=y-1 %></option>
					<option value="<%=y %>" selected="selected"><%=y %></option>
					<option value="<%=y+1 %>"><%=y+1 %></option>
				</select>
				<label>儀式<span class="small"></span> </label> 
				<select name="active_kind_id">
					<option value="14">秋季禮斗法會</option>
					<option value="13">春季禮斗法會</option>
					<option value="11">年度祭改</option>
					<option value="letter">信封貼紙</option>
				</select>
				<button type="button" onClick="outprint()">開始產生</button>
				<div class="spacer"></div>
			</form>
		</div>	
		</td>
	</tr>
</table>
</body>
</html>