/**
 * 
 */
const app = angular.module("app", []);
app.controller("covid", function($scope, $http){
	$scope.items=[];
	 $scope.inttialize = function(){
        
    	$http.get("https://covid---phone-default-rtdb.firebaseio.com/covid-phone.json").then(resp=>{
    	 $scope.items = resp.data;
    	 console.log("Thanhcong", resp);
    	})
    }

    $scope.inttialize();
})