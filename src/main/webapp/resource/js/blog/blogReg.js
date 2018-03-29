
$(document).ready(function(){
	
	initEditor("textarea");
	
	
	
	var titleBox = $("#reg-title");
	
	titleBox.click(function(){
		if(titleBox.val()=="제목")
			titleBox.val("");		
	});
	
	titleBox.focusout(function(){
		if(titleBox.val()=="")
			titleBox.val("제목");
	});	

	if($(document).width()<='360'){
		$("#reg-setter").hide("slide", 1);
		var btnRightArrow=$("#regist-header ul .next-step");
		
		btnRightArrow.click(function(){
			$("#reg-setter").show("slide", 10);
		});
		
		$("#test li:first-child").click(function(){
			$("#reg-setter").hide("slide", 10);
		});
		
		var btnSubmitTrigger=$("#submit-btn-trigger");
		btnSubmitTrigger.click(function(){
			$(".btn-save.button").trigger("click");
		});
	};
	
	
	
	
});