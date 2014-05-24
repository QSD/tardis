'use strict';

angular.module('QSD.Tardis')

  .controller('MainCtrl', function($scope, $location, version) {

    console.log( "Inside main controller");

    $scope.$path = $location.path.bind($location);
    $scope.version = version;

    $scope.lights = [
        {
            name: "Aap",
            colour: "green"
        },
        {
            name: "Noot",
            colour: "orange"
        },
        {
            name: "Mies",
            colour: "red"
        }
    ];

  });
