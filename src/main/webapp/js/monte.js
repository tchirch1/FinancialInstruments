/**
 * Author: Per Spilling, per@kodemaker.no
 */
angular.module('monte', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
}).controller('MonteCtrl', function ($scope, $http) {
    var genericUrl = 'http://localhost:9000/api/montes/';
    $scope.getMontes = function () {
        var url = genericUrl + $scope.nValue + '/' + $scope.mValue + '/10';
        $http.get(url).then(function (response) {
            $scope.timely = response.data.timeSeries;
            $scope.sim = response.data.simulation;
        });
    }
});
