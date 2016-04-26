<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body {
		background: url("<%=path %>/Page/images/bgimg.png");
		background-repeat: no-repeat;
	}
</style>
<title></title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
</head>
<body>
<s:actionmessage/>
<s:if test="#session.Auditor.utpAuditorRole == 0">
	<s:if test="#sel == 0">
	<center>
	<br><br>
	<s:form action="QueryLikeTeacher?everyPage=2">
	<table class="table table-bordered table-hover definewidth m10" style="width: 620px;">
		<tr>
			<td colspan="2" align="center">根据身份证查询</td>
		</tr>
		<tr>
			<td align="right"><span>身份证号码:</span></td>
			<td><input type="text" name="findIdCard" style="width: 320px;"></td>
		</tr>
			<s:submit label="开始查询" value="开始查询"></s:submit>
	</table>
	</s:form>
	</center>
	</s:if>
	<s:else>
	<center>
	<br><br>
	<s:form action="QueryLikeTeacher?everyPage=2">
	<table class="table table-bordered table-hover definewidth m10" style="width: 620px;">
		<tr>
			<td colspan="2" align="center">根据姓名查询</td>
		</tr>
		<tr>
			<td align="right"><span>姓名:</span></td>
			<td><input type="text" name="findName" style="width: 320px;"></td>
		</tr>
			<s:submit label="开始查询" value="开始查询"></s:submit>
	</table>
	</s:form>
	</center>
	</s:else>
</s:if>
<s:else>
		<s:if test="#sel == 0">
	<center>
	<br><br>
	<s:form action="ChooseQuery?everyPage=2">
	<table class="table table-bordered table-hover definewidth m10" style="width: 720px;">
		<tr>
			<td colspan="2" align="center">根据身份证查询</td>
		</tr>
		<tr>
			<td align="right"><span>身份证号码:</span></td>
			<td><input type="text" name="findIdCard" style="width: 320px;">
			<select name="Post" style="width :120px;">
				<option value="0" selected="selected">教师</option>
				<option value="1">技术人员</option>
			</select>
			</td>
		</tr>
			<s:submit label="开始查询" value="开始查询"></s:submit>
	</table>
	</s:form>
	</center>
	</s:if>
	<s:else>
	<center>
	<br><br>
	<s:form action="ChooseQuery?everyPage=2">
	<table class="table table-bordered table-hover definewidth m10" style="width: 620px;">
		<tr>
			<td colspan="2" align="center">根据姓名查询</td>
		</tr>
		<tr>
			<td align="right"><span>姓名:</span></td>
			<td><input type="text" name="findName" style="width: 320px;">
			<select name="post" style="width :120px;">
				<option value="0" selected="selected">教师</option>
				<option value="1">技术人员</option>
			</select>
			</td>
		</tr>
			<s:submit label="开始查询" value="开始查询"></s:submit>
	</table>
	</s:form>
	</center>
	</s:else>
</s:else>
</body>
</html>