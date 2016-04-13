<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%  String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
   <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
    <script type="text/javascript" src="<%=path %>/Page/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/common.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/regiest.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="personRegiest" onsubmit="return regiestSubmit()">
        <h2 class="form-signin-heading">用户注册</h2>
        <input type="text" id="userName" name="userName" class="input-block-level" placeholder="姓名" onblur="inpntName()">
        <input type="text" id="idCard" name="idCard" class="input-block-level" placeholder="身份证号码" onblur="inputIdcard()">
        <table>
			<tr><td><s:select id="Post" list="#{'2':'--请选择--','0':'高校教师','1':'技术人员'}" name="Post" value="2" style="margin-top:-8px; height:30px;" onblur="checkPost()"></s:select></td></tr>
		</table>
       		<s:submit class="btn btn-large btn-primary" value="注册" align="left"></s:submit>
    </form>
</div>
</body>
</html>