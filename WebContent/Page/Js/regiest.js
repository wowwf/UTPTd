/**
 * 
 */
function inpntName() {
	var Name = document.getElementById("userName").value;
	if (Name.length == 0) {
		$("#showNameError").show();
		return false;
	} else {
		$("#showNameError").hide();
		return true;
	}
}
function inputIdcard() {
	var reg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
	var pass = document.getElementById("idCard").value;
	var year = pass.substr(6, 4);
	var month = pass.substr(10, 2);
	var day = pass.substr(12, 2);
	if (reg.test(pass) == false || month > 12 || day > 31) {
		$("#showIdError").show();
		return false;
	} else if (month == 02 && day > 28) {
		$("#showIdError").show();
		return false;
	} else {
		$("#showIdError").hide();
		return true;
	}
}
function checkPost() {
	var post = document.getElementById("Post").value;
	if (post == 2) {
		$("#showPostError").show();
		return false;
	} else {
		$("#showPostError").hide();
		return true;
	}
}

function regiestSubmit() {
	var useName = document.getElementById("userName").value;
	var pass = document.getElementById("idCard").value;
	var post = document.getElementById("Post").value;
	if (inpntName() == true && inputIdcard() == true && checkPost() == true) {
		return true;
	} else {
		
		return false;
	}
}