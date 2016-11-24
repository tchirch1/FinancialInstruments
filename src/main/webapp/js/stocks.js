/**
 * Author: Per Spilling, per@kodemaker.no
 */
var myApp = angular.module('stocks', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
});

myApp.factory('StocksResource', function ($resource) {
    return $resource('/api/stocks', {}, {});
});

function StockCtrl($scope, StocksResource, $dialog) {
    $scope.stockForm = {
        stock: {}
    };
    $scope.stockList = StocksResource.query();

    $scope.saveStock = function (stock) {
        if (stock != undefined) {
            var save = StocksResource.save(stock);
            var promise = save.$promise;
            if (promise == undefined) {
                promise = save;
            }
            promise.then(function () {
                $scope.stockForm.stock = {};
                $scope.stockList = StocksResource.query();
            });
        }
    };
    $scope.clearForm = function () {
        $scope.stockForm.stock = {}
    };
    $scope.editStock = function (stock) {
        $scope.stockForm.stock = stock;
    }
    $scope.deleteStock = function (stock) {
        var msgBox = $dialog.messageBox('You are about to delete a stock from the database', 'This cannot be undone. Are you sure?', [
            {label: 'Yes', result: 'yes'},
            {label: 'Cancel', result: 'no'}
        ]);
        msgBox.open().then(function (result) {
            if (result === 'yes') {
                StocksResource.delete({id: stock.id}).$promise.then(function () {
                    $scope.stockList = StocksResource.query();
                });
            }
        });
    }
}
