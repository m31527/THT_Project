<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.tht.person.People"%>
<%@page import="com.util.MyUtil"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜尋信徒結果</title>
<link type='text/css' rel='stylesheet' href='/css/form_style.css' />
<style type="text/css">
#styliz_searchrs input {
	float: left;
	font-size: 16px;
	padding: 4px 2px;
	border: solid 1px #aacfe4;
	width: 100px;
	margin: 2px 0 20px 10px;
}
</style>
<script type="text/javascript">
	function sendIdToJoin(id,search_state){
		document.people_search_result_from.people_id.value=id;
		document.people_search_result_from.search_state.value=search_state;
		document.people_search_result_from.submit();
	}
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<%
	String people_name=request.getAttribute("people_name_relation")==null?"":(String)request.getAttribute("people_name_relation");
	ArrayList<People> search_result=request.getAttribute("search_result_relation")==null?new ArrayList<People>():(ArrayList<People>)request.getAttribute("search_result_relation");
	Long main_people_id=request.getAttribute("main_people_id")==null?0:(Long)request.getAttribute("main_people_id");
	String search_state=request.getAttribute("search_state")==null?"":(String)request.getAttribute("search_state");
%>
		<div id="styliz_searchrs" class="searchform" style="margin: 20px auto 0;">
			<form id="people_search_result_from" name="people_search_result_from" method="post" action="PeopleServlet?action=JoinPeople">
				<h1>搜尋結果</h1>
				<p>共找到<%=search_result.size() %>筆符合條件資料</p>
					<table width="100%" class="search_table">
						<tr style="font-size: 17px;">
							<td>姓名</td>
							<td>生日</td>
							<td>地址</td>
							<td>稱謂</td>
							<td></td>
						</tr>
						<%for(People bean:search_result){ 
							if(bean.getPeople_id()!=main_people_id){
						%>
						<tr>
							<td><%=MyUtil.replaceNullForString(bean.getPeople_name()) %></td>
							<td><%=MyUtil.replaceNullForString(bean.getPeople_birthday()) %></td>
							<td><%=MyUtil.replaceNullForString(bean.getPeople_address()) %></td>
							<td><input type="text" name="dearname_<%=bean.getPeople_id() %>"></td>
							<td><button type="button" onclick="sendIdToJoin(<%=bean.getPeople_id()%>,'<%=search_state%>')">加入</button></td>
						</tr>
						<%} }%>
					</table>
					<input type="hidden" name="people_id" >
					<input type="hidden" name="main_people_id" value="<%=main_people_id %>">
					<input type="hidden" name="search_state" >
			</form>
		</div>	
</body>
</html>