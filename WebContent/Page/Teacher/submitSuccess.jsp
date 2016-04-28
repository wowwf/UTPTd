<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://"
   + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交成功</title>
<style type="text/css">
	div {
		width: 338px;
		height: 272px;
		background: url("<%=path %>/Page/images/successback.png");
		background-repeat: no-repeat;
	}
</style>
</head>
<body>
	<div></div>
</body>
</html>