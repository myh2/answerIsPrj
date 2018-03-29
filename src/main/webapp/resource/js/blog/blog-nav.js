$(document).ready(function() {

	var btnClose= $("#close");
	var btnOpen= $("#open");

	// 스타일 조작
	btnClose.click(function(){
		var menuClose = $("#blog-nav");
		
		var style2={
			"margin-left": "-80%"
		};
		$("#screen").remove();

		menuClose.animate(style2, 250, function(){
		});	
		$(document).unbind("scroll mousewheel touchmove");
	});
	
	
	btnOpen.click(function(event){
		var menuOpen = $("#blog-nav");
		      
		var style1 = {
				"margin-left": "0px"
	      };
		$("body").append($("<div id='screen' style='background:black; opacity: 0.5;position:fixed; left:0px; top: 0px; width: 100%; height: 100%; z-index: 1' />"));
	      
	      menuOpen.animate(style1, 250, function(){
	      });	      
	      event.stopPropagation();
	      
	      btnClose2=$("#screen");
	      btnClose2.click(function(event) {
	  				btnClose.trigger("click");		
	  		});
	     $(document).on("scroll mousewheel touchmove", function(event){
	    	  event.preventDefault();
	    	  event.stopPropagation();
	      });

	});
	
});