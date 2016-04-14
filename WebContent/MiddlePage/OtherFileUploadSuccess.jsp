<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<%String basePath = request.getScheme() + "://"
		   + request.getServerName() + ":" + request.getServerPort()
		   + path + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var postlog = "${session.HighTeacher}";
var postlog1 = "${session.Technical}";
if (!postlog.length == 0) {
	alert("其他佐证上传成功！");
	window.top.location.href = "<%=basePath%>Page/index.jsp";
}
if (!postlog1.length == 0) {
	alert("论文著作上传成功！");
	window.top.location.href = "<%=basePath%>Page/index.jsp";
}
if (postlog == 0 && postlog1 ==0) {
	alert("请先登录！");
	window.top.location.href = "<%=basePath%>Page/AALogin.jsp";
}

</script>
</html>