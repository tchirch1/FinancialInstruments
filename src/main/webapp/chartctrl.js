angular.module('AngularChart', ['ngResource', 'ui.bootstrap'], function ($dialogProvider) {
    $dialogProvider.options({backdropClick: false, dialogFade: true});
}).controller('MainCtrl', function($scope, $http) {
    var genericUrl = 'http://localhost:9000/api/montes';
    $scope.getChart = function () {
        var url = genericUrl + '?s0='+$scope.s0+'&size='+$scope.nValue +'&mValue='+$scope.mValue+'&time='+$scope.time;
        $http.get(url).then(function (response) {
            $scope.lineChartXData = toArray(response.data.timeSeries);
            $scope.lineChartYData = add2D(response.data.simulation);
        });
    }
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
                        tickInterval: 0.5,
                        title: {
                            text: attrs.xname
                        }
                    },
                    plotOptions: {
                        lineWidth: 0.2
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
                        borderWidth: 0
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
function toArray(arr) {
    var arr2 = [];
    for (var i = 0; i < arr.length; i++) {
        arr2.push(Math.round(arr[i]*100)/100);
    }
    return arr2;
}
function add2D(result) {
    var arr = [];
    for (var i = 0; i < result.length; i++) {
        arr.push({"name": "Sim " + (i+1), "data": toArray(result[i], result[i].length)});
    }
    return arr;
}
