<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
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
	a {
		text-align: right;
		margin-right: 10px;
	}
</style>
<script type="text/javascript" src="<%=path %>/Page/JS/jquery-1.10.2.min.js"></script>
<title>高校职工职称申报系统</title>
</head>
<body>
	<a href="<%=path %>/Page/AALogin.jsp">点我点我，去登陆--></a>
</body>
</html>