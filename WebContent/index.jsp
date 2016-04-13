<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path %>/Page/JS/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("p").click(function(){
		$(this).hide();
	});
});
</script>
<title>测试。。。</title>
</head>
<body>
	<p>实现隐藏！</p>
	<p><s:text name="AdminUname"></s:text></p>
	<a href="<%=path %>/Page/AALogin.jsp">哪里的乱码</a>
</body>
</html>