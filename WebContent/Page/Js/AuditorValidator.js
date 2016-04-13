function showTo() {
	alert("登录规则\n"+
		"1.审核人员登录请使用账号及密码\n"+
		"2.待审核人员登录请使用账号及姓名");
}
function idVal(){
	var id = document.getElementById("IdCard").value;
	if (id.length == 0) {
		document.getElementById("IdCard").style.color = "red";
	}
}
function idFocus() {
	document.getElementById("IdCard").style.color = "#222";
}
function passFocus() {
	document.getElementById("password").style.color = "#222";
}
function passVal() {
	var psd = document.getElementById("password").value;
	if (psd.length == 0) {
		document.getElementById("password").style.color = "red";
	}
}
function checkPost() {
	var post = document.getElementById("Post").value;
	if (post == 4) {
		alert("请选择相应职位");
	}
}
function Val() {
	var id = document.getElementById("IdCard").value;
	var pass = document.getElementById("password").value;
	if (id.length == 0 || pass.length == 0) {
		alert("身份证号码和密码不能为空！");
		idVal();
		passVal();
		return false;
	} else {
		return true;
	}
}


