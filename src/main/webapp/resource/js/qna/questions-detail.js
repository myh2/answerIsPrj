/*$(window).ready(function(){
	
	   ----------------------------------------- comment-list------------------------------------------------
	   
	   var comment1 = $("#comment1>input");
		comment1.click(function() {

			var commentList1 = $("#comment-list1");
			if (commentList1.is(":visible")) {
				commentList1.slideUp();
				comment1.attr("value","댓글 보기");
			} else {
				commentList1.slideDown();
				comment1.attr("value","댓글 닫기");
			}
			});
		
		   var comment2 = $("#comment2>input");
			comment2.click(function() {

				var commentList2 = $("#comment-list2");
				if (commentList2.is(":visible")) {
					commentList2.slideUp();
					comment2.attr("value","댓글 보기");
				} else {
					commentList2.slideDown();
					comment2.attr("value","댓글 닫기");
				}
				});
	});

*/
/*

var questionAppModule= angular.module("questions",[]);

questionAppModule.controller('question-controller',function($scope,$http,$timeout){
	
	$scope.formVisible =false;
	//댓글 초기화 ---------------------------
	$http({
		  method: 'GET',
		  url: '../../customer/noticeJSON',
		  
		}).then(function successCallback(response) {
		   $scope.list=response.data;
		  }, function errorCallback(response) {
		   
		  });
	//댓글 페이징---------------------
	$scope.pagerClick= function(page){
		alert(page);
		$http({
			  method: 'GET',
			  url: '../../customer/noticeJSON',
			  params:{pg:page}
			}).then(function successCallback(response) {
			   $scope.list=response.data;
			  }, function errorCallback(response) {
			   
			  });
	};
	
	
	//댓글 등록----------------
	$scope.regClick=function(){
		data = {title:$scope.title, content:$scope.content};			
		$http({
			  method: 'POST',
			  url: '../../customer/notice-reg-ajax',
			  data: data,
			  headers:{'Content-Type':'application/json; charset=utf-8'}
			}).then(function successCallback(response) {
				$timeout(function(){
					angular.element("#pager > ul > li:first-child > a").triggerHandler("click");
				},0);
				
			  }, function errorCallback(response) {
				  alert("실패");
				  alert(response.status +" : "+response.statusText);
			  });
	};
	// 댓글 보기------------------------
	$scope.write = function(){
		$scope.formVisible=true
	}
});*/


/*----------------질문 보기 ---------------------*/
var questionsDetailAppModule= angular.module("qna",["ngAnimate"])
.controller('questions-detail-controller',function($scope,$http,$timeout){

		$scope.formVisible =false;

		
		$scope.write = function(){
			$scope.formVisible= true;
		
		}
	});



/*	--------------------------------------------member-info-menu---------------------------------------------------*/
$(window).ready(function(){
	
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

});


/*-------------------댓글 달기----------------------------*/
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
