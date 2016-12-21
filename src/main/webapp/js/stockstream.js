'use strict';

/*================================================
 Module - for Controllers
 ================================================ */
angular.module('stockstream', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
})

    .controller('StockStreamCtrl', function ($scope, $http) {

        $scope.symbol = "";
        $scope.result = {};
        $scope.getData = function () {

            var url = "http://query.yahooapis.com/v1/public/yql";

            var symbol = $scope.symbol;
            console.log($scope.symbol);

            var data = encodeURIComponent("select * from yahoo.finance.quotes where symbol in ('" + $scope.symbol + "','GS','AAPL','TNXP','AMD','D')");

            /*
             Build the string to use with with $http get to retrieve JSON data from Yahoo Finance API
             Required format is:
             http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20('aapl')&format=json&diagnostics=true&env=http://datatables.org/alltables.env
             */
            var str1 = url.concat("?q=", data).concat("&format=json&diagnostics=true&env=http://datatables.org/alltables.env");

            $http.get(str1)

                .success(function (data) {
                    if (data.query.results == null) {
                        console.log("No Valid Results could be Returned!!")
                    }
                    else {
                        $scope.result = data.query.results.quote;
                        console.log($scope.result);
                    }
                })

                .error(function (data, status) {
                    $scope.result = "Request failed: " + status + ", " + data;
                });


        }
    });
