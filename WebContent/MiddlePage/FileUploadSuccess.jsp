<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path %>/Page/Js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#showTo").click(function() {
		$("#personImg").attr("src", function() {
			return this.src + "${ImgUrl}";
		});
		alert("ok");
	});
});
</script>
<style type="text/css">
	img {
		width: 120xp;
		height: 200px;
	}
</style>
</head>
<body>
	<span>图片上传成功！</span>
	<p><img alt="" src="<%=path %>/<s:property value="Imgpath"/>"></p>
</body>
</html>