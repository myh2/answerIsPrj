//$(document).ready(function() {
//
//	var submitBtn = $("#check-btn input[type='button']");
//	var pwdInput = $("#pwd input[type='text']");
//
//	submitBtn.click(function() {
//		if (pwdInput.val() == "") {
//			alert("비밀번호를 입력해 주세요.");
//		} else {
//			$.ajax({
//				type : "GET",
//				url : "../member/enter-myinfo-check",
//				data : "pwd=" + pwdInput.val(),
//				success : function(responseText) {
//					url:"../member/my-info"
//				},
//				fail : function() {
//					alert("올바른 비밀번호를 입력해주세요.");
//					inputNickName.prop("value", "");
//				}
//			});
//		}
//	});
//
//});



