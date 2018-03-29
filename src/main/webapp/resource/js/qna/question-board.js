$(window).ready(function(){

	/*	----------------------------------------------search-auto-match-------------------------------------*/
	
	
	 var availableTags = [
	                      "ActionScript",
	                      "AppleScript",
	                      "Asp",
	                      "BASIC",
	                      "C",
	                      "C++",
	                      "Clojure",
	                      "COBOL",
	                      "ColdFusion",
	                      "Erlang",
	                      "Fortran",
	                      "Groovy",
	                      "Haskell",
	                      "Java",
	                      "JavaScript",
	                      "Lisp",
	                      "Perl",
	                      "PHP",
	                      "Python",
	                      "Ruby",
	                      "Scala",
	                      "Scheme",
	                      "자바",
	                      "자바스크립트",
	                      "안드로이드",
	                      "자바 배열",
	                      "CSS",
	                      "HTML",
	                      "HTML5"
	                    ];
	 
	                    $( "#search-form input[type='text']" ).autocomplete({
	                      source: availableTags,
	                      matchContains:true,
	                      selectFirst: false
	                    });
	                    

/*	--------------------------------------------상단으로 이동---------------------------------------------*/	                    
	                    
        $(window).scroll(function () {
    		if ($(this).scrollTop() > 100) {   
    			$('#moveTop').fadeIn();   /*상단에서 100px 이상 이동하면 아이콘 보이기*/
    		} else {
    			$('#moveTop').fadeOut();
    		}
    	});                
	                    
        $( '#moveTop' ).click( function() {
  		  $( 'html, body' ).animate( { scrollTop : 0 }, 400 );   /*scrollTop 까지 400의 속도로 이동*/
  		  return false;
  		} );
        
        
        /*	--------------------------------------------member-info-menu---------------------------------------------------*/

        $('.writer').click(function(event) {
       
        var divTop = event.pageY;
        var divLeft = event.pageX; 

        $('#member-menu').empty().append('<div style="position:absolute;top:5px;right:5px">'  
        		+ '<div id="close"  style="cursor:pointer; padding-left:5px; padding-right:5px; padding-top:3px;font-size:15px;color:gray; font-weight:bold; " >X</div> </div>'
        		+ '<div id="writer-inf"><a href="">회원정보</a></div>'
        		+ '<div id="writer-inf"><a href="" >블로그로 이동</a></div>'
        		+ '<div id="writer-inf"><a href="">작성한 게시글</a></div>'
        		+ '<div id="writer-inf"><a href="">쪽지보내기</a></div>'
        		+ '<div id="writer-inf"><a href="">신고하기</a></div>'
        	);                                       

        //$("#member-blog").attr("href", "../resource/WEB-INF/views/blog/main?mid=#{mid}");
        	
        $('#member-menu').css({  
        	     "top": divTop
        	     ,"left": divLeft
        	     , "position": "absolute"
        	}).show(); 

        	$('#close').click(function(){
        			document.getElementById('member-menu').style.display='none'
        	});
        });
        
        
 /*----------------------------------------------공지 숨기기---------------------------------------------*/
        var checkBox = $("input[type='checkbox']");
        var notice = $("tbody .writer");
        checkBox.click(function(){
        	if(checkBox.is(":checked"))
        		$("tbody .writer").each(function(){
        			if($(this).html() == '관리자')
        				$(this).parent().hide();
        		})
        	else
        		notice.parent().show();
        });
        
});



