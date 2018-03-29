$(document).ready(
		function() {

			var replyBtn = $("#buttons input[value='답장']");
			var delBtn = $("#buttons input[value='삭제']");

			
			replyBtn.click(function() {
				var chk = $(this).is(":checked");
				if (chk) $(".checkboxes input").prop('checked', true);
				else $(".checkboxes input").prop('checked', false);
				
			});
			
			
			delBtn.click(function() {
				var tbody = document.querySelector(".mList"); 
				var chboxs = tbody.querySelectorAll(".checkboxes input:checked");
				
				//밖으로 빼지 않고 안으로 넣는 이유는.. 밖에서 한번 만들면 삭제할 때마다 새로 만들까? 아니다.
				//그래서 삭제 동작을 할 때마다 셀렉티을 새로 해줘야 하는거지.
				//alert(chboxs.length);
				var data = "";
				for(var i=0;i<chboxs.length;i++){
					if(chboxs[i].checked){
						if(data !="")
							data+="&";
						data += "c="+chboxs[i].dataset.value;
						//tbody.removeChild(chboxs[i].parentNode.parentNode);
					};
				};
//alert(data);
				var request = new XMLHttpRequest();
				request.open("POST", "/AnswerisPrj/main/messagebox/sent-delete", true);
				request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
				request.onreadystatechange = function(){
					if(request.readyState==4){
					};			
				};			
				request.send(data);	  
				top.document.location.reload(true);
		 });
			
			
			
			
			
			
		});
