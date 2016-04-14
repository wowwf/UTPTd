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
<title>申请表预览</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
<style type="text/css">
	body {
		background: url("../images/teacherBackground.jpg");
	}
	td {
		width: 120px;
		line-height: 30px;
		text-align: right;
	}
	#mc {
		text-align: right;
	}
	#msg {
		width: 180px;
		text-align: center;
	}
	img {
		width: 160px;
		height: 200px;
	}
	input {
		width: 160px;
	}
</style>
<script type="text/javascript">
	var teacher = "${session.Technical}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
</script>
</head>
<body>
<br/>
<center><h3>高校教师职称审核信息表</h3></center>
<center>
<table border="1" class="table table-bordered table-hover definewidth m10">
	<tr>
		<td colspan="5" style="background-color: #CFCFCF;"><center><h4>个人基本信息</h4></center></td>
	</tr>
	<tr>
		<td rowspan="5"><img alt="" src="<%=path %>/${TechnicalInfo.utpTechnicalPhotoUrl}"></td>
		<td id="mc"><span>姓名：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalName }</span></td>
		<td id="mc"><b>申报职务名称：</b></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalDeclarePost }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>出生日期：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalBirthday }</span></td>
		<td id="mc"><span>年龄：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalAge }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>性别：</span></td>
		<td id="msg"><span>${Gender }</span></td>
		<td id="mc"><span>学历：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalEducation }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>毕业时间：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalGraduateTime }</span></td>
		<td id="mc"><span>参加工作时间：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalCareerBegin }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>毕业学校：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalCollege }</span></td>
		<td id="mc"><span>所学专业：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalMajor }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>外语考试情况：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalCET }</span></td>
		<td id="mc" colspan="2"><span>计算机应用能力考试情况：</span></td>
		<td id="msg" colspan="3"><span>${TechnicalInfo.utpTechnicalComputer }</span></td>
	</tr>	
	<tr>
		<td id="mc"><span>近五年年度考核：</span></td>
		<td id="msg"><span>${TechnicalInfo.utpTechnicalAssessment }</span></td>
		<td id="mc" colspan="2"><span>年资情况:</span></td>
		<td id="msg" colspan="3">${TechnicalInfo.utpTechnicalSeniority }</td>
	</tr>
	<tr>
		<td colspan="5" height="14px" style="background-color: #CFCFCF;"></td>
	</tr>
	<tr>
		<td id="mc" colspan="2"><span>成果名称:</span></td>
		<td id="msg" colspan="3">${TechnicalInfo.utpTechnicalAchievement }</td>
	</tr>
	<tr>
		<td colspan="5" height="20px" style="background-color: #CFCFCF;"><center><span><b>学术论文</b></span></center></td>
	</tr>
		<!-- <td id="mc" colspan="2"></td>
		<td id="msg" colspan="3">文件下载</td> -->
		<s:iterator value="otherUrlList" var="list">
		<tr>
			<td id="mc" colspan="2"><s:property value="#list.name"/></td>
			<td id="msg" colspan="3"><s:property value="#list.path"/></td>
		</tr>
		</s:iterator>
	<tr>
		<td colspan="5" height="20px" style="background-color: #CFCFCF;"><center><span><b>审核情况</b></span></center></td>
	</tr>
	<tr>
		<td id="mc"><span>是否通过审核：</span></td>
		<s:if test="#TechnicalInfo.utpTechnicalIsSubmit==0">
			<td id="msg"><span>未通过审核</span></td>
		</s:if>
		<s:else>
			<td id='msg'><span>通过审核</span></td>
		</s:else>
		<td id="mc"><span>第几次审核：</span></td>
		<td id="msg"  colspan="2"><span>第${TechnicalInfo.utpTechnicalCountSubmit }次审核</span></td>
	</tr>
</table>
<br/><br/><br/><br/><br/>
</center>
</body>
</html>