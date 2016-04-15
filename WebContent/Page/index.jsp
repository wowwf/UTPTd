<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath(); %>
<%String basePath = request.getScheme() + "://"
		   + request.getServerName() + ":" + request.getServerPort()
		   + path + "/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="<%=path %>/Page/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="<%=path %>/Page/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="<%=path %>/Page/assets/css/main-min.css" rel="stylesheet" type="text/css" />
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${session.Auditor.utpAuditorName } ${session.HighTeacher.utpHighTeacherName} ${session.Technical.utpTechnicalName}
    </span><a href="Quit.action" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        		<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">参加评审</div></li>	
        		<!-- <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>  -->      
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="<%=path %>/Page/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="<%=path %>/Page/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="<%=path %>/Page/assets/js/common/main-min.js"></script>
  <script type="text/javascript" src="<%=path %>/Page/assets/js/config-min.js"></script>
  <script>
    BUI.use('common/main',function(){
    	var postlog = "${session.HighTeacher}";
    	var postlog1 = "${session.Technical}";
    	var postlog2 = "${session.Auditor}";
    	if (!postlog.length == 0) {
         	var config = [{id:'1',menu:[{text:'评审表填写',items:[{id:'12',text:'教师职称申请',href:'Scope.action?no=1'},{id:'3',text:'一寸照片上传',href:'ImgScope?no=1'},{id:'4',text:'其他佐证上传',href:'Teacher/TeacherOthers.jsp'},{id:'6',text:'申请表预览',href:'ShowInfo.action?no=1'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'/Node/index.html'}]}]}];
		} 
    	if (!postlog1.length == 0 ) {
         	var config = [{id:'1',menu:[{text:'评审表填写',items:[{id:'12',text:'技术人员职称申请',href:'Scope.action?no=2'},{id:'3',text:'一寸照片上传',href:'ImgScope?no=2'},{id:'4',text:'学术论文上传',href:'Technical/TechnicalOther.jsp'},{id:'6',text:'申请表预览',href:'ShowInfo.action?no=2'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'/Node/index.html'}]}]}];
		}
    	if (!postlog2.length == 0) {
         	var config = [{id:'1',menu:[{text:'评审资料',items:[{id:'12',text:'审核表检索',href:'Scope.action?no=3'},{id:'3',text:'管理',href:'ImgScope?no=3'},{id:'4',text:'还不知道做什么用',href:'/User/index.html'},{id:'6',text:'申请表预览',href:'/Menu/index.html'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'/Node/index.html'}]}]}];
		}
    	if (postlog == 0 && postlog1 == 0 && postlog2 == 0) {
    		window.top.location.href = "<%=basePath%>Page/AALogin.jsp";
    	}
     	new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
  <s:debug></s:debug>
 </body>
</html>