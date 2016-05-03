<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校教师职称申报系统</title>
<style type="text/css">
	div {
		width: 1205px;
		display: block;
		position: relative;
		background: url("<%=path %>/Page/images/adminJPG.jpg");
		background-repeat: no-repeat;
	}
	div #left {
		float: left;
		width: 200px;
		height: 800px;
		
	}
	div #midd {
		float: left;
		width: 5px;
		height: 800;
		margin: auto;
		background-color: yellow;
	}
	div #right {
		color: black;
		text-decoration: none;
		float: right;
		width: 1000px;
		height: 800px;
		
	}
	img {
		margin-top: 36px;
	}
	span {
		font-size: 14px;
		line-height: 18px;
	}
	#mc {
		text-align: right;
	}
	td {
		background-color: #EEE685;
	}
</style>
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
<script type="text/javascript" src="<%=path %>/Page/Js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/Page/Js/adminValidate.js"></script>
</head>
<body>
<div>
	<div id="left">
		<center>
			<br>
			<img alt="head" src="<%=path %>/Page/images/headphoto.jpg" width="120px" height="120px">
			<br>
			<span>管理员:${session.Admin }</span>&nbsp;<a href="Quit.action" style="font-size: 12px;">退出</a>
			<br>
		</center>
	</div>
	<div id="midd"></div>
	<div id="right">
		<br>
		<span style="text-indent: 2em; font-size: 20px; line-height: 26px; color: #6656f1; font-family: FZShuTi;">&nbsp;&nbsp;欢迎管理员${session.Admin }使用<b>高校教师职称申报系统</b>！</span>
		<br><br>
		<ul>
			<li><a href="AdminClear.action?who=<%="teacher" %>">清理服务器及项目文件中教师相关的冗余文件</a></li>
			<li><a href="AdminClear.action?who=<%="technical" %>">清理服务器及项目文件中技术人员相关的文件</a></li>
			<li><a id="add" style="color: blue; text-decoration: underline; cursor:pointer;">添加审核人员</a></li>
			<li><a id="select" style="color: blue; text-decoration: underline; cursor:pointer;">查询审核人员</a></li>
			<li><a href="adminconter.action?sel=2" id="findAll">显示所有审核人员</a>
		</ul>
		<br>
		<p id="errors" style="width: 450px; text-align: center; color: green;"></p>
		<s:actionmessage/>
		<p id="addTable" style="width: 450px;"></p>
		<br>
		<s:if test="#auditorList != null">
			<center>
			<%int num = 1; %>
				<table align="left" width="60%" cellspacing="8" class="table table-bordered table-hover definewidth m10">
				<tr>
					<th>序号</th>
					<th>身份证号</th>
					<th>姓名</th>
					<th>职务</th>
					<th>操作</th>
				</tr>	
				<s:iterator value="#auditorList" var="list">
				<tr>
					<td><%=num++ %></td>
					<td>${list.utpAuditorIdCard }</td>
					<td>${list.utpAuditorName }</td>
					<%-- <td>${list.utpAuditorRole }</td> --%>
					<s:if test="#list.utpAuditorRole == 0">
						<td>院系审核人员</td>
					</s:if>
					<s:else>
						<td>人事审核人员</td>
					</s:else>
					<td><a href="adminconter.action?sel=4&idCard=${list.utpAuditorIdCard }">删除</a></td>					
				</tr>
				</s:iterator>
				</table>
			</center>
		</s:if>
		<s:if test="#oneauditor != null">
			<center>
			<%int num = 1; %>
				<table align="left" width="60%" cellspacing="8" class="table table-bordered table-hover definewidth m10">
				<tr>
					<th>序号</th>
					<th>身份证号</th>
					<th>姓名</th>
					<th>职务</th>
					<th>操作</th>
				</tr>	
				<s:iterator value="#oneauditor" var="list">
				<tr>
					<td><%=num++ %></td>
					<td>${list.utpAuditorIdCard }</td>
					<td>${list.utpAuditorName }</td>
					<%-- <td>${list.utpAuditorRole }</td> --%>
					<s:if test="#list.utpAuditorRole == 0">
						<td>院系审核人员</td>
					</s:if>
					<s:else>
						<td>人事审核人员</td>
					</s:else>
					<td><a href="adminconter.action?sel=4&idCard=${list.utpAuditorIdCard }">删除</a></td>					
				</tr>
				</s:iterator>
				</table>
			</center>
		</s:if>
	</div>
</div>
</body>
</html> 