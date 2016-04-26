<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%  String path = request.getContextPath(); %>
<%	String basepath = request.getScheme() + "://"
		   + request.getServerName() + ":" + request.getServerPort()
		   + path + "/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
    <script type="text/javascript" src="<%=path %>/Page/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
		span {
			color: red;
			font-size: 20px;
			line-height: 20px;
		}
		input {
			margin: 0px 10px 5px 5px;
		}
		#beizhu {
			width: 300px;
		}
		#mingcheng{
			width: 300px;
			text-align: right;
		}
		a {
			text-decoration: none;
		}
		textarea {
			width: 380px;
		}
		span {
			color: black;
			font-size: 16px;
			text-align: left;
			line-height: 32px;
		}
		div {
			width: 1000px;
			height: 600px;
			background: url("<%=path%>/Page/images/back.jpg");
			background-repeat: no-repeat;
		}
    </style>
<script type="text/javascript">
	var teacher = "${session.Auditor}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
</script>
</head>
<body>
<s:if test="#session.Auditor.utpAuditorRole==0">
<br>
<center>
	<div style="width: 1000px; text-align: left;">
		<span>教师您好！</span><br><br>
		<p style="text-indent: 2em; font-size: 15px;">您现在使用的是王伟峰设计开发的高校教师在线职称评教系统！<br>您可以使用该系统实现所有教师审核表的检索，并对为通过审核的人员进行审核并发表评论。</p>
		<br>
		<a href="QueryTeacher.action?currentPage=1&everyPage=2">检索所有未通过院系审核的教师信息</a>
	</div>
</center>
</s:if>
<s:elseif test="#session.Auditor.utpAuditorRole==1 && #sel==0">
<center>
	<div style="width: 1000px; text-align: left;">
		<span>教师您好！</span><br><br>
		<p style="text-indent: 2em; font-size: 15px;">您现在使用的是王伟峰设计开发的高校教师在线职称评教系统！<br>您可以使用该系统实现所有教师审核表的检索，并对为通过审核的人员进行审核并发表评论。</p>
		<br>
		<a href="QueryTeacher.action?currentPage=1&everyPage=2">检索所有已通过院系审核的教师信息</a>
	</div>
</center>
</s:elseif>
<s:elseif test="#session.Auditor.utpAuditorRole==1 && #sel==1">
<center>
	<div style="width: 1000px; text-align: left;">
		<span>教师您好！</span><br><br>
		<p style="text-indent: 2em; font-size: 15px;">您现在使用的是王伟峰设计开发的高校教师在线职称评教系统！<br>您可以使用该系统实现所有教师审核表的检索，并对为通过审核的人员进行审核并发表评论。</p>
		<br>
		<a href="QueryTechnical.action?currentPage=1&everyPage=2">检索所有未通过人事审核的技术人员信息</a>
	</div>
</center>
</s:elseif>
<s:actionmessage/>
</body>
</html>