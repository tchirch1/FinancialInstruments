angular.module('AngularChart', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
}).factory('MonteResourcer', function ($resource) {
    return $resource('/api/montes', {}, {});
})
    .directive('chart', function () {
        return {
            restrict: 'E',
            template: '<div></div>',
            transclude: true,
            replace: true,
            scope: '=',
            link: function (scope, element, attrs) {
                console.log('oo', attrs, scope[attrs.formatter]);
                var opt = {
                    chart: {
                        renderTo: element[0],
                        type: 'line',
                        marginRight: 130,
                        marginBottom: 40
                    },
                    title: {
                        text: attrs.title,
                        x: -20 //center
                    },
                    subtitle: {
                        text: attrs.subtitle,
                        x: -20
                    },
                    xAxis: {
                        //categories:['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                        tickInterval: 1,
                        title: {
                            text: attrs.xname
                        }
                    },
                    plotOptions: {
                        lineWidth: 0.5
                    },
                    yAxis: {
                        title: {
                            text: attrs.yname
                        },
                        tickInterval: (attrs.yinterval) ? new Number(attrs.yinterval) : null,
                        max: attrs.ymax,
                        min: attrs.ymin
                    },
                    tooltip: {
                        formatter: scope[attrs.formatter] || function () {
                            return '<b>' + this.y + '</b>'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: -10,
                        y: 100,
                        borderWidth: 0,
                        hide: true
                    }
                };


                //Update when charts data changes
                scope.$watch(function (scope) {
                    return JSON.stringify({
                        xAxis: {
                            categories: scope[attrs.xdata]
                        },
                        series: scope[attrs.ydata]
                    });
                }, function (news) {
                    news = JSON.parse(news);
                    if (!news.series)return;
                    angular.extend(opt, news);
                    var chart = new Highcharts.Chart(opt);
                });
            }
        }

    });
function MainCtrl($scope, MonteResourcer) {
    $scope.monteList = MonteResourcer.query();
    $scope.monteList.$promise.then(function (result) {
        $scope.monteList = result;
        console.log($scope.monteList);
        $scope.lineChartYData = add2D(180, result);
        $scope.lineChartXData = toArray(result[0]);
    });
}
function toArray(arr) {
    var arr2 = [];
    for (var i = 0; i < 30; i++) {
        arr2.push(arr[i])
    }
    return arr2;
}
function add2D(count, result) {
    var arr = [];
    for (var i = 1; i < count; i++) {
        arr.push({"name": "Sample " + i, "data": toArray(result[i])});
    }
    return arr;
}
