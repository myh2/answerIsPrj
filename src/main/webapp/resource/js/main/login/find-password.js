$(document).ready(
		function() {

			var inputName = $("#name input[type='text']");
			var inputId = $("#id input[type='text']");
			var year = $("#birthday select[name='user_birth_year']");
			var month = $("#birthday select[name='user_birth_month']");
			var day = $("#birthday select[name='user_birth_day']");
			var submitBtn = $("#check input[type='button']");

			submitBtn.click(function() {
			
				if (inputId.val() == "") {
					alert("ID를 입력해주세요.");
				} else if (inputName.val() == "") {
					alert("이름을 입력해주세요.");
				} else if (inputName.val() == "" && inputId.val()=="") {
					alert("ID와 이름을 입력해주세요.");

				}

				else {

					$.ajax({
						type : "POST",
						url : "find-password-email",
						data : "id="+inputId.val()+"&name=" + inputName.val() + "&year="
								+ year.val() + "&month=" + month.val()
								+ "&day=" + day.val(),
						success : function(responseText) {
							if (responseText == "success") {
								alert("메일이 발송되었습니다.");
							} else {
								alert("발송을 실패하였습니다.");
							}
						},
						fail : function() {
							alert("다시 입력해주세요.")
						}
					});
				}

			});
		});
