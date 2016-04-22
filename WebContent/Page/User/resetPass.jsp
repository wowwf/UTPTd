<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<s:if test="#sel==1">
	<s:form action="resetPass">
		<center>
		<div>
			<span>新密码:</span>&nbsp;
			<button type="submit">修改密码</button>
		</div>				
		</center>
	</s:form>
</s:if>
<s:else>
	<s:form action="isRegiest">
		<center>
		<div>
			<span>身份证:</span>&nbsp;
			<input type="text" name="iD" value=""/>
		</div>
		<div>
			<span>姓名:</span>
			<input type="text" name="uName" value=""/>
		</div>
		<div>
			<button type="reset">重置</button>
			<button type="submit">确认</button>
		</div>
		</center>
	</s:form>
</s:else>	
</body>
</html>