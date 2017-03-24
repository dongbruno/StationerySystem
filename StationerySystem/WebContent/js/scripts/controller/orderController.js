define(['app'], function(app){
	app.controller('orderCtrl', function($scope, $http){
		$scope.orderStationery =[];
		
		$scope.totalPrice = function(){
			var total = 0;
			angular.forEach($scope.orderStationery, function(item){
				if(item.quantity > 0 && item.quantity !==""){
					total += item.quantity*item.price;
				}
			});
			return total;
		}
		$scope.onblurs = function(quantity){
			$scope.$root.orderStationery.some(function(item, key){
				if(item.quantity < 1 || item.quantity ==""){
					var ans = confirm(item.name + "数量无效，是否移除该文具？");
					if(ans){
						$scope.remove(key);
					} else{
						item.quantity = 1;
					}
					return ;
				}
			})
		}
		
		$scope.totalQuantity = function(){
			var total = 0;
			angular.forEach($scope.orderStationery, function(item){
				if(item.quantity > 0 && item.quantity !==""){
					total += parseInt(item.quantity);
				}
			});
			return total;
		}
		
		$scope.remove = function(index){
			$scope.orderStationery.splice(index, 1);
		}
		
		$scope.saveOrder = function(){
			var order = "";
			$scope.orderStationery.some(function(item, key){
				order += item.stationeryId+":"+item.quantity+"_";
			});
			
			$http({
				method: 'POST',
				url: 'saveOrders',
				data: {
					'order': order
				},
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function(response){
				alert(response.data);
			}, function(err){
				alert(err);
			});
			$scope.modifyOrder();
		}
		$scope.isSaved = true;
		$scope.modifyOrder = function(){
			$scope.isSaved = !$scope.isSaved;
		}
		
		$scope.reduce = function(index){
			if($scope.orderStationery[index].quantity !=1){
				$scope.orderStationery[index].quantity--;
			} else{
				var ans = confirm("是否移除该商品？");
				if(ans){
					$scope.remove(index);
				} else {
					$scope.orderStationery[index].quantity = 1;
				}
			}
		}
		
		$scope.add = function(index){
			$scope.orderStationery[index].quantity++;
		}
		
		$http.get("getOrders",{
			"Accept": "application/json;charset=utf-8",
			"Accept-Charset": "charset=utf-8"
		}).then(function(response){
			$scope.orderStationery = response.data;
		}, function(err){
			console.log(err);
		});
	});
});