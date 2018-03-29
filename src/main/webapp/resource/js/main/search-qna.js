
var maainAppModule = angular.module("mainad",["ngSanitize"]);
	
	
maainAppModule.controller('mainqna-controller',function($scope, $http)   {   
	var count=0;
		
//더보기 기능
      $scope.addClick = function() {
    	
            count++;
            //alert(document.querySelector("#search-term"));
            
            $http({
            
            method : 'POST',
            url : 'menuJSON',
            params:  {keyword:document.querySelector("#search-term").value, count:count},
            headers:{'Content-Type':'application/json; charset-utf-8'}
         }).then(function successCallback(response) {
            $scope.nList = response.data;
            //angular.element('#pager1').trigger('click');
                        
         });
         
           
      };
      //스크롤 기능
      /*$(window).scroll(function(){  
         
            if  (($(window).scrollTop() == $(document).height() - $(window).height()) && count < 2 ){  
               
               if(count<3)
                            
               $scope.addClick();
               
            }  
            
            if(count >= 2){
             
               $("#add-btn").removeClass("hidden");
            }
      
         });  
         */
         
});
      
      
      
      