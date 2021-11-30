app.controller("loaivaccin", function($scope, $http){
    $scope.items = [];
    $scope.country = [];
    $scope.form = {
    };

    $scope.inttialize = function(){
        $http.get("/rest/vaccine").then(resp => {
            $scope.items = resp.data;
            
     
        });
    	$http.get("https://api.covid19api.com/countries").then(resp=>{
    	 $scope.country = resp.data;
    	 console.log("Thanhcong", resp);
    	})
    }

    $scope.inttialize();

    $scope.reset = function(){
		$scope.form = {
			tenquocgia: 'Viet Nam'
		}
		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
        $("#create").removeAttr("disabled");
        $("#update").attr("disabled", 'disabled');
         $("#exampleInputId").removeAttr("readonly");
    }
    
    $scope.reset();

    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
        $("#us").attr("readonly", 'readonly');
        $("#create").attr("disabled", 'disabled');
        $("#update").removeAttr("disabled");
        $("#delete").removeAttr("disabled");
        $("#exampleInputId").attr("readonly", 'readonly');
    }

    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/vaccine`,item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới Vaccine thành công!");
			
		}).catch(error => {
			alert("Lỗi thêm mới vaccine!");
			console.log(error);
		});
    }

    $scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/vaccine/${item.idvacxin}`,item).then(resp => {
			var index = $scope.items.findIndex(p => p.idvacxin == item.idvacxin);
			$scope.items[index] = item;
			alert("Cập nhật vaccine thành công!");
			
		}).catch(error => {
			alert("Lỗi cập nhật vaccine!");
			console.log(error);
		});
    }

    $scope.delete = function(item){
		
		$http.delete(`/rest/vaccine/${item.idvacxin}`).then(resp => {
			var index = $scope.items.findIndex(p => p.idvacxin == item.idvacxin);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa vaccine thành công!");
			
		}).catch(error => {
			alert("Vaccine đã có đợt tiêm không thể xóa!");
			console.log(error);
		});
    }

    
  /*  $scope.pager = {
    	page: 0,
    	size: 10,
    	get items(){
    		var start = this.page * this.size;
    		return $scope.items.slice(start, start + this.size);
    	},
    	get count(){
    		return Math.ceil(1.0 * $scope.items.length / this.size);
    	},
    	first(){
    		this.page = 0;
    	},
    	prev(){
    		this.page--;
    		if(this.page < 0){
    			this.last();
    		}
    	},
    	next(){
    		this.page++;
    		if(this.page >= this.count){
    			this.first();
    		}
    	},
    	last(){
    		this.page = this.count - 1;
    	}
    }*/
});