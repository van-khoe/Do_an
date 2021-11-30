app.controller("user-ctrl", function($scope, $http) {
	$scope.link = 'user';
	$scope.items = [];
	$scope.order = [];
	$scope.form = {
		photo
			: 'cloud-upload.jpg'
	};

	$scope.autho = {
		account: {},
		role: {
			id: 'USER',
			name: 'User'
		}

	};

	$scope.inttialize = function() {
		$http.get("/rest/accounts/all").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.birthday = new Date(item.birthday)
			})
		});

	}

	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {
			birthday: new Date(),
			photo: 'cloud-upload.jpg'
		}

		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
		$("#us").attr("readonly", 'readonly');
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$scope.autho.account = angular.copy($scope.form);
		var index = $scope.items.findIndex(p => p.username == item.username);
		console.log(index);
		if (index < 0) {
			$http.post(`/rest/accounts`, item).then(resp => {
				resp.data.birthday = new Date(resp.data.birthday)
				$scope.items.push(resp.data);
				$scope.reset();
				alert("Thêm mới tài khoản thành công!");
				$http.post(`/rest/accounts/role`, $scope.autho).then(resp => {
				}).catch(error => {
					alert("Lỗi !");
					console.log(error);
				});

			}).catch(error => {
				alert("Lỗi thêm mới tài khoản!");
				console.log(error);
			});
		}
		else {
			alert("Tài khoản đã tồn tại!");
		}



	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts/${item.username}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.username == item.username);
			resp.data.birthday = new Date(resp.data.birthday)
			$scope.items[index] = item;
			alert("Cập nhật tài khoản thành công!");

		}).catch(error => {
			alert("Lỗi tài khoản sản phẩm!");
			console.log(error);
		});
	}

	$scope.delete = function(item) {

		$http.get(`/rest/orders/${item}`).then(resp => {
			$scope.order = resp.data;
			console.log($scope.order.length);
			if ($scope.order.length == 0) {

				$http.delete(`/rest/authorities/username/${item}`).then(resp => {
					$http.delete(`/rest/accounts/${item}`).then(resp => {
						var index = $scope.items.findIndex(p => p.username == item);
						$scope.items.splice(index, 1);
						$scope.reset();
						alert("Xóa tài khoản thành công!");

					}).catch(error => {
						alert("Lỗi xóa sản phẩm!");
						console.log(error);
					});
				});


			}
			else {
				alert("Người dùng đã từng mua hàng nên không thể xóa!");
			}
		}).catch(error => {
			console.log(error);
		});




	}

	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);

		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.photo = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
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