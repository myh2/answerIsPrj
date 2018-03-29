$(window).ready(function(){
	var btnOk = $("#btn-ok");
	  // alert("ready");
	
	btnOk.click(function(){
		   alert("ready1");
		   
		   $.getJSON("answersJSON", function(data){
			   alert(data[0].title);		   
			 
			   var target= $("#answer-all-table");
			   var dl = $("<dl />");
			   
			   for(var i=0; i< data.length ; i++)
			   {  
				   alert("ready3");
				   var ddcode = $("<dd class=\"code\">"+data[i].code+"</dd>")
				   var ddtitle = $("<dd class=\"title\">"+data[i].title+"</dd>");
				   var ddcontent = $("<dd class=\"content\">"+data[i].content+"</dd>");
				   var ddwriter = $("<dd class=\"writer\"/>"+data[i].memberid+"</dd>");
				   var ddhit = $("<dd class=\"hit\">"+data[i].hit+"</dd>");
				   var ddregdate = $("<dd class=\"regdate\">"+data[i].regdate+"</dd>");
				   var ddhashtag = $("<dd class=\"hashtag\">"+data[i].hashtag+"</dd>");
				   var ddlike = $("<dd class=\"like\">"+data[i].like+"</dd>");
				   var ddhate = $("<dd class=\"hate\">"+data[i].hate+"</dd>"); 
				
				   dl.append(ddcode);			
				   dl.append(ddtitle);			
				   dl.append(ddcontent);
				   dl.append(ddwriter);		
				   dl.append(ddhit);
				   dl.append(ddregdate);
				   dl.append(ddhashtag);
				   dl.append(ddlike);
				   dl.append(ddhate);
			   }	

	
			   dl.appendTo(target);
			   
		   });
	   });
	
	
/*	--------------------------------------------member-info-menu---------------------------------------------------*/
////////////////////////////////	
	$('.writer').click(function(event) {

	var divTop = event.pageY;
	var divLeft = event.pageX; 
	var obj = $(event.target);
	var context = $('.pageContext').val();
	var writerinfo = obj.val();
	var writerId;


	
		$.ajax({
			type : "GET",
			url : "qna-get-id",
			data : "nickname="+writerinfo,
			success : function(responseText) {
				writerId = responseText;
				$('#member-info').empty().append('<div style="position:absolute;top:5px;right:5px">'  
						+ '<div id="close"  style="cursor:pointer; padding-left:5px; padding-right:5px; padding-top:3px;font-size:15px;color:black; font-weight:bold; " >X</div> </div>'
						+ '<div id="writer-inf"><a href="">회원정보</a></div>'
						+ '<div id="writer-inf"><a href="'+context+'/'+writerId+'/main" >'+writerinfo+'\'s 블로그</a></div>'
						+ '<div id="writer-inf"><a href="'+context+'/main/messagebox/write-message?wh='+writerId+'">쪽지보내기</a></div>'
						+ '<div id="writer-inf"><a href="">신고하기</a></div>'
					);     
				
				$('#close').click(function(){
					document.getElementById('member-info').style.display='none'
				});
				
			},
			fail : function() {
				alert("error!!");
			}
		});
		
		$('#member-info').css({  
		     "top": divTop
		     ,"left": divLeft
		     ,"position": "absolute"
		   
		}).show(); 
	

	});

//////////////////////////////
	/*	--------------------------------------------상단으로 이동---------------------------------------------*/
	
	$(window).scroll(function () {
		if ($(this).scrollTop() > 100) {   
			$('#moveTop').fadeIn();   /*상단에서 100px 이상 이동하면 아이콘 보이기*/
		} else {
			$('#moveTop').fadeOut();
		}
	});
	
	$( '#moveTop' ).click( function() {
		  $( 'html, body' ).animate( { scrollTop : 0 }, 400 );  /*scrollTop 까지 400의 속도로 이동 - 숫자 작을수록 빨라짐*/
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
	                      matchContains: false,
	                      selectFirst: false
	                    });
	   
	
	/*	   ----------------------------------------- comment-list------------------------------------------------*/
	   
	   var comment = $(".comment > input");
		comment.click(function() { 
			var commentList = $("#comment-list"); 
			if (commentList.is(":visible")) {
				commentList.slideUp();
			} else {
				commentList.slideDown();
			}
			});
		
});


