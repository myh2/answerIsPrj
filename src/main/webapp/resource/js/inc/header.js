/*--------------------------------------   헤더 메뉴 오픈 -----------------------------------*/
window.addEventListener("load", function(){
	
	var menuBtn = document.querySelector("#header-menu-btn");
	var menuInBtn = document.querySelector("#header-menu-in-btn");
	var menu = document.querySelector("#header-menu");
	var side = document.querySelector(".layout-side");
	

	var sw = document.body.scrollWidth;
	var ow = side.offsetWidth;
	menuBtn.onclick = function(){
		menu.style.display = "block";
		menu.style.height = document.body.scrollHeight+"px";
		menu.style.paddingLeft = ow + "px";
		menu.style.left = -ow + "px";
		menu.style.width = sw-ow-1 + "px";
	};
	menuInBtn.onclick = function(){

		menu.style.display = "none";

	};
	menu.onclick = function(event){
		if(event.target == menu){
		menu.style.display="none";
		}
	};
});

/*--------------------------------------   헤더 서치 오픈 -----------------------------------*/
window.addEventListener("load", function(){
	var searchBtn = document.querySelector("#header-search-btn");
	var search = document.querySelector("#header-search-form");
	var searchBackBtn = document.querySelector("#header-search-back-btn");
	var input = document.querySelector("#header-search-input");
	searchBtn.onclick = function(){
		search.style.display = "block";
		input.value="";
		input.focus();
		
	};
	searchBackBtn.onclick = function(){
		search.style.display = "none";
	};
});
/*--------------------------------------   헤더 탑 서치 소트 오픈  -----------------------------------*/
window.addEventListener("load", function(){
	var sortBtn = document.querySelector("#header-top-search-sort-btn");
	var sort = document.querySelector("#header-top-search-sort");
	
	sortBtn.onclick = function(event){
		if(sort.style.display == "inline-block"){
			sort.style.display = "none";
			event.target.style.background= "url('resource/images/main/sort-icon-before.png') no-repeat center";
			event.target.style.backgroundColor="white";
			event.target.style.backgroundSize="30px 30px";
		}
		else{
			sort.style.display = "inline-block";
			event.target.style.background= "url('resource/images/main/sort-icon-after.png') no-repeat center";
			event.target.style.backgroundColor="white";
			event.target.style.backgroundSize="30px 30px";
		}
	};
});
/*--------------------------------------   헤더 서치 소트 오픈  -----------------------------------*/
window.addEventListener("load", function(){
	var sortBtn = document.querySelector("#header-search-sort-btn");
	var sort = document.querySelector("#header-sort");
	
	sortBtn.onclick = function(event){
		if(sort.style.display == "inline-block"){
			sort.style.display = "none";
			event.target.style.background= "url('resource/images/main/sort-icon-before.png') no-repeat center";
			event.target.style.backgroundColor="white";
			event.target.style.backgroundSize="30px 30px";
		}
		else{
			sort.style.display = "inline-block";
			event.target.style.background= "url('resource/images/main/sort-icon-after.png') no-repeat center";
			event.target.style.backgroundColor="white";
			event.target.style.backgroundSize="30px 30px";
		}
	};
});
/*--------------------------------------   헤더 서치 소트 선택  -----------------------------------*/
window.addEventListener("load", function(){
	var lSortBtn = document.querySelectorAll(".language-sortbtn");
	var lSort = document.querySelectorAll(".language-sort");
	var pSortBtn = document.querySelectorAll(".platform-sortbtn");
	var pSort = document.querySelectorAll(".platform-sort");
	
	for(var i=0; i<lSortBtn.length; i++){
		lSortBtn[i].onclick = function(event){
			var sort =	event.target.nextSibling;
			if(sort.value == 0){
				sort.value = 1;
				event.target.style.color="white";
				event.target.style.background="#0066ff";
				event.target.style.border="3px solid #0066ff";
			}
			else if(sort.value == 1){
				sort.value = 0;
				event.target.style.color="#0066ff";
				event.target.style.background="white";
				event.target.style.border="3px solid #00ffff";
			}
		};
	}
	
	for(var i=0; i<pSortBtn.length; i++){
		pSortBtn[i].onclick = function(event){
			var sort =	event.target.nextSibling;
			if(sort.value == 0){
				sort.value = 1;
				event.target.style.color="white";
				event.target.style.background="#cc00ff";
				event.target.style.border="3px solid #cc00ff";
			}
			else if(sort.value == 1){
				sort.value = 0;
				event.target.style.color="#cc00ff";
				event.target.style.background="white";
				event.target.style.border="3px solid #cc99ff";
			} 
		};
	}
});

/*--------------------------------------   로그인 시 유져 정보 가져오기   -----------------------------------*/
$(document).ready(function(request){
	var headerContext = $("#header-context").attr("href");
	var nickName = $("#header-menu-user-nick");
	var level = $("#header-menu-user-level");
	var grade = $("#header-menu-user-grade");
	$.ajax({
		type : "GET",
		url : headerContext + "/header-member-ajax",
		success : function(responseText) {
			var member = jQuery.parseJSON(responseText);
			nickName.text(member.nickName);
			var exp =10;
			var userLevel=1;
			for(var i = 2; member.experience >= exp; i++ ){
				exp = exp + (i*i+10);
				userLevel = userLevel+1;
			}
			level.text("Lv  " + userLevel);
/*			grade.text(member.grade);*/
		}
	});
});

/*--------------------------------------   새로운 쪽지 가져오기   -----------------------------------*/
$(document).ready(function(request){
	var headerContext = $("#header-context").attr("href");
	var message = $("#header-menu-message-new");
	$.ajax({
		type : "GET",
		url : headerContext + "/header-message-new-ajax",
		success : function(responseText) {
			var newMessage = jQuery.parseJSON(responseText);
			message.text(newMessage.newCount);
			if(newMessage.newCount == "0"){
				message.css("background", "none");
				message.css("display", "none");
			}
		}
	});
});
	