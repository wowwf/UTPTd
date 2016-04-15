<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="AdminClear.action?who=<%="teacher" %>">清理服务器及项目文件中教师相关的冗余文件</a>
	<s:actionmessage/>
	<a href="AdminClear.action?who=<%="technical" %>">清理服务器及项目文件中技术人员相关的文件</a>
</body>
</html>