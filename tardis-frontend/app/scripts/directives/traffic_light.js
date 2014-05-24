'use strict';

angular.module('QSD.Tardis')

  .directive('tardisTrafficLight', function() {


    console.log( "Initializing the traffic light");

    return {
      restrict: 'AEC',
      scope: {
          light: '='
      },
      templateUrl: "views/directives/traffic-light.html"
    };

  });
