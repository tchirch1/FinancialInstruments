/**
 * Author: Per Spilling, per@kodemaker.no
 */
var myApp = angular.module('monte', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
}).factory('MonteResource', function ($resource) {
    return $resource('/api/montes', {}, {});
});

function MonteCtrl($scope, MonteResource) {
    $scope.monteList = MonteResource.query();
    $scope.monteList.$promise.then(function (result) {
        $scope.monteList = result;
        console.log($scope.monteList);
    });
}
