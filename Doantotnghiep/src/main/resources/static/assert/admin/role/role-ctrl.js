app.controller("role-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};


	$scope.inttialize = function() {
		$http.get("/rest/roles").then(resp => {
			$scope.items = resp.data;
		});

	}

	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {};

		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$("#us").attr("readonly", 'readonly');
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/roles`, item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới vai trò thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới vai trò!");
			console.log(error);
		});


	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/roles/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật vai trò thành công!");

		}).catch(error => {
			alert("Lỗi cập nhật vai trò!");
			console.log(error);
		});
	}

	$scope.delete = function(item) {

		$http.delete(`/rest/authorities/role/${item}`).then(resp => {
			console.log("chạy cái này đc hông")
		})

		$http.delete(`/rest/roles/${item}`).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa loại vai trò thành công!");

		}).catch(error => {
			alert("Lỗi xóa vai trò!");
			console.log(error);
		});
	}

	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}
});