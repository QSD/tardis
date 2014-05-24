'use strict';

angular.module('QSD.Tardis')

    .controller('MainCtrl',  ['$scope', 'backendService', function($scope, backendService) {

        console.log( "Inside main controller");


        backendService.getLights().then(function(result) {
            console.log( result );
            $scope.lights = result;

            console.log( "Got results" );
        });


        console.log( "End of controller" );
}]);
