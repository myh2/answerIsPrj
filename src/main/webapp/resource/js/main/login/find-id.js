$(document).ready(
		function() {

			var inputName = $("#name input[type='text']");
			var year = $("#birthday select[name='user_birth_year']");
			var month = $("#birthday select[name='user_birth_month']");
			var day = $("#birthday select[name='user_birth_day']");
			var submitBtn = $("#check input[type='button']");

			submitBtn.click(function() {
				if (inputName.val() == "") {
					alert("이름을 입력해주세요.");
				
				} else {

					$.ajax({
						type : "POST",
						url : "find-id-email",
						data : "name="+inputName.val()+"&year="+ year.val()+"&month="+month.val()+"&day="+day.val(),
						success : function(responseText) {
							if (responseText == "success") {
								alert("메일이 발송되었습니다.");
							} else {
								alert("발송을 실패하였습니다."+
										"이름 또는 생년월일을 확인해주세요");
							}
						},
						fail : function() {
							alert("다시 입력해주세요.")
						}
					});
				}

			});

		});
