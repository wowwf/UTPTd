<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
<button onclick="goBack()">返回</button>
<%int number = 1; %>
<table border="1" class="table table-bordered table-hover definewidth m10">
	<tr>
		<th>序号</th>
		<th>参审人姓名</th>
		<th>审核人姓名</th>
		<th>审核人评语</th>
		<th>审核时间</th>
	</tr>
	<s:iterator value="#OpinionInfo" var="opinion">
		<tr>
			<td><%=number++ %></td>
			<td>${opinion.tName }</td>
			<td>${opinion.aName }</td>
			<td>${opinion.aOpinion }</td>
			<td>${opinion.aTime }</td>
		</tr>
	</s:iterator>
</table>
</body>
</html>