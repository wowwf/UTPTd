/**
 * 管理员添加人事审核人员
 */
$(document).ready(function() {
	//增加添加审核人员表单
	$("#add").click(function() {
		if (!$("#infomation").length > 0) {
			if ($("#selectinfo").length > 0) {
				$("#selectinfo").remove();
			}
			var str = "<center id='infomation'><form id='addform' action='adminconter.action?sel=1' theme='simple' method='post' onsubmit='return val()'>"+
				"<table style='text-align: right;'>" +
				"<caption>审核人员信息添加</caption>" +
				"<tr>" +
				"<td>" +
				"<span id='mc'>身份证:</span>" +
				"</td>" +
				"<td>" +
				"<input type='text' name='card' maxlength='18' onkeyup='this.value=this.value.replace(/[^\d]/g,'')'>" +
				"</td>" +
				"</tr>" +
				"<tr>" +
				"<td>" +
				"<span id='mc'>姓名:</span>" +
				"</td>" +
				"<td>" +
				"<input type='text' name='name'>" +
				"</td>" +
				"</tr>" +
				"<tr>" +
				"<td>" +
				"<span id='mc'>密码:</span>" +
				"</td>" +
				"<td>" +
				"<input type='password' id='onePass'>" +
				"</td>" +
				"</tr>" +
				"<tr>" +
				"<td>" +
				"<span id='mc'>再次输入密码:</span>" +
				"</td>" +
				"<td>" +
				"<input type='password' name='password'>" +
				"</td>" +
				"</tr>" +
				"<tr>" +
				"<td>" +
				"<span id='mc'>权限:</span>" +
				"</td>" +
				"<td  style='text-align: left;'>" +
				"<select name='role'>" +
				"<option value='2' selected='selected'>--请选择--</option>" +
				"<option value='0'>院系审核人员</option>" +
				"<option value='1'>人事审核人员</option>" +
				"</s:select>" +
				"</td>" +
				"</tr>" +
				"</table>" +
				"<input type='submit' value='提交'>" +
				"</form></center>";
			$("#addTable").append(str);
		} else {
			alert("表格已存在！");
		}
		
	});
	//增加查询人员表单
	$("#select").click(function() {
		if (!$("#selectinfo").length > 0) {
			if ($("#infomation").length > 0) {
				$("#infomation").remove();
			}
			var str = "<center id='selectinfo'>" +
					"<form action='adminconter.action' theme='simple'>" +
					"<input type='hidden' name='sel' value='3'>" +
					"<table>" +
					"<tr>" +
						"<th>身份证号码</th>" +
						"<th>操作</th>" +
					"<tr>" +
					"<tr>" +
						"<td><input type='text' name='card'></td>" +
						"<td><input type='submit' value='查找'></td>" +
					"</tr>" +
					"</table>" +
					"</form>" +
					"</center>";
			$("#addTable").append(str);
		} else {
			alert("查询表单已存在！")
		}
	});
	
});
function val() {
	var flag = false;
	var reg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
	var idcard = $("input[name='card']").val();
	if ($("input[name='card']").val() == "") {
		$("#errors").text("身份证号码不能为空！");
		flag = false;
	} else if (reg.test(idcard) == true) {
		var year = idcard.substr(6, 4);
		var month = idcard.substr(10, 2);
		var day = idcard.substr(12, 2);
		if (month > 12 || day > 31) {
			$("#errors").text("身份证格式不对");
			flag = false;
		} else if (month == 02 && day > 28) {
			$("#errors").text("身份证月份格式不对");
			flag = false;
		} else {
			$("#errors").text("");
			flag = true;
		}
	} 
	if (reg.test(idcard) == false){
		$("#errors").text("身份证格式不对");
		flag = false;
	} else if ($("input[name='name']").val() == "") {
		$("#errors").text("姓名不能为空！");
		flag = false;
	} else if ($("#input[name='password']").val() == "") {
		$("#errors").text("重复密码不能为空！");
		flag =  false;
	} else if ($("#onePass").val() == "") {
		$("#errors").text("密码不能为空！");
		flag =  false;
	} else if (!$("#onePass").val() == $("#input[name='password']").val()) {
		$("#errors").text("两次密码不同！");
		flag = false;
	} else if ($("select[name='role']").val() == 2) {
		$("#errors").text("请选择权限！");
		flag = false;
	} else {
		$("#errors").text("");
		flag =  true;
	}
	return flag;
}