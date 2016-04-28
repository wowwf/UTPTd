<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath(); %>
<%	String basepath = request.getScheme() + "://"
		   + request.getServerName() + ":" + request.getServerPort()
		   + path + "/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
<script type="text/javascript" src="<%=path %>/Page/Js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/Page/Js/imgValidate.js"></script>
<style type="text/css">
	table {
		text-align: center;
	}
</style>
<script type="text/javascript">
	var teacher = "${session.HighTeacher}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
</script>
</head>
<body>
<br><br>
<s:actionmessage/>
<center>
<span id="imgError"></span>
<s:form action="UpFileLoad" enctype="multipart/form-data" theme="simple">
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
		<td><span>上传一寸照片</span></td><%-- <s:file id="upFile" name="upFile"></s:file><s:submit id="btnUpload" value="上传文件"></s:submit> --%>
		<td><input type="file" id="upFile" name="upFile"></td>
		<td id="fileType" style="display: none;"></td>
		<td id="fileSize" style="display: none;"></td>
		<td><input type="submit" value="上传文件"></td>
		</tr>
	</table>
</s:form>
<div></div>
</center>
</body>
</html>