window.addEventListener("load", function() {
	var btnSubmit = document.querySelector(".btn-save");
	var data=null;
	var tbody= document.querySelector("#question-list tbody");
	var textarea = document.querySelector("#txtContent");
	var code = document.querySelector("#code-value").value;

	
	btnSubmit.onclick = function(){
		
		var content = encodeURIComponent(textarea.value);
		textarea.value="";
		
		//alert(code);
		//alert(content);
	//	var content = encodeURIComponent(document.querySelector("#txtContent").value);
		var csrf= document.querySelector(".article-comment > input[type='hidden']").value;
		//alert(csrf);
		data ="&content="+content+"&_csrf="+csrf;
		//alert(data);
		

		//-------비동기형 --------------------
		 var request = new XMLHttpRequest();
		 var urlregajx="qnacomment-reg-ajax?c="+code;
		  request.open("POST", urlregajx, true);
		  request.setRequestHeader("X-CSRF-TOKEN", csrf);
		  request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

		  request.onerror = function(){
			  alert("error");
		  };

	      request.onreadystatechange = function() {
	      
	    	  if (request.readyState == 4) {
	           //alert(request.responseText);
		           if(request.responseText==1){
		        	  	//1. 기존 목록 지우고
						
						var trs=tbody.querySelectorAll("tr");
						for(var i=0;i<trs.length;i++){
							tbody.removeChild(trs[i]);
						}
						//2. 새로운 목록을 채움.			
						getComment(code);
						
		           }
	 		}
	      };
	      
	      request.send(data);

		return false;  // submit의 전환을 막아주는 꼼수
	}
    
    function getComment(code){
		// var request = new XMLHttpRequest();
		 var request = new XMLHttpRequest();
		 var cmtjsonurl="qnaCommentJSON?c="+code;
		// alert(cmtjsonurl);
		  request.open("GET", cmtjsonurl, true);
		  request.onreadystatechange = function(){
		    if (request.readyState == 4) {
		    	//alert(request.responseText);
		    	var list;// = eval(request.responseText);
		    	
		    	//list = JSON.parse(request.responseText);
		    	try {
		    		list = eval(request.responseText);
		    	} catch (e) {
		    	    //console.log(e.lineNumber);
		    	    alert(e.message);
		    	}
	            //var list = eval(request.responseText);
	          
	            bind(list);
	 
	  	    }
		  };
		  request.send(null);
	 }  
    
    function bind(list){
          var template = document.querySelector("#comment-template");
          var td = document.createElement("td");
          var a = document.createElement("a");
          a.href = ""
	  	      for (var i = list.length-5 ; i < list.length; i++) {
	  	         var tr = document.importNode(template.content, true);
	  	         var tds = tr.querySelectorAll("td");
	  	         tds[0].textContent = list[i].nickName;
	  	         tds[1].textContent = list[i].content;
	  	         tds[2].textContent = list[i].regDate;
	  	       //  alert("111");
	  	         tds[3].firstChild.textContent = "수정";
	  	         tds[3].firstChild.href = "comment-edit?c=";
	  	         //tds[3].setAttribute('href','comment-edit?c=');
	  	         tds[4].firstChild.textContent = "삭제";
	  	         tds[4].firstChild.href = "comment-del?c=";
	  	         tds[5].firstChild.textContent = "신고";
	  	         tds[5].firstChild.href = "comment-charge?c=";
	  	        
	  	         tbody.appendChild(tr);

	  	      }  
    }
});


/////////////////////////  angular///////////////////////////////////////////
var questionsDetailAppModule= angular.module("qna",["ngAnimate"])
.controller('answers-detail-controller',function($scope,$http,$timeout){

		$scope.formVisible =false;

		
		$scope.write = function(){
			$scope.formVisible= true;
		
		}
	});

