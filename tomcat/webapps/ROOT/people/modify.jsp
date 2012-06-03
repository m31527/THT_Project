<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.tht.person.People"%>
<%@page import="com.util.MyUtil"%>

<%@page import="com.tht.person.Relation"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tht.action.ActiveKind"%>
<%@page import="com.tht.action.Active"%>
<%@page import="com.tht.action.BidoKind"%><html>
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
<script type="text/javascript">
function DeleteActive(active_id,people_id){
	var answer = confirm("確定刪除嗎?")
	if (answer){
		document.active_modify_form.active_id.value=active_id;
		document.active_modify_form.people_id.value=people_id;
		document.active_modify_form.submit();
	}
	
}

function selectActive(){
	var active_kind_id=document.active_add_form.active_kind_id.value;
	if(active_kind_id=="14" || active_kind_id=="13"){
		document.getElementById('bido_div').style.display="";
	}		
}
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<%
	People bean=request.getAttribute("bean")==null?new People():(People)request.getAttribute("bean");
%>
<table align="center">
	<tr>
		<td colspan="2">
			<form id="seachform" name="seachform" method="post" action="PeopleServlet?action=QueryByName">
			<div id="stylized" class="myform" style="width: 100%;height: 50px;">
			<label>搜尋 <span class="small">輸入姓名</span> </label><input type="text" name="people_name" id="people_name">
			<button type="submit">搜尋</button>
			</div>
			</form>
		</td>
	</tr>
	<tr>
		<!-- 個人基本資料 -->
		<td valign="top">
		<div id="stylized" class="myform" >
			<form name="peopleModifyForm" id="peopleModifyForm" method="post" action="../PeopleServlet?action=ModifyPeople">			
				<h1>信徒建檔</h1>
				<p>輸入信徒個人資訊</p>
				<label>姓名 <span class="small">輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name" value="<%=MyUtil.replaceNullForString(bean.getPeople_name())%>"/>
				
				<label>出生日期 <span class="small">輸入國曆年月日</span> </label> 
				<input type="text" name="people_birthday" id="people_birthday" value="<%=MyUtil.replaceNullForString(bean.getPeople_birthday())%>"/>
				
				<label>出生時辰 <span class="small">下拉選擇</span> </label> 
				<select name="people_birthdayTime" id="people_birthdayTime">
					<%
					String b_time=MyUtil.replaceNullForString(bean.getPeople_birthdayTime());
					%>
					<option value="吉" <%if(b_time.equals("")){%>selected="selected"<%}%>>吉時</option>
					<option value="子" <%if(b_time.equals("子")){%>selected="selected"<%}%>>子時(23:00-01:00)</option>
					<option value="丑" <%if(b_time.equals("丑")){%>selected="selected"<%}%>>丑時(01:00-03:00)</option>
					<option value="寅" <%if(b_time.equals("寅")){%>selected="selected"<%}%>>寅時(03:00-05:00)</option>
					<option value="卯" <%if(b_time.equals("卯")){%>selected="selected"<%}%>>卯時(05:00-07:00)</option>
					<option value="辰" <%if(b_time.equals("辰")){%>selected="selected"<%}%>>辰時(07:00-09:00)</option>
					<option value="巳" <%if(b_time.equals("巳")){%>selected="selected"<%}%>>巳時(09:00-11:00)</option>
					<option value="午" <%if(b_time.equals("午")){%>selected="selected"<%}%>>午時(11:00-13:00)</option>
					<option value="未" <%if(b_time.equals("未")){%>selected="selected"<%}%>>未時(13:00-15:00)</option>
					<option value="申" <%if(b_time.equals("申")){%>selected="selected"<%}%>>申時(15:00-17:00)</option>
					<option value="酉" <%if(b_time.equals("酉")){%>selected="selected"<%}%>>酉時(17:00-19:00)</option>
					<option value="戍" <%if(b_time.equals("戍")){%>selected="selected"<%}%>>戍時(19:00-21:00)</option>
					<option value="亥" <%if(b_time.equals("亥")){%>selected="selected"<%}%>>亥時(21:00-23:00)</option>	
								
				</select>
				<label>農曆<span class="small">輸入農曆生日</span> </label> 
				<input type="text" name="people_lunerBirthday" id="people_lunerBirthday" value="<%=MyUtil.replaceNullForString(bean.getPeople_lunerBirthday()) %>"/>
				
				<label>地址 <span class="small">輸入地址</span> </label> 
				<input type="text" name="people_address" id="people_address" value="<%=MyUtil.replaceNullForString(bean.getPeople_address()) %>"/>
				
				<label>電話 <span class="small">輸入電話</span> </label> 
				<input type="text" name="people_phone" id="people_phone" value="<%=MyUtil.replaceNullForString(bean.getPeople_phone()) %>"/>
				
				<label>行動電話 <span class="small">輸入行動電話</span> </label> 
				<input type="text" name="people_cellPhone" id="people_cellPhone" value="<%=MyUtil.replaceNullForString(bean.getPeople_cellPhone()) %>"/>
				
				<label>電子郵件<span class="small">輸入郵件信箱</span> </label> 
				<input type="text" name="people_email" id="people_email" value="<%=MyUtil.replaceNullForString(bean.getPeople_email()) %>"/>
				
				<label>性別 <span class="small">下拉選擇</span> </label> 
					<select name="people_gender" id="people_gender">
						<option value="9" <%if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==9){%> selected="selected"<%} %>>請選擇性別</option>
						<option value="1" <%if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==1){%> selected="selected"<%} %>>男</option>
						<option value="0" <%if(MyUtil.replaceNullForInteger(bean.getPeople_gender())==0){%> selected="selected"<%} %>>女</option>
					</select>
				<!-- 
				<label>稱謂 <span class="small">輸入稱謂(例如:父親)</span> </label> 
				<input type="text" name="people_salutation" id="people_salutation" value="兒子"/>
				 -->
				<label>是否為戶主 <span class="small">請選擇</span> </label> 
					<select name="people_main" id="people_main">
						<option value="1" <%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){%> selected="selected"<%} %>>是</option>
						<option value="0" <%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==0){%> selected="selected"<%} %>>否</option>
					</select>
				<label>是否願意收到邀請函 <span class="small">請選擇</span> </label> 
					<select name="people_sendmail" id="people_sendmail">
						<option value="1" <%if(MyUtil.replaceNullForInteger(bean.getPeople_sendmail())==1){%> selected="selected"<%} %>>是</option>
						<option value="0" <%if(MyUtil.replaceNullForInteger(bean.getPeople_sendmail())==0){%> selected="selected"<%} %>>否</option>
					</select>	
				<button type="submit">更新</button>
				<div class="spacer"></div>
				<input type="hidden" name="people_id" value="<%=bean.getPeople_id()%>">
		</form>
		</div>
		<!-- 其他家人 -->
		<div id="styliz_searchrs" class="searchform" style="margin: 20px auto 0;width: 500px;">
				<form id="login_form" name="form" method="post" action="index.jsp">
				<h1>同地址家人</h1>
					<p>目前其他同地址家人清單</p>
					<table class="search_table" align="center">
						<tr style="font-size: 17px;">
							<td>稱呼</td>
							<td>姓名</td>
							<td>出生</td>
							<td></td>
						</tr>
						<%
						int people_s=0;
						for(Relation rel_bean: bean.getRelation_list()){
						
								if(rel_bean.getSame_address()==0){
									if(bean.getPeople_id()!=rel_bean.getPeople_id()){
									%>
									<tr>
										<td><%if(rel_bean.getPeople_id()==rel_bean.getMain_people_id()){%><img src="images/king.png"><%}%><%=rel_bean.getRelation_name() %></td>
										<td><a href="PeopleServlet?action=DetailPeople&people_id=<%=rel_bean.getPeople_id()%>"><%=rel_bean.getPeople_name() %></a></td>
										<td><%=rel_bean.getPeople_birthday() %></td>
										<td><%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){%><button type="button" onclick="location.href='PeopleServlet?action=notJoinPeople&relation_id=<%=rel_bean.getRelation_id()%>&people_id=<%=bean.getPeople_id()%>'">解除</button><%} %></td>
									</tr>
									<%
										}
									}		
						}
						%>
					</table>
				</form>
			</div>
			<%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){%>
			<!-- 新增其他家人 -->
			<div id="stylized" class="myform"  style="margin: 20px auto 0;width: 500px;">
				<form id="insert_search_form" name="insert_search_form" method="post" action="../PeopleServlet?action=QueryByNameForRelation">
				<h1>新增其他家人</h1>
					<p>請用搜尋來尋找其他家人</p>
					
				<label>姓名<span class="small">請輸入姓名</span> </label> 
				<input type="text" name="people_name" id="people_name"/>
				<input type="hidden" name="main_people_id" value="<%=bean.getPeople_id()%>">
				<button type="submit">搜尋</button>
				<div class="spacer"></div>
				</form>
			</div>
			<%} %>
			 
			<!-- 不同地址 -->
		<div id="styliz_searchrs" class="searchform" style="margin: 20px auto 0;width: 500px;">
				<form id="loginother_form" name="loginother_form" method="post" action="index.jsp">
				<h1>不同地址家人</h1>
					<p>目前不同地址家人清單</p>
					<table class="search_table" align="center">
						<tr style="font-size: 17px;">
							<td>稱呼</td>
							<td>姓名</td>
							<td>出生</td>
							<td></td>
						</tr>
						<%
						int people_v=0;
						for(Relation rel_bean: bean.getRelation_list()){
								//不同地址家人=1
								if(rel_bean.getSame_address()==1){
									//if(bean.getPeople_id()!=rel_bean.getPeople_id()){
									%>
									<tr>
										<td><%if(rel_bean.getPeople_id()==rel_bean.getMain_people_id()){%><img src="images/king.png"><%}%><%=rel_bean.getRelation_name() %></td>
										<td><a href="PeopleServlet?action=DetailPeople&people_id=<%=rel_bean.getPeople_id()%>"><%=rel_bean.getPeople_name() %></a></td>
										<td><%=rel_bean.getPeople_birthday() %></td>
										<td><%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){%><button type="button" onclick="location.href='PeopleServlet?action=notJoinPeople&relation_id=<%=rel_bean.getRelation_id()%>&people_id=<%=bean.getPeople_id()%>'">解除</button><%} %></td>
									</tr>
									<%
										}
									//}		
						}
						%>
					</table>
				</form>
			</div>
			<%if(MyUtil.replaceNullForInteger(bean.getPeople_main())==1){%>
			<!-- 新增其他不同地址家人 -->
			<div id="stylized" class="myform"  style="margin: 20px auto 0;width: 500px;">
				<form id="insert_search_other_form" name="insert_search_other_form" method="post" action="../PeopleServlet?action=QueryByNameForOtherRelation">
				<h1>新增不同地址家人</h1>
					<p>請用搜尋來尋找不同地址家人</p>
					
				<label>姓名<span class="small">請輸入姓名</span> </label> 
				<input type="text" name="o_people_name" id="o_people_name"/>
				<input type="hidden" name="main_people_id" value="<%=bean.getPeople_id()%>">
				<input type="hidden" name="o_main_people_id" value="<%=bean.getPeople_id()%>">
				<input type="hidden" name="search_state" value="other">
				<button type="submit">搜尋</button>
				<div class="spacer"></div>
				</form>
			</div>
			<%} %>
			
		</td>
		<!-- 用的服務 -->
		<td valign="top">
			<div id="styliz_searchrs" class="searchform" style="margin: 50px auto 0;width: 500px;">
				<form id="active_modify_form" name="active_modify_form" method="post" action="../PeopleServlet?action=DeleteActive">
				<h1>現有委託儀式</h1>
					<p>目前該信徒委託儀式清單如下</p>
					<table class="search_table" align="center">
						<tr style="font-size: 17px;">
							<td>儀式</td>
							<td>委託日期</td>
							<td>備註</td>
							<td></td>
						</tr>
						<%for(Active a_bean: bean.getActive_list()){ %>
						<tr>
							<td>
								<%=ActiveKind.list.get(a_bean.getActive_kind_id())%>
								<br>
								<%if(a_bean.getActive_bido_id()!=0){%>
								(<%=BidoKind.list.get(a_bean.getActive_bido_id()) %>)
								<%}%>
							</td>
							<td><%=a_bean.getActive_create_date() %></td>
							<td><%=a_bean.getActive_note()==null?"無":a_bean.getActive_note()%></td>
							<td><button type="button" onclick="DeleteActive(<%=a_bean.getActive_id()%>,<%=a_bean.getPeople_id() %>)">刪除</button></td>
						</tr>
						<%} %>
					</table>
					<input type="hidden" name="active_id">
					<input type="hidden" name="people_id">
				</form>
			</div>
			<!-- 新增委託儀式 -->
			<div id="stylized" class="myform"  style="margin: 20px auto 0;width: 500px;">
				<form id="active_add_form" name="active_add_form" method="post" action="../PeopleServlet?action=AddActive">
				<h1>新增委託儀式</h1>
					<p>請指定委託儀式</p>
					<label>選擇儀式 <span class="small">下拉選擇</span> </label> 
					<select name="active_kind_id" id="active_kind_id" onchange="selectActive();">
					<option value="000" selected="selected">請選擇儀式</option>
					
						<%
						Iterator<Integer> it = ActiveKind.list.keySet().iterator();
						while (it.hasNext()) {
							int num=it.next();

						%>
						<option value="<%=num%>"><%=ActiveKind.list.get(num)%></option>
						<%} %>
					</select>
				<div id="bido_div" style="display: none;">
				<label>禮斗名<span class="small">請選擇</span> </label>
					<select name="active_bido_id" id="active_bido_id">
						<option value="0" selected="selected">請選擇儀式</option>
					<%
						Iterator<Integer> it2 = BidoKind.list.keySet().iterator();
						while (it2.hasNext()) {
							int num=it2.next();

						%>
						<option value="<%=num %>"><%=BidoKind.list.get(num)%></option>
						<%} %>
					</select>
				</div>		
				<label>委託日期 <span class="small">請選擇日期</span> </label> 
				<input type="text" name="active_create_date" id="active_create_date" value="<%=MyUtil.getToday("yyyy-MM-dd")%>"/>
					
				<label>備註 <span class="small">可註明備註事項</span> </label> 
				<input type="text" name="active_note" id="active_note"/>
				
				<button type="submit">新增</button>
				<div class="spacer"></div>
				<input type="hidden" name="people_id" value="<%=bean.getPeople_id()%>">
				</form>
			</div>
		</td>
	</tr>
</table>		
			<script language="JavaScript" type="text/javascript">
  					var frmvalidator  = new Validator("peopleModifyForm");
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