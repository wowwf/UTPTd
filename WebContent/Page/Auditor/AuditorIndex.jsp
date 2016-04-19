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
<table>
	<tr><td><a href="<%=path %>/Page/Auditor/ShowAll.jsp">检索所有数据</a></td></tr>
</table>
</s:if>
<s:elseif test="#session.Auditor.utpAuditorRole==1">
	<a>人事审核人员</a>
</s:elseif>
<s:else>
	<a>怎么可能</a>
</s:else>
</body>
</html>