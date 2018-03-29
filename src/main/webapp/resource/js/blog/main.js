$(document).ready(function(){
 
	 var loadBtn = $("#add-btn");
	$("#blog-contents").click(function(event){
		var article;
		if($(event.target).attr("class")=="bulletin-container")
			article=$(event.target);
		else			
			article= $(event.target).parents(".bulletin-container");
		var anchor = article.find("a");
		window.open(anchor.attr("href"), "_blank");
		//$(location).attr("href",anchor.attr("href"));
		event.stopPropagation();
	});
	
	
	moreComment=$("#btn-reply-more");
	   moreComment.click(function() {
	   
	      var href = $("#moreComment-href");
	      href.get(0).click();
	   
	   });
	
//자동더보기
	   /*$(window).scroll(function(){  
		   if  (($(window).scrollTop() == $(document).height() - $(window).height()) && count < 2 ){  
			   
			   if(count<3)
				   count++;
			   getList();
			   
		   }  
		   
		   if(count >= 2){
			   
			  
			   loadBtn.removeClass("hidden");
			   
		   }
		   
	   });  
	   
	   loadBtn.click( function(event) {
		   
		   count++;
		   getList();
		   
		   
	   });
	   
	   
	   function getList() {
		   
		   var request = new XMLHttpRequest();
		   
		   var path= $(location).attr("pathname");
		   if(path.substring(path.length-1)=='/')
			   path=path.substring(0,path.length-1)
		   if(path.substring(path.length-4)=='main')
			   path=path.substring(0,path.length-5);
		   //-----------------비동기형 요청------------
		   request.open("POST", path+"/menuJSON?bc="+count, true);
		   request.onreadystatechange=function(){
			   
			   if(request.readyState==4){
				  
				   var list = eval(request.responseText);
				   
				   bind(list);
				   
			   }
		   }
		   
		   
		   
		   request.send(null); 
		   
		   
	   }
	   
	   function bind(list) {
		   var template = document.querySelector("#blogMain-template");
		   var parentDiv = document.querySelector("#blog-contents");
		   
		   
		   for (var i = 0; i < list.length; i++) {
			   var temp = document.importNode(template.content, true);
			   
			   var divs = temp.querySelectorAll("div");
			   
			   
			   var divTitle = divs[1].querySelector("h1");
			   var divDate = divs[3];
			   var divLink = divs[4];
			   var divContent = divs[5];
			   var divTag = divs[6].querySelector("li");
			   var divLike = divs[4].querySelector("ul li:first-child");
			   var divComment = divs[8].querySelector("li:last-child");
			   var divModify = divs[4].querySelector("div:last-child ul li:first-child");
			   var divDelete = divs[4].querySelector("div:last-child ul li:last-child");
			   
			   var record = list[i];
			   
			   divTitle.textContent = record.title;
			   divDate.textContent = record.date;
			   divContent.textContent = record.content;
			   divTag.textContent = record.hashtag;
			   divLink.querySelector("a").setAttribute('href','detail?c='+record.code);
			   
			   parentDiv.appendChild(temp);
		   }
	   }
	   
	   */
	   
	
});



    
	  
    
    
	
	
	
	
	
	var blogAppModule = angular.module("blog", ["ngSanitize"]);
	count=0;
	blogAppModule.controller('blogSetController', [ '$scope', function($scope) {
			$scope.example = {
				text : 'category'
			};

			$scope.categoryEditFunction = function() {
				$scope.cetegory = text;
			}
			
			$scope.colors = [];
			$scope.myColor = $scope.colors[2];
	} ]);
	//detail에서 댓글 추가하기
	blogAppModule.controller("blog-controller", function($scope, $http, $timeout) 
	{
		$scope.content;
		$scope.blcode;
		
		//처음 댓글내용들
		$http({
			method : 'GET',
			url : 'blogCommentJSON',
			params:{c:document.querySelector("#blog-code").value}
		}).then(function successCallback(response) {
			
			$scope.list = response.data;
		}, function errorCallback(response) {

		});
		
		$scope.blogCode= function(code) {
			
			$http({
				method : 'GET',
				url : 'blogCommentJSON',
				params:{c:code}
			}).then(function successCallback(response) {
				
				$scope.list = response.data;
			}, function errorCallback(response) {

			});
		};
		
		
		$scope.regClick = function() {
		
		$http({
			method : 'POST',
			url : 'blogcomment-reg-ajax',
			params:  {content:$scope.content,blogCode:document.querySelector("#blog-code").value},
			headers:{'Content-Type':'application/json; charset-utf-8'}
		}).then(function successCallback(response) {
			
			$scope.list = response.data;
			//angular.element('#pager1').trigger('click');
			setTimeout(function(){
				
				document.querySelector("#codeBtn").click();
				document.querySelector("#comment-textarea").value="";
			}, 0);
			
		}, function errorCallback(response) {
			alert("로그인을 해주세요");
		});
	
		
		
	};
	
	
	//좋아요 갯수
	$http({
		method : 'GET',
		url : 'get-like',
		params:{blogCode:document.querySelector("#blog-code").value}
	}).then(function successCallback(response) {
		
		$scope.list = response.data;
	}, function errorCallback(response) {

	});
	
	
	//좋아요 추가하기
	});
	
	
	
	//메인 부분
	blogAppModule.controller("main-controller", function($scope, $http, $timeout) {
		
		
		//초기 메인 리스트 불러오기
//		$http({
//			method : 'GET',
//			url : 'mainJSON'
//			
//		}).then(function successCallback(response) {
//			
//		
//			$scope.mList = response.data;
//		}, function errorCallback(response) {
//
//		});
//		
		//좋아요 눌렀을때 등록
		$scope.likeClick = function(code) {
			
			$http({
				
				method : 'POST',
				url : 'setLike-ajax',
				params:  {code:code},
				headers:{'Content-Type':'application/json; charset-utf-8'}
			}).then(function successCallback(response) {
				
				
				//angular.element('#pager1').trigger('click');
				
			}, function errorCallback(response) {
				alert("로그인을 해주세요");
			});
		};
		
		
		
		//더보기 기능
		$scope.addClick = function() {
			
				count++;
				$http({
				
				method : 'POST',
				url : 'menuJSON',
				params:  {bc:count},
				headers:{'Content-Type':'application/json; charset-utf-8'}
			}).then(function successCallback(response) {
				
				$scope.mList = response.data;
				//angular.element('#pager1').trigger('click');
				
				
				
			}, function errorCallback(response) {
				alert("로그인을 해주세요");
			});
			
			
			
		};
		
		//스크롤 기능
		$(window).scroll(function(){  
			
			   if  (($(window).scrollTop() == $(document).height() - $(window).height()) && count < 2 ){  
				   
				   if(count<3)
					  
				   
				   $scope.addClick();
				   
			   }  
			   
			   if(count >= 2){
				 
				   $("#add-btn").removeClass("hidden");
			   }
			   
		   });  
		   
		   
		
		//좋아요 갯수
		/*$http({
			method : 'GET',
			url : 'get-like',
			params:{blogCode:document.querySelector("#blog-code").value}
		}).then(function successCallback(response) {
			
			$scope.list = response.data;
		}, function errorCallback(response) {

		});*/
		
		
		
		
	});
	
	/*blogAppModule.controller("tmp-main-controller", function($scope, $http, $timeout) {
		$scope.tmpLikeClick = function() {
			alert("dd");
		}
	})*/
