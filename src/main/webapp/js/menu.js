var sidebarMenu = angular.module('sidebarMenu', ['ngRoute'])
    .config(function ($locationProvider, $routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/partials/welcome.html'})
            .when('/todos', {templateUrl: '/partials/todos.html'})
            .when('/stocks', {templateUrl: '/partials/stocks.html'})
            .when('/portfolios', {templateUrl: '/partials/portfolios.html'})
            .when('/stockstream', {templateUrl: '/partials/stockstream.html'})
            .when('/monte', {templateUrl: '/partials/monte.html'})
            .when('/graphs', {templateUrl: '/partials/charts.html'})
            .otherwise({redirectTo: '/'})
    });

sidebarMenu.controller("MenuCtrl", function ($scope, $location, Menu) {
    $scope.menu = Menu;
    $scope.getClass = function (item) {
        if ($location.path() == item.href.substr(2)) {
            return "active"
        } else {
            return ""
        }
    }
});

sidebarMenu.directive("menu", function () {
    return {
        restrict: "A",
        template: '<ul class="nav nav-list">' +
        '<li class="nav-header">Menu</li>' +
        '<li ng-repeat="item in menu.items"><a href="{{item.href}}">{{item.name}}</a></li>' +
        '</ul>'
    }
});

sidebarMenu.factory('Menu', function () {
    var Menu = {};
    Menu.items = [
        {
            class: "",
            href: "/",
            name: "Home"
        },
        {
            class: "",
            href: "/#/todos",
            name: "Todos"
        },
        {
            class: "",
            href: "/#/stocks",
            name: "Stocks"
        },
        {
            class: "",
            href: "/#/portfolios",
            name: "Portfolios"
        },
        {
            class: "",
            href: "/#/stockstream",
            name: "Stock Stream"
        },
        {
            class: "",
            href: "/#/monte",
            name: "Monte Carlo Simulation"
        },
        {
            class: "",
            href: "/#/graphs",
            name: "Graphs"
        }
    ];
    return Menu;
});

