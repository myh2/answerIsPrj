$(document).ready(
		function() {

			var inputId = $(".tf_tit input[type='text']");
			var inputText = $("#writeNote");
			var submitBtn = $("#check input[type='button']");
			var checkBox = $("#checkBox");
			
			checkBox.click(function(){				
			        var chk = $(this).is(":checked");
			        if(chk){
			        	
			        	inputId.val(checkBox.val());
			        	
			        }			        	
			         else inputId.val(""); 
			    });
			
/*			submitBtn.click(function() {
				//alert(inputText.val())
				
				if (inputId.val() == "") {
					alert("아이디를 입력해주세요.");
				
				}else if(inputText.val() == null ||inputText.val() ==""){
					alert("내용을 입력해주세요");
					
				}
				else if(inputText.val().length>1000){
					alert("1000자 이상 작성하실 수 없습니다.");	
				}
		
			
					else {
				
					$.ajax({
						type : "POST",
						url : "write-message-sender",
						data : "id="+inputId.val()+"&text="+inputText.val().replace(/[&]/, "＆"),
						success : function(responseText) {
							if (responseText == "success") {
								alert("쪽지가 발송되었습니다.");
								inputId.val("");
								inputText.val("");
							} else{
								alert("존재하지 않는 아이디입니다.");
							}
						},
						fail : function() {
							alert("다시 발송 해주세요.");
						}
					});
				}
			});
		*/
			inputText.on('input', function() {
				
			   $("#noteLen").html(inputText.val().length);
			   if(inputText.val().length>1000){
				   alert("1000자 이상 작성하실 수 없습니다.");				
			   }
			});


	
			
			

		});
