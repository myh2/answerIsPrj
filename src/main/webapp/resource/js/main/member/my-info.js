$(document).ready(function() {

	var nicknameBtn = $("#nickname input[type='button']");
	var pwdBtn = $("#pwd input[type='button']");
	var fromPwd = $("#pwd input[name='fromPwd']");
	var toPwd1 = $("#pwd input[name='toPwd1']");
	var toPwd2 = $("#pwd input[name='toPwd2']");

	pwdBtn.click(function() {

		 function chkPwd(str) {

			var pw = str;
			var num = pw.search(/[0-9]/g);
			var eng = pw.search(/[a-z]/ig);
			var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

			if (pw.length < 8 || pw.length > 20) {
				alert("8자리 ~ 20자리 이내로 입력해주세요.");
				return false;
			}
			if (pw.search(/₩s/) != -1) {
				alert("비밀번호는 공백업이 입력해주세요.");
				return false;
			}
			if (num < 0 || eng < 0 || spe < 0) {
				alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
				return false;
			}
			return true;
		}

		if (!chkPwd($.trim(toPwd1.val()))) {
			toPwd1.val('');
			toPwd1.focus();
			return false;
		}
		
		if(toPwd2.val() != toPwd1.val()){
			toPwd2.val('');
			toPwd2.focus();
			alert("새 비밀번호가 일치하지 않습니다.");
		}
		
		if (fromPwd.val() == "" && toPwd1.val() == "" && toPwd2.val() == "") {
			alert("현재 비밀번호와 새 비밀번호를 모두 입력해 주세요.");
		} else if (toPwd1.val() == "" || toPwd2.val() == "") {
			alert("새 비밀번호를 입력해 주세요.");
		} else if (fromPwd.val() == "") {
			alert("현재 비밀번호를 입력해 주세요.");
		} else {
			$.ajax({
				type : "POST",
				url : "../member/change-pwd",
				data : "fromPwd=" + fromPwd.val() + "&&toPwd1=" + toPwd1.val(),
				success : function() {
				
						alert("비밀번호가 변경되었습니다.");
				},
				fail : function() {
					alert("비밀번호 변경에 실패하셨습니다.")
				}
			});
		}

	});

	nicknameBtn.click(function() {
		var inputNickName = $("#nickname input[name='nickname']");
		var newNickName = inputNickName.val();

		if (newNickName == "") {
			alert("닉네임을 입력해 주세요.");
		} else {
			$.ajax({
				type : "GET",
				url : "../login/nickname-check",
				data : "newNickName=" + newNickName,
				success : function(responseText) {
					if (responseText == true) {
						alert("사용 가능한 닉네임입니다.");
					} else {
						alert("닉네임이 중복됩니다.");
						inputNickName.prop("value", "");
					}
				},
			});
		}
	});
	
	
    $(function() {
        $("#imgInp").on('change', function(){
            readURL(this);
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }

          reader.readAsDataURL(input.files[0]);
          document.getElementById("blah").style.width="50px";

        }
    }

});
