var count = 0;
$(window).ready(function(){
	
/*	------------------------더보기 기능------------------------------------------------------*/

	$("#load-more input").unbind("click").bind("click",function() {
		count++;
		 
		var menujsonurl = "qMenuJSON?c="+count;
		$.getJSON( menujsonurl, function(data){
		  
			   var target= $(".question-all-table");
			   
			 // var div = $("<div />");
			   for(var i=0; i< data.length ; i++)
			   { 
				   var dl = $("<dl />");
				   var ddcode = $("<dd class=\"code\">"+data[i].code+"</dd>")
				   var ddtitle = $("<dd class=\"title\"><a href=\"questions-detail?c=" + data[i].blogCode+"\">"+data[i].title+"</a></dd>");
				  
				   /*var aTitle = $("<a href=\"question-detail?c=${n.blogCode}\">");*/
				   
				   var ddcontent = $("<dd class=\"content\"><a href=\"questions-detail?c=" + data[i].blogCode+"\">"+data[i].content+"</a></dd>");
				  // var ddwriter = $("<dd class=\"writer\">"+data[i].Nickname+"</dd>");
				   var ddmember=$("<dd id=\"member-menu\"></dd>");
				   var ddregdate = $("<dd class=\"regdate\">"+data[i].regdate+"</dd>");
				   var ddhit = $("<dd class=\"hit\">"+data[i].hit+"</dd>");
				   var ddhashtag = $("<dd class=\"hashtag\">"+data[i].hashtag+"</dd>");
				
				   dl.append(ddcode);			
				   dl.append(ddtitle);			
				 //  dl.append(ddwriter);	
				   dl.append(ddmember);		
				   dl.append(ddhit);
				   dl.append(ddregdate);
				   dl.append(ddcontent);
				   dl.append(ddhashtag);
				   dl.appendTo(target);
			   }
		   });
	   });
	
/*	--------------------------------------------member-info-menu---------------------------------------------------*/
	
	$('.writer').click(function(event) {
	
	var divTop = event.pageY;
	var divLeft = event.pageX; 
	
	$('#member-menu').empty().append('<div style="position:absolute;top:5px;right:5px">'  
			+ '<div id="close"  style="cursor:pointer; padding-left:5px; padding-right:5px; padding-top:3px;font-size:15px;color:gray; font-weight:bold; " >X</div> </div>'
			+ '<div id="writer-inf">회원정보</div>'
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
	
	$(window).scroll(function() {
	    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	       // alert('End of Window');
	    }
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
		  $( 'html, body' ).animate( { scrollTop : 0 }, 400 );  /*scrollTop 까지 400의 속도로 이동*/
		  return false;
		} );
	
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
	                      matchContains:false,
	                      selectFirst: false
	                    });
	   
/*	   ----------------------------------------- comment-list------------------------------------------------*/
	   
	   var comment = $(".comment>input");
		comment.click(function() {
			var commentList = $("#comment-list");
			if (commentList.is(":visible")) {
				commentList.slideUp();
			} else {
				commentList.slideDown();
			}
			});
	});





