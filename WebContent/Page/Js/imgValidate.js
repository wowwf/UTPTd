/**
 * 
 */
$(document).ready(function() {
	$("#upFile").change(function() {
		var filePath = $("input[name='upFile']").val();
		var extStart = filePath.lastIndexOf(".");
		var ext = filePath.substring(extStart, filePath.length).toUpperCase();
		if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
			$("#imgError").text("图片仅限于bmp,png,gif,jpeg,jpg格式");
			$("#fileType").text("");
			$("#fileSize").text("");
			return false;
		} else {
			$("#imgError").hide();
			$("#fileType").text(ext);
		}
		
		while (true) {
			if ($("input[name='upFile']")[0].size > 0) {
				if ($("input[name='upFile']")[0].size > 10 * 1024 * 1024) {
					$("#imgError").text("图片大小不能超过10M");
					$("#fileType").text(ext);
					$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / (1024 * 1024)).toFixed(3) + "MB");
					$("#fileType").show();
					$("#fileSize").show();
					return false;
				} else {
					$("#fileType").text(ext);
					if ($("input[name='upFile']")[0].files[0].size / 1024 > 10.24) {
						$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / (1024 * 1024)).toFixed(3) + "MB");
					} else {
						$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / 1024).toFixed(3) + "KB");
					}
					$("#fileType").show();
					$("#fileSize").show();
					return true;
				}
			} else {
				$("#fileType").hide();
				$("#fileSize").hide();
				return false;
			}
		}
	});
	$("form").submit(function() {
		var filePath = $("input[name='upFile']").val();
		if (filePath == "") {
			$("#imgError").text("请选择一寸照片");
			$("#fileType").hide();
			$("#fileSize").hide();
			return false;
		} else {
			var extStart = filePath.lastIndexOf(".");
			var ext = filePath.substring(extStart, filePath.length).toUpperCase();
			if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
				$("#imgError").text("图片仅限于bmp,png,gif,jpeg,jpg格式");
				$("#fileType").hide();
				$("#fileSize").hide();
				return false;
			} else {
				if ($("input[name='upFile']")[0].size > 0) {
					if ($("input[name='upFile']")[0].size > 10 * 1024 * 1024) {
						$("#imgError").text("图片大小不能超过10M");
						$("#fileType").text(ext);
						$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / (1024 * 1024)).toFixed(3) + "MB");
						$("#fileType").show();
						$("#fileSize").show();
						return false;
					} else {
						$("#fileType").text(ext);
						if ($("input[name='upFile']")[0].files[0].size / 1024 > 10.24) {
							$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / (1024 * 1024)).toFixed(3) + "MB");
						} else {
							$("#fileSize").text(($("input[name='upFile']")[0].files[0].size / 1024).toFixed(3) + "KB");
						}
						$("#fileType").show();
						$("#fileSize").show();
						return true;
					}
				} else {
					$("#fileType").hide();
					$("#fileSize").hide();
					return false;
				}
			}
		}
	});
});