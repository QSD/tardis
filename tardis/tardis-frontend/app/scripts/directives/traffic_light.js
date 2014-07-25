'use strict';

angular.module('QSD.Tardis')

  .directive('tardisTrafficLight', function() {


    return {
      restrict: 'AEC',
      scope: {
          light: '='
      },
      link: function( $scope ) {
        $scope.$watch( 'light', function() {
            $scope.light.state = $scope.light.state.toLowerCase();
        } );
      },
      templateUrl: "views/directives/traffic-light.html"
    };

  });
