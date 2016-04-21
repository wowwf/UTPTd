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
<center>
<br>
<s:if test="#session.Auditor.utpAuditorRole == 1 && #sel == 1">
<table width="95%" cellspacing="10" class="table table-bordered table-hover definewidth m10">
				  <tr align="center">
				  	<th>序号</th>
					<th>姓名</th>
					<th>身份证号码</th>
					<th>年龄</th>
					<th>目前所任职务</th>
					<th>审核评教的职称</th>
					<th>查看个人详细信息</th>
				  </tr>
				  <s:iterator value="#TechnicalInfo" var="technical">
				  	 <tr align="center">
				  	 		<td><%=number++ %></td>
							<td>${technical.utpTechnicalName}</td>
							<td>${technical.utpTechnicalIdCard}</td>
							<td>${technical.utpTechnicalAge}</td>
							<td>${technical.utpTechnicalPostNow}</td>
							<td>${technical.utpTechnicalDeclarePost}</td>
							<td><a href="QuerySelectTechnical.action?IdCard=${technical.utpTechnicalIdCard}">查看</a></td>
					  </tr>
				  </s:iterator>	
				  <tr align="right">
				  	<td colspan="7" align="right" style="text-align: right;">
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
</s:if>
<s:else>
	<s:if test="#session.Auditor.utpAuditorRole == 0">
		<h4>检索所有初次提交未经过审核的教师的信息</h4>
	</s:if>
	<s:else>
		<h4>检索所有通过学院审核的教师的信息</h4>
	</s:else>
	<table width="95%" cellspacing="10" class="table table-bordered table-hover definewidth m10">
				  <tr align="center">
				  	<th>序号</th>
					<th>姓名</th>
					<th>身份证号码</th>
					<th>年龄</th>
					<th>目前所任职务</th>
					<th>审核评教的职称</th>
					<th>查看个人详细信息</th>
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
					  </tr>
				  </s:iterator>	
				  <tr align="right">
				  	<td colspan="7" align="right" style="text-align: right;">
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
</s:else>	
</center>
</body>
</html>