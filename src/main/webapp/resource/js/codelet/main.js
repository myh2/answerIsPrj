$(document).ready(function() {

	var listLength = $("#listLength").val();

	for (var i = 0; i < listLength; i++) {
		ace.require("ace/ext/language_tools");
		var editorAce1 = ace.edit("code" + i);

		editorAce1.setReadOnly(true);
		editorAce1.focus();
		editorAce1.setOptions({
			enableBasicAutocompletion : true,
			enableSnippets : true,
			enableLiveAutocompletion : true
			/*maxLines:Infinity*/

		});

		var language = "";
		var modeset = "";

		language = $("#language" + i).val();
		modeset = "ace/mode/" + language;
		editorAce1.getSession().setMode(modeset);
		editorAce1.setTheme("ace/theme/monokai");
	}

/*---------------------즐겨찾기 버튼 구현------------------------------*/
	var favButtons=$("td").find("#fav");//즐겨찾기 버튼을 모두 선택하는 노드 순회
	var favButton= favButtons;
	favButton.click(function(event){//특정 즐겨찾기 버튼을 클릭 시
		var favVal=$(event.target).next().text();
		var code=$(event.target).next().next().text();
		var l=null;
		
		//ajax post요청으로 db에 Y/N을 바꿔줌
		$.ajax({ 
			  method: "POST",
			  url: "favorites",
			  data: {"code":code,
				  "data":favVal },
			  dataType:"text"
			});

		//기존의 노드를 삭제

		$(event.target).next().remove();

		//json으로 data를 load 함.
			$.ajax({
				dataType:"json",
				url:"codeletJSON",
				data:{"code":code},
				success:function(data){
				 l=eval(data);
				//tag를 생성하여 json으로 load한 데이터를 심어준다.				 
				 var tag="<span>"+l[0].favorite+"</span>";
				 $(event.target).after(tag);

				 if(l[0].favorite=="N"){
				 $(event.target).css("background","red");

				 }
				 else if(l[0].favorite=="Y"){
				 $(event.target).css("background","blue");

				 }
			}
		});
		
	});
	
	// $("#drop-menu > ul li").bind("click", function() {
	//
	// var lang = $(this).text();
	// $("#langlist-button").attr("value", lang+"▼");
	//
	// });
/*------------------미리보기------------------------------*/
	var previewArea = $("td").find("#preview");

	previewArea.click(function(event) {

		var codeVal = $(event.target).parent().parent().parent().parent().parent().next();
		codeVal.slideToggle(400);

	});

	//	------------------------copy

	var copyContent = $("#codelet-table");
	var copyBtn = $("td").find("#copy-button");

	copyBtn.click(function(event) {

		var copyVal = $(event.target).next().text();

		var copytext = $("<textarea>");

		$("main").append(copytext);
		copytext.val(copyVal).select();
		document.execCommand("copy");
		copytext.remove();
		alert("클립보드로 복사되었습니다");

	});


/*----------------------------	최근 본글을 확인하기 위한 버튼 구현------------*/
	//노드 선택
	var detailClick=$("td").find("#codelet-title");
	//이벤트 체크
	detailClick.click(function(event){
		//데이터 저장

		var code = $(event.target).next().text();
		//ajax post 요청으로 db에 기록
		$.ajax({
			method : "POST",
			url : "recent",
			data : {
				"code" : code
			},
			dataType : "text"
		});
	});

	/*------------해시태그를 클릭해서 검색 구현-----------------------*/
	var htClick=$("td").find("#ht");//노드 선택
	
	htClick.click(function(event){
		
		var hTagVal=$(event.target).next().text();
		hTagVal = hTagVal.slice(1,hTagVal.length);//#때문에 검색이 안되기 때문에 #부분을 빼준다.
		$(event.target).attr("href", "/AnswerisPrj/codelet?sortSelec=&select=hashtag&q="+hTagVal);//노드 속성 조작
		
	});
	
});


// ------------------------조회하는거 ㅋ

/*
 * var favList = $("#list > input:first-child");
 * var recList = $("#list >    * input:last-child");
 *
 * favList.click(function(){
 *
 * alert("즐찾"); $.ajax({ method: "GET", url: "fav-list",
 *
 * });
 *
 * });
 *
 * recList.click(function(){
 *
 * alert("최근"); $.ajax({ method: "GET", url: "rec-list",
 *
 * });
 *
 * });
 */

var codeletAppModule = angular.module("codelet", ["noticeDao"]);

codeletAppModule.controller('codelet-controller', function($scope,codeletDao) {

	$scope.list=codeletDao.gets();
	$scope.favList = function() {
		alert("즐찾");

		$http({
			method : 'GET',
			url : '../../customer/noticeJSON',
			params : {
				pg : page
			}
		}).then(function successCallback(response) {

			$scope.list = response.data;
		}, function errorCallback(response) {
			alert("즐찾실패");
		});

	};

	$scope.recList = function() {
		alert("최근");

		$http({
			method : 'GET',
			url : '../../customer/noticeJSON',
			params : {
				pg : page
			}
		}).then(function successCallback(response) {

			$scope.list = response.data;
		}, function errorCallback(response) {
			alert("최근실패");
		});

	};
	/*-------------------checkbox all선택--------------------*/
	$scope.checkAll=function(){
		alert("d");
		for(var i=0; i<$scope.list.length; i++){
			$scope.list[i].isChecked=$scope.all;
		}
	};
}); 