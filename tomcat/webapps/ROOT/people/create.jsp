<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.apache.commons.lang.StringUtils"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信徒建檔</title>
<link type='text/css' rel='stylesheet' href='/css/form_style.css' />
<script language="JavaScript" src="../script/gen_validatorv4.js" charset="utf-8" type="text/javascript"></script>
<style type="text/css">
.myform {
    margin: 0 auto;
    padding: 14px;
    width: 500px;
}
#stylized input {
    border: 1px solid #AACFE4;
    float: left;
    font-size: 16px;
    margin: 2px 0 20px 10px;
    padding: 4px 2px;
    width: 300px;
}
#stylized select {
    border: 1px solid #AACFE4;
    float: left;
    font-size: 16px;
    margin: 2px 0 20px 10px;
    padding: 4px 2px;
    width: 300px;
}
.note {
    color: navy;
    font-size: 16px;
    margin: 0 auto;
    padding-bottom: 20px;
    padding-left: 20px;
    width: 200px;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<%
	String people_name="";
	if(request.getParameter("type")!=null){
		people_name=request.getAttribute("people_name")==null?"": (String)request.getAttribute("people_name");
	}
%>
<table align="center">
	<tr>
		<td valign="top">
		<div id="stylized" class="myform" >
			<form name="peopleForm" id="peopleForm" method="post" action="../PeopleServlet?action=AddPeopleData">			
				<h1>信徒建檔</h1>
				<p>輸入信徒個人資訊</p>
				<label>姓名 <span class="small">輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name" value="<%=people_name %>"/>
				
				<label>出生日期 <span class="small">輸入國曆年月日</span> </label> 
				<!-- 
				<input type="text" name="people_birthday" id="people_birthday" />
				-->
			<div style="float: left;width: 300px;">
					<table style="width: 300px;">
						<tr>
							<td><input type="text" style="width: 50px;" name="people_birthday_year" id="people_birthday_year" />&nbsp;年&nbsp;</td>
							<td><input type="text" style="width: 50px;" name="people_birthday_month" id="people_birthday_month" />&nbsp;月&nbsp;</td>
							<td><input type="text" style="width: 50px;" name="people_birthday_day" id="people_birthday_day" />&nbsp;日&nbsp;</td>
						</tr>
					</table>
				</div>
				
				<label>出生時辰 <span class="small">下拉選擇</span> </label> 
				<select name="people_birthdayTime" id="people_birthdayTime">
					<option value="吉" selected="selected">吉時</option>
					<option value="子">子時(23:00-01:00)</option>
					<option value="丑">丑時(01:00-03:00)</option>
					<option value="寅">寅時(03:00-05:00)</option>
					<option value="卯">卯時(05:00-07:00)</option>
					<option value="辰">辰時(07:00-09:00)</option>
					<option value="巳">巳時(09:00-11:00)</option>
					<option value="午">午時(11:00-13:00)</option>
					<option value="未">未時(13:00-15:00)</option>
					<option value="申">申時(15:00-17:00)</option>
					<option value="酉">酉時(17:00-19:00)</option>
					<option value="戍">戍時(19:00-21:00)</option>
					<option value="亥">亥時(21:00-23:00)</option>					
				</select>
				<!--
				<div id="people_lunerBirthday" name="people_lunerBirthday" class="note" align="center">系統會自行計算</div>
				-->
				<label>農曆 <span class="small">若沒輸入會自動計算</span> </label> 				
				<div style="float: left;width: 300px;">
					<table style="width: 300px;">
						<tr>
							<td><input type="text" style="width: 50px;" name="people_lunerBirthday_year" id="ppeople_lunerBirthday_year" />&nbsp;年&nbsp;</td>
							<td><input type="text" style="width: 50px;" name="people_lunerBirthday_month" id="people_lunerBirthday_month" />&nbsp;月&nbsp;</td>
							<td><input type="text" style="width: 50px;" name="people_lunerBirthday_day" id="people_lunerBirthday_day" />&nbsp;日&nbsp;</td>
						</tr>
					</table>
				</div>
				<label>地址 <span class="small">輸入地址</span> </label> 
				<input type="text" name="people_address" id="people_address" />
				
				<label>電話 <span class="small">輸入電話</span> </label> 
				<input type="text" name="people_phone" id="people_phone" />
				
				<label>行動電話 <span class="small">輸入行動電話</span> </label> 
				<input type="text" name="people_cellPhone" id="people_cellPhone" />
				
				<label>電子郵件<span class="small">輸入郵件信箱</span> </label> 
				<input type="text" name="people_email" id="people_email" />
				
				<label>性別 <span class="small">下拉選擇</span> </label> 
					<select name="people_gender" id="people_gender">
						<option value="9" selected="selected">請選擇性別</option>
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				<!-- 
				<label>稱謂 <span class="small">輸入稱謂(例如:父親)</span> </label> 
				<input type="text" name="people_salutation" id="people_salutation" />
				 -->
				<label>是否為戶主 <span class="small">請選擇</span> </label> 
					<select name="people_main" id="people_main">
						<option value="1">是</option>
						<option value="0" selected="selected">否</option>
					</select>
				<label>是否願意收到邀請函 <span class="small">請選擇</span> </label> 
					<select name="people_sendmail" id="people_sendmail">
						<option value="1">是</option>
						<option value="0" selected="selected">否</option>
					</select>
					
				<button type="submit">建檔</button>
				<div class="spacer"></div>
		</form>
		</div>
		
		</td>
		
	</tr>
</table>
		
			<script language="JavaScript" type="text/javascript">
  					var frmvalidator  = new Validator("peopleForm");
 						frmvalidator.addValidation("people_name","req","請輸入姓名");
 						//frmvalidator.addValidation("people_birthday","req","請輸入國曆出生年月日");
 						frmvalidator.addValidation("people_address","req","請輸入地址");
 						frmvalidator.addValidation("people_phone","numeric","電話請輸入數字");
 						frmvalidator.addValidation("people_cellPhone","numeric","行動電話請輸入數字");						
 						frmvalidator.addValidation("gender","dontselect=000","請選擇性別");
 						
  						//frmvalidator.addValidation("people_birthdayTime","dontselect=000","請選擇出生時辰");  
    			</script>
</body>
</html>