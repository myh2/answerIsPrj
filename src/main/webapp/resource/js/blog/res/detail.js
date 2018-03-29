/**
 * 
 */


var detail = angular.module("detailApp", []);

detail.controller("detailController", function ($scope, $location){
	//var code = $location.search("c");
	$scope.test = function(){
		alert("tt");
	};
//	var config = {
//			params : {"code" : code}
//	}
	
//	$http.get("getLikeNum", config).then(function(response){
//		$scope.likeNum=response.data;
//	}, function(){
//		$scope.likeNum="tlqsldkfn";
//	});
//	
	
});