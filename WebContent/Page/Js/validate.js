/**
 * 验证
 */
$(document).ready(function() {
	$(":radio").mouseover(function() {
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var selectsex = $("input[name='utpHighTeacher.utpHighTeacherGender']:checked").val();
		var se = idcard.substring(idcard.length - 2, idcard.length - 1);
		if (se % 2 == 1) {
			if (0 == selectsex) {
				$("#sexError").css({color:"red"});
				$("#sexError").html("性别与身份证号码不符");
			} else {
				$("#sexError").css({color:"green"});
				$("#sexError").html("√");
			}
		} else {
			if (1 == selectsex) {
				$("#sexError").css({color:"red"});
				$("#sexError").html("性别与身份证号码不符");
			} else {
				$("#sexError").css({color:"green"});
				$("#sexError").html("√");
			}
		}
	});
	$(":radio").change(function() {
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var selectsex = $("input[name='utpHighTeacher.utpHighTeacherGender']:checked").val();
		var se = idcard.substring(idcard.length - 2, idcard.length - 1);
		if (se % 2 == 1) {
			if (0 == selectsex) {
				$("#sexError").css({color:"red"});
				$("#sexError").html("性别与身份证号码不符");
			} else {
				$("#sexError").css({color:"green"});
				$("#sexError").html("√");
			}
		} else {
			if (1 == selectsex) {
				$("#sexError").css({color:"red"});
				$("#sexError").html("性别与身份证号码不符");
			} else {
				$("#sexError").css({color:"green"});
				$("#sexError").html("√");
			}
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherAge']").blur(function() {
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var age = $("input[name='utpHighTeacher.utpHighTeacherAge']").val();
		var year = idcard.substring(6, 10);
		var now = new Date().getFullYear();
		if (age == null) {
			$("#ageError").css({color:"red"});
			$("#ageError").html("年龄不能为空");
		} else if (age != (now - year)) {
			$("#ageError").css({color:"red"});
			$("#ageError").html("年龄和身份证不符合");
		} else {
			$("#ageError").css({color:"green"});
			$("#ageError").html("√");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherBirthday']").blur(function() {
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var birthday = idcard.substring(6,14);
		var birth = $("input[name='utpHighTeacher.utpHighTeacherBirthday']").val();
		var reg = /^[1-9]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$/;
		if (reg.test(birth) == true) {
			if (birth.split("-")[1] < 10) {
				if (birth.split("-")[2] < 10) {
					var btr = birth.split("-")[0] + "0" + birth.split("-")[1] + "0" + birth.split("-")[2];
				} else {
					var btr = birth.split("-")[0] + "0" + birth.split("-")[1] + birth.split("-")[2];
				}
			} else {
				if (birth.split("-")[2] < 10) {
					var btr = birth.split("-")[0] + birth.split("-")[1] + "0" +birth.split("-")[2];
				} else {
					var btr = birth.split("-")[0] + birth.split("-")[1] + birth.split("-")[2];
				}
			}
			if (btr == birthday) {
				$("#birthError").css({color:"green"});
				$("#birthError").html("√");
			} else {
				$("#birthError").css({color:"red"});
				$("#birthError").html("日期和身份证不符");
			}
		} else {
			$("#birthError").css({color:"red"});
			$("#birthError").html("请使用YYYY-MM-DD格式输入");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherCareerBegin']").blur(function() {
		var work = $("input[name='utpHighTeacher.utpHighTeacherCareerBegin']").val();
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var bityear = idcard.substring(6,14);
		var year = new Date().getFullYear();
		var month = new Date().getMonth();
		var day = new Date().getDate();
		var reg = /^[1-9]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$/;
		if (reg.test(work) == true) {
			if (work.split("-")[0] < year && work.split("-")[0] >= (bityear + 18)) {
				$("#workError").css({color:"green"});
				$("#workError").html("√");
			} else if (work.split("-")[0] == year) {
				if (work.split("-")[1] <= month) {
					$("#workError").css({color:"green"});
					$("#workError").html("√");
				} else if (work.split("-")[1] == month + 1) {
					if (work.split("-")[2] <= day) {
						$("#workError").css({color:"green"});
						$("#workError").html("√");
					} else {
						$("#workError").css({color:"red"});
						$("#workError").html("日期不合法");
					}
				} else {
					$("#workError").css({color:"red"});
					$("#workError").html("日期不合法");
				}
			} else {
				$("#workError").css({color:"red"});
				$("#workError").html("日期不合法");
			}
		} else {
			$("#workError").css({color:"red"});
			$("#workError").html("请使用YYYY-MM-DD格式输入");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherGraduateTime']").change(function() {
		var gradute = $("input[name='utpHighTeacher.utpHighTeacherGraduateTime']").val();
		var idcard = $("input[name='utpHighTeacher.utpHighTeacherIdCard']").val();
		var bityear = idcard.substring(6,14);
		var year = new Date().getFullYear();
		var month = new Date().getMonth();
		var day = new Date().getDate();
		var reg = /^[1-9]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$/;
		if (reg.test(gradute) == true) {
			if (gradute.split("-")[0] < year && gradute.split("-")[0] >= (bityear + 18)) {
				$("#graduError").css({color:"green"});
				$("#graduError").html("√");
			} else if (gradute.split("-")[0] == year) {
				if (gradute.split("-")[1] <= month) {
					$("#graduError").css({color:"green"});
					$("#graduError").html("√");
				} else if (gradute.split("-")[1] == month + 1) {
					if (gradute.split("-")[2] <= day) {
						$("#graduError").css({color:"green"});
						$("#graduError").html("√");
					} else {
						$("#graduError").css({color:"red"});
						$("#graduError").html("日期不合法");
					}
				} else {
					$("#graduError").css({color:"red"});
					$("#graduError").html("日期不合法");
				}
			} else {
				$("#graduError").css({color:"red"});
				$("#graduError").html("日期不合法");
			}
		} else {
			$("#graduError").css({color:"red"});
			$("#graduError").html("请使用YYYY-MM-DD格式输入");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherEducation']").blur(function() {
		var education = $("input[name='utpHighTeacher.utpHighTeacherEducation']").val();
		if ($.trim(education) == "") {
			$("#eduError").css({color:"red"});
			$("#eduError").html("必填");
		} else {
			$("#eduError").css({color:"green"});
			$("#eduError").html("√");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherPostNow']").blur(function() {
		var post = 	$("input[name='utpHighTeacher.utpHighTeacherPostNow']").val();
		if ($.trim(post) == "") {
			$("#postError").css({color:"red"});
			$("#postError").html("必填");
		} else {
			$("#postError").css({color:"green"});
			$("#postError").html("√");
		}
	});
	$("input[name='utpHighTeacher.utpHighTeacherDeclarePost']").blur(function() {
		var declarePost = $("input[name='utpHighTeacher.utpHighTeacherDeclarePost']").val();
		if ($.trim(declarePost) == "") {
			$("#decPostError").css({color:"red"});
			$("#decPostError").html("必填");
		} else {
			$("#decPostError").css({color:"green"});
			$("#decPostError").html("√");
		}
	});
	$("form").sumbit(function() {
		
	});
	
	
});