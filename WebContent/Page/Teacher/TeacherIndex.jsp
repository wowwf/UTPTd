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
	<script type="text/javascript" src="<%=path %>/Page/Js/validate.js"></script>
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
			font-size: 12px;
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
	var teacher = "${session.HighTeacher}";
	if (teacher.length == 0) {
		window.top.location.href = "<%=basepath %>Page/AALogin.jsp";
	}
</script>
</head>
<body>
<p style="color: red; text-align: right; margin-right: 20px;">*为必填</p>
<s:form action="teacherSubmit" theme="simple">
	<table class="table table-bordered table-hover definewidth m10" >
    	<thead>
    		<tr>
    			<th colspan="3" style="text-align: center;">帐号信息(请妥善保护好你的登陆信息)</th>
    		</tr>
    	</thead>
	     <tr>
            <td id="mingcheng">身份证号码:<span>*</span></td>
            <td><s:property value="#session.HighTeacher.utpHighTeacherIdCard"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">姓名:<span>*</span></td>
            <td><s:property value="#session.HighTeacher.utpHighTeacherName"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">个人基本信息</th>
        </tr>
        <tr>
            <td id="mingcheng">姓名:<span>*</span></td>
            <td><s:property value="#session.HighTeacher.utpHighTeacherName"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">性别:<span>*</span></td>
            <td>
            	<input type="radio" name="utpHighTeacher.utpHighTeacherGender" value="1" checked="checked">男
            	<input type="radio" name="utpHighTeacher.utpHighTeacherGender" value="0">女
            </td>
            <td id="beizhu">
            	<span id="sexError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">年龄:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherAge" value="${readTeacher.utpHighTeacherAge }" maxlength="3" onkeyup="this.value=this.value.replace(/[^\d]/g, '')"></td>
            <td id="beizhu">
            	<span id="ageError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">出生日期:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherBirthday" value="${readTeacher.utpHighTeacherBirthday }" maxlength="10"></td>
            <td id="beizhu">
            	<span id="birthError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">参加工作时间:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherCareerBegin" value="${readTeacher.utpHighTeacherCareerBegin }" maxlength="10"></td>
            <td id="beizhu">
            	<span id="workError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">毕业时间:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherGraduateTime" value="${readTeacher.utpHighTeacherGraduateTime }"></td>
            <td id="beizhu">
            	<span id="graduError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">学历:<span>*</span></td>
            <td>
            	<%-- <input type="text" name="utpHighTeacher.utpHighTeacherEducation" value="${readTeacher.utpHighTeacherEducation }"> --%>
            	<s:if test="#readTeacher.utpHighTeacherEducation!=null">
            		<p><s:select list="#{'无':'--请选择--','本科':'本科','专科':'专科','高中':'高中' }" name="utpHighTeacher.utpHighTeacherEducation" value="#readTeacher.utpHighTeacherEducation"></s:select></p>
            	</s:if>
            	<s:else>
            		<p><s:select list="#{'无':'--请选择--','本科':'本科','专科':'专科','高中':'高中' }" name="utpHighTeacher.utpHighTeacherEducation" value="无"></s:select></p>
            	</s:else>
            </td>
            <td id="beizhu">
            	<span id="eduError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">毕业学校:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherCollege" value="${readTeacher.utpHighTeacherCollege }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">所学专业:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherMajor" value="${readTeacher.utpHighTeacherMajor }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">目前所任职务:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherPostNow" value="${readTeacher.utpHighTeacherPostNow }"></td>
            <td id="beizhu">
            	<span id="postError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">申报专业技术职务任职资格:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherDeclarePost" value="${readTeacher.utpHighTeacherDeclarePost }"></td>
            <td id="beizhu">
            	<span id="decPostError"></span>
            </td>
        </tr>
        <tr>
            <td id="mingcheng">外语考试情况:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherCET" value="${readTeacher.utpHighTeacherCET }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">计算机应用能力考试情况:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherComputer" value="${readTeacher.utpHighTeacherComputer }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">近五年年度考核结果:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherAssessment" value="${readTeacher.utpHighTeacherAssessment }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">进修情况:<span>*</span></td>
            <td><input type="text" name="utpHighTeacher.utpHighTeacherRefresher" value="${readTeacher.utpHighTeacherRefresher }"></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">年资情况</th>
        </tr>
        <tr>
            <td id="mingcheng">年资情况:<span>*</span></td>
            <td><textarea name="utpHighTeacher.utpHighTeacherSeniority" rows="5" cols="50">${readTeacher.utpHighTeacherSeniority }</textarea></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">教学情况</th>
        </tr>
        <tr>
            <td id="mingcheng">教学情况:<span>*</span></td>
            <td><textarea name="utpHighTeacher.utpHighTeacherTeaching" rows="5" cols="50">${readTeacher.utpHighTeacherTeaching }</textarea></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">学术成果</th>
        </tr>
        <tr>
            <td id="mingcheng">学术成果:<span>*</span></td>
            <td><textarea name="utpHighTeacher.utpHighTeacherAcademic" rows="5" cols="50">${readTeacher.utpHighTeacherAcademic }</textarea></td>
            <td id="beizhu"></td>
        </tr>
   </table>
   <input type="hidden" name="utpHighTeacher.utpHighTeacherIdCard" value="${session.HighTeacher.utpHighTeacherIdCard}"> 
   <input type="hidden" name="utpHighTeacher.utpHighTeacherName" value="${session.HighTeacher.utpHighTeacherName}">
   <br/>
   <div align="center"><input type="submit" class="btn btn-success" value="提交" style="text-align: center;"></div>
</s:form>
</body>
</html>