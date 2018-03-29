/* -----------------------------     input  포커스      --------------------------------------------*/
window.addEventListener("load", function(){
	var input = document.querySelector("#search-input");
		input.value="";
		input.focus();	
});
/*--------------------------------------   서치 소트 오픈  -----------------------------------*/
window.addEventListener("load", function(){
	var sortBtn = document.querySelector("#search-sort-btn");
	var sort = document.querySelector("#sort");
	
	sortBtn.onclick = function(event){
		if(sort.style.display == "inline-block"){
			sort.style.display = "none";
			event.target.style.background = "url('resource/images/main/sort-icon-before.png') no-repeat center";
			event.target.style.backgroundColor = "white";
			event.target.style.backgroundSize = "30px 30px";
		}
		else{
			sort.style.display = "inline-block";
			event.target.style.background = "url('resource/images/main/sort-icon-after.png') no-repeat center";
			event.target.style.backgroundColor = "white";
			event.target.style.backgroundSize = "30px 30px";
		}
	};
});