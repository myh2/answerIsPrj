$(document)
		.ready(
				function() {

					var emailCheckBtn = $("#email-check input[type='button']");
					var tokenCheckBtn = $("#code-check input[type='button']");
					var idCheckBtn = $("#id-check input[type='button']");
					var nicknameCheckBtn = $("#nickname-check input[type='button']");
					var password = $("#password input[type='password']");
					var passwordCheck= $("#password-check input[type='password']");
					var username = $("#username input[type='text']");
					var submitBtn = $("#sign-up-check input[type='submit']");
					
					var isEmailVerified = false;
					var isTokenVerified = false;
					var isIdVerified = false;
					var isNicknameVerified = false;
					var isusernameVerified = false;
					
					var verifiedEmail = null;
					var verifiedId = null;
					var verifiedNickName = null;
					
					var changeStatusVerified = function(target){
						target.attr("src", "../../resource/images/verified.png")
					};
					
					var changeStatusNotVerified = function(target){
						target.attr("src", "../../resource/images/not-verified.png")
					};
					
					emailCheckBtn.click(function() {
						
						var newEmail = $("#email-check input[type='text']").val();
						var inputEmail = $("#email-check input[name='email']");
						var verificationImg = $("#email-check img");

						if (newEmail == "") {
							alert("이메일을 입력해주세요");
							changeStatusNotVerified(verificationImg);
						} else {							
							var reg_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{2,5}$/;
							var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
							// 인자 email_address를 정규식 format 으로 검색
							
							if (newEmail.search(reg_email) == -1) {
								alert("이메일 형식이 맞지 않습니다.");
								changeStatusNotVerified(verificationImg);
								$("#email-check input[type='text']").val("");
								return false;
							}
							
							$.ajax({
								type : "GET",
								url : "email-check",
								data : "newEmail=" + newEmail,
								success : function(responseText) {
									if (responseText == true) {
										alert("인증메일이 발송되었습니다. 발송에 1~2분 정도 소요될 수 있습니다.");
										
										$.ajax({
											type : "POST",
											url : "sign-up-email-token",
											data : "email=" + newEmail,
											success : function() {
												isEmailVerified = true;
												changeStatusVerified(verificationImg);
											},
											fail : function() {
												alert("메일 발송을 실패하였습니다.");
												changeStatusNotVerified(verificationImg);
											}
										});
										
									} else {
										alert("이메일이 중복됩니다. 다른 이메일을 입력해 주세요.");
										changeStatusNotVerified(verificationImg);
										inputEmail.prop("value", "");
									}
								},
							});
							
						}
					});

					tokenCheckBtn.click(function() {

						var token = $("#code-check input[type='text']").val();
						var email = $("#email-check input[type='text']").val();
						var verificationImg = $("#code-check img");

						// alert(code);
						if (token == "") {
							alert("인증번호를 입력해주세요");
							changeStatusNotVerified(verificationImg);
						}else{
						
						$.ajax({
							type : "POST",
							url : "sign-up-token-check",
							data : "email=" + email + "&" + "token=" + token,
							success : function(responseText) {

								if (responseText == "success") {
									verifiedEmail = email;
									isTokenVerified = true;
									alert("인증이 완료되었습니다.");
									changeStatusVerified(verificationImg);
								} else {
									alert("인증번호를 확인해주세요.");
									changeStatusNotVerified(verificationImg);
								}
							},
							fail : function() {
								alert("다시 입력해주세요.");
								changeStatusNotVerified(verificationImg);
							}
						});
						}

					});

					idCheckBtn.click(function() {
						var inputID = $("#id-check input[name='id']");
						var newID = inputID.val();
						var verificationImg = $("#id-check img");

						if (newID == "") {
							alert("아이디를 입력해 주세요.")
							changeStatusNotVerified(verificationImg);
						} else {
							$.ajax({
								type : "GET",
								url : "id-check",
								data : "newID=" + newID,
								success : function(responseText) {
									if (responseText == true) {
										isIdVerified = true;
										verifiedId = newID;
										alert("사용 가능한 아이디입니다.");
										changeStatusVerified(verificationImg);
									} else {
										alert("아이디가 중복됩니다.");
										changeStatusNotVerified(verificationImg);
										inputID.prop("value", "");
									}
								},
							});
						}
					});

					nicknameCheckBtn
							.click(function() {
								var inputNickName = $("#nickname-check input[name='nickname']");
								var newNickName = inputNickName.val();
								var verificationImg = $("#nickname-check img");

								if (newNickName == "") {
									alert("닉네임을 입력해 주세요.");
									changeStatusNotVerified(verificationImg);
								} else {
									$.ajax({
										type : "GET",
										url : "nickname-check",
										data : "newNickName=" + newNickName,
										success : function(responseText) {
											if (responseText == true) {
												isNicknameVerified = true;
												verifiedNickName = newNickName;
												alert("사용 가능한 닉네임입니다.");
												changeStatusVerified(verificationImg);
											} else {
												alert("닉네임이 중복됩니다.");
												changeStatusNotVerified(verificationImg);
												inputNickName.prop("value", "");
											}

											
										},
									});
								}

							});
					
					password.on("keyup", function() {

						function chkPwd(str) {

							var pw = str;
							var num = pw.search(/[0-9]/g);
							var eng = pw.search(/[a-z]/ig);
							var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
							var verificationImg = $("#password img");

							if (pw.length < 8 || pw.length > 20) {
								changeStatusNotVerified(verificationImg);
								return false;
							}

							if (pw.search(/₩s/) != -1) {
								changeStatusNotVerified(verificationImg);
								return false;
							}
							if (num < 0 || eng < 0 || spe < 0) {
								changeStatusNotVerified(verificationImg);
								return false;
							}
							changeStatusVerified(verificationImg);
							return true;
						}

						if (!chkPwd($.trim(password.val()))) {
							password.focus();
							return false;
						}
					});

					passwordCheck.on("keyup", function() {
						
						var verificationImg = $("#password-check img");

						if (password.val() != passwordCheck.val()) {
							changeStatusNotVerified(verificationImg);
							passwordCheck.focus();
							return false;

						} else if (password.val() == null) {
							changeStatusNotVerified(verificationImg);
							password.focus();
							return false;
						}
						changeStatusVerified(verificationImg);
						return true;
					});
					
					
					username.on("keyup", function() {
						
						var verificationImg = $("#username img");

						if (username.val() == "") {	
							changeStatusNotVerified(verificationImg);
							return false;
						} else {
							changeStatusVerified(verificationImg);
							isNicknameVerified = true;
							return true;
						}

					});
					
					submitBtn.click(function(event) {
						
						var currentEmail = $("#email-check input[name='email']").val();
						var currentEmailCode = $("#code-check input[name='email-code']").val();
						var currentId = $("#id-check input[name='id']").val();
						var currentNickName = $("#nickname-check input[name='nickname']").val();
						var currentPassword = $("#password input[name='password']").val();
						var currentPasswordCheck = $("#password-check input[name='password-check']").val();
						var currentUserName = $("#username input[name='username']").val();
						
						var inputElements = [currentEmail, currentEmailCode, currentId, currentNickName,
						                    currentPassword, currentPasswordCheck, currentUserName];						              
						
						for (var i=0; i<inputElements.length; i++) {
							if (inputElements[i] == "") {
								event.preventDefault();
								alert ("입력되지 않은 값이 있습니다.");
								return false;
							}
						}
							
						if (isEmailVerified != true) {
							event.preventDefault();
							alert("이메일 확인을 진행해 주세요.");
						} else if (isTokenVerified != true) {
							event.preventDefault();
							alert("인증번호 확인을 진행해 주세요.");
						} else if (isIdVerified != true) {
							event.preventDefault();
							alert("ID 중복체크를 진행해 주세요.");
						} else if (isNicknameVerified != true) {
							event.preventDefault();
							alert("닉네임 중복체크를 진행해 주세요.") 
						} else if (isNicknameVerified != true) {
							event.preventDefault();
							alert("이름을 입력해 주세요")
						} else {
							if (verifiedEmail != currentEmail) {
								event.preventDefault();
								alert("이메일이 변경되었습니다. 이메일을 확인해 주세요");
							} else if (verifiedId != currentId) {
								event.preventDefault();
								alert("아이디가 변경되었습니다. 아이디를 확인해 주세요");
							} else if (verifiedNickName != currentNickName) {
								event.preventDefault();
								var verificationImg = $("#nickname-check img");
								
								alert("닉네임이 변경되었습니다. 닉네임을 확인해 주세요");
							} else {
								alert("아이디가 등록되었습니다.");
							}
						}
						
					});
						
				});