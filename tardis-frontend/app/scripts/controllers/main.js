'use strict';

angular.module('QSD.Tardis')

    .controller('MainCtrl',  ['$scope', 'Restangular', function($scope, Restangular) {

        console.log( "Inside main controller");
        console.log( Restangular );

        Restangular.all( 'lights.json').getList().then( function(result) {
            $scope.lights = result;
        });

        console.log( "End of controller" );

}]);
