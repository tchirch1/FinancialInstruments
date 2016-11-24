/**
 * Author: Per Spilling, per@kodemaker.no
 */
var myApp = angular.module('portfolios', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
});

myApp.factory('PortfoliosResource', function ($resource) {
    return $resource('/api/portfolios', {}, {});
});

function PortfolioCtrl($scope, PortfoliosResource, $dialog) {
    $scope.portfolioForm = {
        portfolio: {}
    };
    $scope.portfolioList = PortfoliosResource.query();

    $scope.savePortfolio = function (portfolio) {
        if (portfolio != undefined) {
            var save = PortfoliosResource.save(portfolio);
            var promise = save.$promise;
            if (promise == undefined) {
                promise = save;
            }
            promise.then(function () {
                $scope.portfolioForm.portfolio = {};
                $scope.portfolioList = PortfoliosResource.query();
            });
        }
    };
    $scope.clearForm = function () {
        $scope.portfolioForm.portfolio = {}
    };
    $scope.editPortfolio = function (portfolio) {
        $scope.portfolioForm.portfolio = portfolio;
    }
    $scope.deletePortfolio = function (portfolio) {
        var msgBox = $dialog.messageBox('You are about to delete a portfolio from the database', 'This cannot be undone. Are you sure?', [
            {label: 'Yes', result: 'yes'},
            {label: 'Cancel', result: 'no'}
        ]);
        msgBox.open().then(function (result) {
            if (result === 'yes') {
                PortfoliosResource.delete({id: portfolio.id}).$promise.then(function () {
                    $scope.portfolioList = PortfoliosResource.query();
                });
            }
        });
    }
}
