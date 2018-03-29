/**
 * 
 */


var detail = angular.module("detailApp", []);

detail.controller("detailController", function ($scope, $location,$http){
	
	
	$("#abcd").ready(function(){
		var likeNum = $("#like-num").text();
		var code =$("#get-code").text();
		$scope.$apply(function(){
			$scope.vv=likeNum;
			$scope.code=code;
		});
	});

	$scope.test = function(){
		alert($scope.vv);
		$http({
			method:"POST",
			url : "setLike-ajax",
			params: {
				code : $scope.code
			},
			headers:{'Content-Type':'application/json; charset-utf-8'}
		}).then(function(){
			$scope.vv = parseInt($scope.vv)+1;
		},function(){
			alert("두번 누르지 마")
		});	
	};
	
	$scope.more = function(){
		
	};
});
