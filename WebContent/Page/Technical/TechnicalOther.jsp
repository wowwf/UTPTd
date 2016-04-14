<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath(); %>
<%	String basepath = request.getScheme() + "://"
		   + request.getServerName() + ":" + request.getServerPort()
		   + path + "/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其他佐证上传</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
<script type="text/javascript" src="<%=path %>/Page/Js/jquery.js"></script>
<script type="text/javascript">
	var teacher = "${session.Technical}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
</script>
<script type="text/javascript">
var count = 1;
var arr = new Array();
function add() {
	var tbl = $("#zuozheng");
	var firstTr = tbl.find("tbody>tr:first");
	var row = $("<tr id='" + count +"'></tr>");
	var td = $("<td><input type='text' id='zuozheng" + count + "' style='width:160px;'/></td>" + "<td><input type='file' name='myFile'/></td>" + "<td><button class='btn btn-primary' onclick='del(" + count + ")'>删除</button></td>");
	arr.push("zuozheng" + count);
	row.append(td);
	tbl.append(row);
	count++;
}
function del(id) {
	var tr = document.getElementById(id);
	removeByValue("zuozheng" + id);
	tr.parentNode.removeChild(tr);
}
function removeByValue(vv) {
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == vv) {
			arr.splice(i, 1);
			break;
		}
	}
}
function setValue() {
	var array = new Array();
	for (var i = 0; i < arr.length; i++) {
		array.push(document.getElementById(arr[i]).value);
	}
	document.getElementById("showmessage").value = array.toString();
}
function Valval() {
	if (arr.length == 0) {
		alert("没有文件无法提交！");
		return false;
	} else {
		return valArr();
	}
}
function valArr() {
	var flag = true;
	for (var i = 0; i < arr.length; i++) {
		var str = document.getElementById(arr[i]).value;
		if ("" == str.replace(/\s/g, "")) {
			alert("请写上佐证名称！");
			flag = false;
		}
	}
	return flag;
}
</script>
<style type="text/css">
	button {
		margin: 2px 0px 2px 60px;
	}
	table {
		width: 480px;
	}
</style>
</head>
<body>
<button type="button" class="btn btn-success" id="addnew" style="margin: 15px 0px 5px 40px;" onclick="add()">+添加佐证</button>
<br>
<s:actionmessage/>
<s:form action="otherUpload" enctype="multipart/form-data" onsubmit="return Valval()">
<input id="showmessage" name="showmessage" type="hidden">
<table class="table table-bordered table-hover definewidth m10" id="zuozheng">
	<tr>
		<td width="130px">佐证名称</td>
		<td width="240px">佐证内容</td>
		<td width="80px">操作</td>
	</tr>
	
</table>
<div style="text-align: right; margin: 5px 120px 0px 0px;"><button type="submit" class="btn btn-success" id="submit" onclick="setValue()">提交</button></div>	
</s:form>
</body>
</html>