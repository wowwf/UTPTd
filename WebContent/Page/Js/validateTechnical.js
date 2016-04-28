/**
 * 验证技术人员填写信息
 */
$(document).ready(function() {
	$(":radio").mouseover(function() {
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
		var selectsex = $("input[name='utpTechnical.utpTechnicalGender']:checked").val();
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
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
		var selectsex = $("input[name='utpTechnical.utpTechnicalGender']:checked").val();
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
	$("input[name='utpTechnical.utpTechnicalAge']").blur(function() {
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
		var age = $("input[name='utpTechnical.utpTechnicalAge']").val();
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
	$("input[name='utpTechnical.utpTechnicalBirthday']").blur(function() {
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
		var birthday = idcard.substring(6,14);
		var birth = $("input[name='utpTechnical.utpTechnicalBirthday']").val();
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
	$("input[name='utpTechnical.utpTechnicalCareerBegin']").blur(function() {
		var work = $("input[name='utpTechnical.utpTechnicalCareerBegin']").val();
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
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
	$("input[name='utpTechnical.utpTechnicalGraduateTime']").change(function() {
		var gradute = $("input[name='utpTechnical.utpTechnicalGraduateTime']").val();
		var idcard = $("input[name='utpTechnical.utpTechnicalIdCard']").val();
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
	$("select[name='utpTechnical.utpTechnicalEducation']").blur(function() {
		var education = $("select[name='utpTechnical.utpTechnicalEducation']").val();
		if ($.trim(education) == "无") {
			$("#eduError").css({color:"red"});
			$("#eduError").html("请选择学历");
		} else {
			$("#eduError").css({color:"green"});
			$("#eduError").html("√");
		}
	});
	$("input[name='utpTechnical.utpTechnicalPostNow']").blur(function() {
		var post = 	$("input[name='utpTechnical.utpTechnicalPostNow']").val();
		if ($.trim(post) == "") {
			$("#postError").css({color:"red"});
			$("#postError").html("必填");
		} else {
			$("#postError").css({color:"green"});
			$("#postError").html("√");
		}
	});
	$("input[name='utpTechnical.utpTechnicalDeclarePost']").blur(function() {
		var declarePost = $("input[name='utpTechnical.utpTechnicalDeclarePost']").val();
		if ($.trim(declarePost) == "") {
			$("#decPostError").css({color:"red"});
			$("#decPostError").html("必填");
		} else {
			$("#decPostError").css({color:"green"});
			$("#decPostError").html("√");
		}
	});
	$("form").submit(function() {
		if ($.trim($("input[name='utpTechnical.utpTechnicalAge']").val()) == "") {
			alert("年龄不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalBirthday']").val()) == "") {
			alert("出生日期不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalCareerBegin']").val()) == "") {
			alert("参加工作时间不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalGraduateTime']").val()) == "") {
			alert("毕业时间不能为空！");
			return false;
		} else if ($("select[name='utpTechnical.utpTechnicalEducation']").val() == "无") {
			alert("请选择学历");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalCollege']").val()) == "") {
			alert("毕业院校不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalMajor']").val()) == "") {
			alert("所学专业不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalPostNow']").val()) == "") {
			alert("当前职务不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalDeclarePost']").val()) == "") {
			alert("需要申报的职称不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalCET']").val()) == "") {
			alert("外语考试不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalComputer']").val()) == "") {
			alert("计算机应用考试成绩不能为空！");
			return false;
		} else if ($.trim($("input[name='utpTechnical.utpTechnicalAssessment']").val()) == "") {
			alert("年度考核不能为空！");
			return false;
		}else if ($.trim($("textarea[name='utpTechnical.utpTechnicalAchievement']").val()) == "") {
			alert("工作业绩不能为空，没有工作业绩请填无！");
			return false;
		} else if ($.trim($("textarea[name='utpTechnical.utpTechnicalResearch']").val()) == "") {
			alert("科研项目成果不能为空，没有科研项目成果请填无！");
			return false;
		} else if ($.trim($("textarea[name='utpTechnical.utpTechnicalResearch']").val()) == "") {
			alert("论文著作不能为空，没有论文著作请填无！");
			return false;
		} else {
			return true;
		}
		
	});
	
	
});