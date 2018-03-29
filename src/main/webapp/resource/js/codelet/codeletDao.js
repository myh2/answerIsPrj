angular.module("codeletDao",[]).factory("codeletDao",["$http",function($http){
	
	var getsAsync = function(callback){
				
	};
	
	var gets=function(){
		var list=[];
		var request=new window.XMLHttpRequest();
		request.open("GET",'../../codeletJSON',false);
		request.send();
		
		list=JSON.parse(request.responseText);
		return list;
	};
	
	var getLists=function(){
		var list=[];
		var request=new XMLHttpRequest();
		request.open("GET",'../../codeletJSONAjax',false);
		request.send();
		
		list=JSON.parse(request.responseText);
		return list;
	};
	
	return {
		gets : gets,
		getsAsync : getsAsync,
		getLists: getLists
	};
}]);