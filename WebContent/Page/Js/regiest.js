/**
 * 
 */
function inpntName() {
	var Name = document.getElementById("userName").value;
	if (Name.length == 0) {
		document.getElementsByName("userName").style.color = "red";
	}
}
function inputIdcard() {
	var pass = document.getElementById("idCard").value;
	if (pass.length == 0) {
		document.getElementsByName("idCard").style.color = "red";
	}
}
function checkPost() {
	var post = document.getElementById("Post").value;
	if (post == 2) {
		alert("请选择相应职位");
	}
}

function regiestSubmit() {
	var useName = document.getElementById("userName").value;
	var pass = document.getElementById("idCard").value;
	var post = document.getElementById("Post").value;
	if (useName.length == 0 || pass.length == 0 || post.length == 0) {
		inputIdcard();
		inputName();
		checkPost();
		return false;
	} else {
		return true;
	}
}