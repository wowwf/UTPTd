<%@page import="com.UTPTd.bean.UtpTechnical"%>
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
</head>
<body>
<br/>
<center><h3>技术人员职称审核信息表</h3></center>
<center>
<table border="1" class="table table-bordered table-hover definewidth m10">
	<tr>
		<td colspan="5" style="background-color: #CFCFCF;"><center><h4>个人基本信息</h4></center></td>
	</tr>
	<tr>
		<td rowspan="5"><img alt="" src="<%=path %>/${SelectTechnical.utpTechnicalPhotoUrl}"></td>
		<td id="mc"><span>姓名：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalName }</span></td>
		<td id="mc"><b>申报职务名称：</b></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalDeclarePost }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>出生日期：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalBirthday }</span></td>
		<td id="mc"><span>年龄：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalAge }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>性别：</span></td>
		<td id="msg"><span>${Gender }</span></td>
		<td id="mc"><span>学历：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalEducation }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>毕业时间：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalGraduateTime }</span></td>
		<td id="mc"><span>参加工作时间：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalCareerBegin }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>毕业学校：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalCollege }</span></td>
		<td id="mc"><span>所学专业：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalMajor }</span></td>
	</tr>
	<tr>
		<td id="mc"><span>外语考试情况：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalCET }</span></td>
		<td id="mc" colspan="2"><span>计算机应用能力考试情况：</span></td>
		<td id="msg" colspan="3"><span>${SelectTechnical.utpTechnicalComputer }</span></td>
	</tr>	
	<tr>
		<td id="mc"><span>近五年年度考核：</span></td>
		<td id="msg"><span>${SelectTechnical.utpTechnicalAssessment }</span></td>
		<td id="mc" colspan="2"><span>年资情况:</span></td>
		<td id="msg" colspan="3">${SelectTechnical.utpTechnicalSeniority }</td>
	</tr>
	<tr>
		<td colspan="5" height="14px" style="background-color: #CFCFCF;"></td>
	</tr>
	<tr>
		<td id="mc" colspan="2"><span>成果名称:</span></td>
		<td id="msg" colspan="3">${SelectTechnical.utpTechnicalAchievement }</td>
	</tr>
	<s:if test="#otherUrlList != null">
	<tr style="background-color: #CFCFCF;">
		<td id="mc" colspan="2">学术论文</td>
		<td id="msg" colspan="3">文件下载</td>
	</tr>
		<!-- <td id="mc" colspan="2"></td>
		<td id="msg" colspan="3">文件下载</td> -->
	<s:iterator value="otherUrlList" var="list">
		<tr>
			<td id="mc" colspan="2"><s:property value="#list.name"/></td>
			<td id="msg" colspan="3"><s:property value="#list.path"/></td>
		</tr>
	</s:iterator>
	</s:if>
	<tr>
		<td colspan="5" height="20px" style="background-color: #CFCFCF;"><center><span><b>审核情况</b></span></center></td>
	</tr>
	<tr>
		<td id="mc"><span>是否通过审核：</span></td>
		<s:if test="#SelectTechnical.utpTechnicalIsSubmit==0">
			<td id="msg"><span>未通过审核</span></td>
		</s:if>
		<s:elseif test="#SelectTechnical.utpTechnicalIsSubmit==null">
			<td id="msg"><span>未提交</span></td>
		</s:elseif>
		<s:else>
			<td id="msg"><span>通过审核</span></td>
		</s:else>
		<td id="mc"><span>第几次审核：</span></td>
		<s:if test="#SelectTechnical.utpTechnicalCountSubmit==null">
			<td id="msg" colspan="2"><span>未提交</span></td>
		</s:if>
		<s:else>
		<td id="msg"  colspan="2"><span>第${SelectTechnical.utpTechnicalCountSubmit }次审核</span></td>
		</s:else>
	</tr>
</table>
<br>
</center>
<s:if test="#SelectTechnical.utpTechnicalIsSubmit == 0">
<div align="left" style="margin-left: 20px;"><h4>审核结果:</h4></div>
<s:form action="addOpinionTechnical" method="post">
<table border="1" class="table table-bordered table-hover definewidth m10" style="width: 900px; margin-left: 20px;">
  <tr>
    <th>是否同意通过审核</th>
    <th>审核评语</th>
  </tr>
  <tr>
    <td width="200px">
    <center>
    	<input type="radio" name="opinion" value="0" checked="checked">不同意
    	<input type="radio" name="opinion" value="1">同意
    </center>
    </td>
    <td width="600px">
    	<textarea name="auditorOpinion" style="width: 500px;"></textarea>
    </td>
  </tr>
</table>
<br>
<input type="hidden" name="technicalIdCard" value="${SelectTechnical.utpTechnicalIdCard }">
<div align="center"><button type="reset">重置</button>&nbsp;&nbsp;<button type="submit">确认提交审核意见</button></div>
</s:form>
<br/><br/>
</s:if>
<s:elseif test="#SelectTechnical.utpTechnicalIsSubmit != null"> 
	<center>
		<a href="ShowOpinion.action?tid=${SelectTechnical.utpTechnicalIdCard }&tname=${SelectTechnical.utpTechnicalName }">查看审核情况</a>
	</center>
</s:elseif>
<br/><br/><br/>
</body>
</html>