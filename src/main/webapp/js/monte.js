/**
 * Author: Per Spilling, per@kodemaker.no
 */
var myApp = angular.module('monte', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
}).controller('MonteCtrl', function($scope, $http) {
    var genericUrl = 'http://localhost:9000/api/montes/';
    $scope.getMontes = function () {
        var url = genericUrl+$scope.nValue+'/'+$scope.mValue;
        $http.get(url).then(function (response) {
            $scope.monteList = response.data;
        });
    }
});
