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
        	color: black;
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
		table {
			color: black;
		}
    </style>
<script type="text/javascript">
	var teacher = "${session.Auditor}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
	function changNum() {
		var selectVal = $("#everyNum").find("option:selected").val();
		window.location.href = "QueryTeacher.action?currentPage=1&everyPage=" + selectVal;
	}
</script>
</head>
<body>
<% int number = 1; %>
<table width="95%" cellspacing="10">
				  <tr align="center">
				  	<td>序号</td>
					<td>姓名</td>
					<td>身份证号码</td>
					<td>年龄</td>
					<td>目前所任职务</td>
					<td>审核评教的职称</td>
					<td>查看个人详细信息</td>
				  </tr>
				  <s:iterator value="#highTeacherInfo" var="teacher">
				  	 <tr align="center">
				  	 		<td><%=number++ %></td>
							<td>${teacher.utpHighTeacherName}</td>
							<td>${teacher.utpHighTeacherIdCard}</td>
							<td>${teacher.utpHighTeacherAge}</td>
							<td>${teacher.utpHighTeacherPostNow}</td>
							<td>${teacher.utpHighTeacherDeclarePost}</td>
							<td><a href="QuerySelectTeacher.action?IdCard=${teacher.utpHighTeacherIdCard}">查看</a></td>
							<td></td>
					  </tr>
				  </s:iterator>	
				  <tr>
				  	<td colspan="6" align="center">
				  		共${page.totalCount}条纪录，当前第${page.currentPage}/${page.totalPage}页，每页${page.everyPage}条纪录
				  	<s:if test="#request.page.hasPrePage">
                		<a href="QueryTeacher.action?currentPage=1">首页</a> | 
                		<a href="QueryTeacher.action?currentPage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="QueryTeacher.action?currentPage=${page.currentPage + 1}">下一页</a> | 
                		<a href="QueryTeacher.action?currentPage=${page.totalPage}">尾页</a>
               		</s:if>
               		<s:else>
               		下一页 | 尾页
               		</s:else>
               		&nbsp;
               		<select id="everyNum" name="everyNum" style="width:80px; height: 20px; font-size: 12px;" onchange="changNum()">
               			<option selected="selected">--页条数--</option>
               			<option value="0">1</option>
               			<option value="1">10</option>
               			<option value="2">20</option>
               			<option value="3">50</option>
               			<option value="4">100</option>
               		</select>
				  	</td>
				  </tr>	  
			</table>	
</body>
</html>