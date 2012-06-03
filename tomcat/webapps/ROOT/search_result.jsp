<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.tht.person.People"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜尋信徒結果</title>
<link type='text/css' rel='stylesheet' href='/css/form_style.css' />
<script type="text/javascript">
	function search(){
			var people_name=document.searchResultForm.people_name.value;
			if(people_name==''){
				alert("請輸入姓名搜尋")
			}else{
				document.searchResultForm.submit();
			}
	}
	function goCreate(){
		var people_name=document.searchResultForm.people_name.value;
		location.href='PeopleServlet?action=GoAddPeople&people_name='+people_name;
	}
	
	function delete_people(ppid){
		//document.formlist.ppid.value=ppid
		document.formlist.action.value="DeletePeople";
		document.formlist.people_id.value=ppid;
		var answer = confirm("確定要刪除嗎");
		if (answer){
			document.formlist.submit();
		}
	}
</script>
</head>
<body>
<%@include file="header.jsp" %>
<%
	String people_name=session.getAttribute("people_name")==null?"":(String)session.getAttribute("people_name");
	ArrayList<People> search_result=session.getAttribute("search_result")==null?new ArrayList<People>():(ArrayList<People>)session.getAttribute("search_result");
%>
		<div id="stylized" class="myform">
			<form id="searchResultForm" name="searchResultForm" method="post" action="PeopleServlet?action=QueryByName">
				<h1>搜尋信徒</h1>
				<p>輸入姓名來尋找信徒</p>

				<label>姓名 <span class="small">輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name" value="<%=people_name %>"/>
				<button type="button" onclick="search();">搜尋</button>
				<div class="spacer" style="padding-bottom: 20px;"></div>
				<button type="button" onclick="goCreate();">建檔</button>
				<div class="spacer"></div>
			</form>
		</div>	
	
		<div id="styliz_searchrs" class="searchform" style="margin: 20px auto 0;">
			<form id="form" name="formlist" method="post" action="PeopleServlet">
				<h1>搜尋結果</h1>
				<p>共找到<%=search_result.size() %>筆符合條件資料</p>
					<table width="100%" class="search_table">
						<tr style="font-size: 17px;">
							<td>姓名</td>
							<td>生日</td>
							<td>地址</td>
							<td></td>
							<td></td>
						</tr>
						<%for(People bean:search_result){ %>
						<tr>
							<td><%=bean.getPeople_name() %></td>
							<td><%=bean.getPeople_birthday() %></td>
							<td><%=bean.getPeople_address() %></td>
							<td><button type="button" onclick="location.href='PeopleServlet?action=DetailPeople&people_id=<%=bean.getPeople_id()%>'">詳細</button></td>
							<%if(user_name.equals("m31527") || user_name.equals("paula")){ %>
							<td><button type="button" onclick="delete_people('<%=bean.getPeople_id()%>')">刪除</button></td>
							<%} %>
						</tr>
						<%}%>
					</table>
					<input type="hidden" name="people_id">
					<input type="hidden" name="action">
			</form>
		</div>	
</body>
</html>