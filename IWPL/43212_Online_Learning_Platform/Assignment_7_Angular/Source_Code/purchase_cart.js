var app=angular.module('myapp',[]);
	app.controller('CartForm', function($scope)
    {
    $scope.cart = {
        items: []
    }

    $scope.addItem = function() {
        $scope.cart.items.push({ qty: document.getElementById("qty").value, description: document.getElementById("course").value, cost: document.getElementById("cost").value});
        document.getElementById("qty").value = "";
        document.getElementById("course").value = "";
        document.getElementById("cost").value = "";
    }

    $scope.removeItem = function(index) {
        $scope.cart.items.splice(index, 1);
    }

    $scope.total = function() {
        var total = 0;
        angular.forEach($scope.cart.items, function(item) {
            total += item.qty * item.cost;
        })
        return total;
    }
}
);
