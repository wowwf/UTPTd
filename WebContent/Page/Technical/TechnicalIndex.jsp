<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%  String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/Page/Css/style.css" />
    <script type="text/javascript" src="<%=path %>/Page/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=path %>/Page/Js/bootstrap.js"></script>
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
    </style>
</head>
<body>
<s:form action="Technicalsubmit">
	<table class="table table-bordered table-hover definewidth m10" >
    	<thead>
    		<tr>
    			<th colspan="3" style="text-align: center;">帐号信息(请妥善保护好你的登陆信息)</th>
    		</tr>
    	</thead>
	     <tr>
            <td id="mingcheng">身份证号码:<span>*</span></td>
            <td><s:property value="#session.Technical.utpTechnicalIdCard"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">姓名:<span>*</span></td>
            <td><s:property value="#session.Technical.utpTechnicalName"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">个人基本信息</th>
        </tr>
        <tr>
            <td id="mingcheng">姓名:<span>*</span></td>
            <td><s:property value="#session.Technical.utpTechnicalName"/></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">性别:<span>*</span></td>
            <td>
            	<input type="radio" name="utpTechnical.utpTechnicalGender" value="1" checked="checked">男
            	<input type="radio" name="utpTechnical.utpTechnicalGender" value="0">女
            </td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">年龄:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalAge" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">出生日期:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalBirthday" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">参加工作时间:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalCareerBegin" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">毕业时间:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalGraduateTime" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">学历:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalEducation" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">毕业学校:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalCollege" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">所学专业:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalMajor" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">目前所任职务:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalPostNow" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">申报专业技术职务任职资格:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalDeclarePost" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">外语考试情况:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalCET" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">计算机应用能力考试情况:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalComputer" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">近五年年度考核结果:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalAssessment" value=""></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
            <td id="mingcheng">一寸照片:<span>*</span></td>
            <td><input type="text" name="utpTechnical.utpTechnicalPhotoUrl" value=""><input type="button" value="浏览照片..."></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">年资情况</th>
        </tr>
        <tr>
            <td id="mingcheng">年资情况:<span>*</span></td>
            <td><textarea name="utpTechnical.utpTechnicalSeniority" rows="5" cols="50"></textarea></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">工作业绩</th>
        </tr>
        <tr>
            <td id="mingcheng">工作业绩登记:<span>*</span></td>
            <td><textarea name="utpTechnical.utpTechnicalAchievement" rows="5" cols="50"></textarea></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">科研项目成果</th>
        </tr>
        <tr>
            <td id="mingcheng">科研项目成果录入:<span>*</span></td>
            <td><textarea name="utpTechnical.utpTechnicalResearch" rows="5" cols="50"></textarea></td>
            <td id="beizhu"></td>
        </tr>
        <tr>
        	<th colspan="3" style="text-align: center;">论文著作信息</th>
        </tr>
        <tr>
            <td id="mingcheng">论文著作信息录入:<span>*</span></td>
            <td><textarea name="utpTechnical.utpTechnicalResearch" rows="5" cols="50"></textarea></td>
            <td id="beizhu"></td>
        </tr>
   </table>
   <input type="hidden" name="utpTechnical.utpTechnicalIdCard" value="${session.Technical.utpTechnicalIdCard}">
   <input type="hidden" name="utpTechnical.utpTechnicalName" value="${session.Technical.utpTechnicalName}">
   <div align="center"><s:submit align="center" value="提交"></s:submit></div>
</s:form>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="add.html";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>